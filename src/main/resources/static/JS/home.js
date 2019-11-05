


$('.genericbtn').click(function(){
    window.location.href = "juego.html";
});

function mousePressed(obj) {
    obj.style.backgroundColor = "#ad8b36";
}

function mouseReleased(obj) {
    obj.style.backgroundColor = "#F9D342";
}

function mouseHover(obj) {
    obj.style.backgroundColor = "#F9D342";
}

function mouseLeave(obj) {
    obj.style.backgroundColor = "#292826";
}

$("#haccountid").click(function () {
    $("#extendeduserlogoid").animate({
        height: "toggle"
    },200);
});

function getCookie(name) {
  var regexp = new RegExp("(?:^" + name + "|;\s*"+ name + ")=(.*?)(?:;|$)", "g");
  var result = regexp.exec(document.cookie);
  return (result === null) ? null : result[1];
}

$("#exitbtnid").click(function(){
    $("#accountdisplayableid").animate({
        height: "toggle"
    },200);
});

$("#accoptsid").click(function (){
   $("#accountdisplayableid").animate({
       height: "toggle"
   },200);
});

$("#outoptsiconid").click(function(){
    document.cookie = "username=; expires=Thu, 21 Aug 1970 20:00:00 UTC; path=/;"
    document.cookie = "; expires=Thu, 21 Aug 1970 20:00:00 UTC; path=/;"
    console.log(document.cookie);
    window.location.href = "index.html"
});


var cargaPage = function () {

    var dibujarLobby = function (tabla) {
        //alert(tabla);
        $("#tablaSalas tbody").empty(); // limpiar tabla

        tabla.map(function (salaDescripcion){
            //alert("siiiii");
            var salaId = salaDescripcion.descripcion;
            $("#tablaSalas tbody").append("<tr><td>Sala "+ salaId +"</td><td>0</td><td> <button onclick='cargaPage().unirseASala("+salaId+")' class=\"genericbtn\" id=\"gnrbtnlft\">JOIN GAME</button></td></tr>");

        })

    }
    var getSalas = function () {
        //alert("entro a get salas");
        var traerSalas = $.get("/Sala/get");
        traerSalas.then(function(salas) {
            //alert("antes de dibujar lobby");
            dibujarLobby(JSON.parse(salas));
        },function () {
            //alert("no sabemos si el alert este func");
        });
        return traerSalas;
    };
    getSalas();

    return{
        actualizarTabla: function () {
            var socket = new SockJS('/stompendpoint');
            stompClient = Stomp.over(socket);

            //subscribe to /topic/newpoint when connections succeed
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/salas',function (eventbody) {
                    getSalas();
                });
            });

        },
        unirseASala: function (salaId) {
            window.location.href = "juego.html?id="+salaId.toString();
        },
        createLobby: function () {
            stompClient.send("/app/nuevaSala", {},null);
        }
    };

}
