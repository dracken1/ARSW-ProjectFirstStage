
console.log(getCookie("username"));
var user;
var url = '/sessions/' + getCookie("username");
fetch(url, {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    }
})
    .then(response => response.json())
    .then(data => {
        console.log(data);
        user = data.user;
        console.log(user);
        document.getElementById('acciconandbuttonsiconnameid').innerHTML = "" + user.username;
        document.getElementById('accinfonameid').innerHTML = "Name: " + user.name + " " + user.lastname;
        document.getElementById('accinfoemailid').innerHTML = "Email: " + user.email;
    });

$('.genericbtn').click(function(){
    window.location.href = "practice.html";
});

$('.practicebtn').click(function(){
    window.location.href = "practice.html";
});

$('.htitle').click(function(){
    console.log(user);
    if (document.getElementById('extendeduserlogoid').clientHeight > 0){
        $("#extendeduserlogoid").animate({
            height: "toggle"
        },200);
    }
});
$('.hspace').click(function(){
    if (document.getElementById('extendeduserlogoid').clientHeight > 0){
        $("#extendeduserlogoid").animate({
            height: "toggle"
        },200);
    }
});
$('.middlebar').click(function(){
    if (document.getElementById('extendeduserlogoid').clientHeight > 0){
        $("#extendeduserlogoid").animate({
            height: "toggle"
        },200);
    }
});
$('.footerbar').click(function(){
    if (document.getElementById('extendeduserlogoid').clientHeight > 0){
        $("#extendeduserlogoid").animate({
            height: "toggle"
        },200);
    }
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
$("#settoptsid").click(function () {
    $("#settdisplayableid").animate({
        height: "toggle"
    },200);
});
$("#settexitbtnid").click(function(){
    $("#settdisplayableid").animate({
        height: "toggle"
    },200);
});
$("#insoptsid").click(function () {
    $("#instructdisplayableid").animate({
        height: "toggle"
    },200);
});
$("#instructexitbtnid").click(function(){
    $("#instructdisplayableid").animate({
        height: "toggle"
    },200);
});
$("#abooptsid").click(function () {
    $("#aboutdisplayableid").animate({
        height: "toggle"
    },200);
});
$("#aboutexitbtnid").click(function(){
    $("#aboutdisplayableid").animate({
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
            var salaId = salaDescripcion.descripcion;
            var cantidadJudadores = salaDescripcion.cantidadJugadores;
            if(cantidadJudadores==2){
                $("#tablaSalas tbody").append("<tr><td>Lobby "+ salaId +"</td><td>"+cantidadJudadores+"</td><td> <button style='background-color: darkred; color: white' class=\"genericbtn\" id=\"gnrbtnlft\">GAME FULL</button></td></tr>");
            }else{
                $("#tablaSalas tbody").append("<tr><td>Lobby "+ salaId +"</td><td>"+cantidadJudadores+"</td><td> <button onclick='cargaPage().unirseASala("+salaId+")' class=\"genericbtn\" id=\"gnrbtnlft\">JOIN GAME</button></td></tr>");
            }
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
            var username = getCookie("username");

            var usuarioJSON = {username: username};
            stompClient.send("/app/unirseASala."+salaId, {},JSON.stringify(usuarioJSON));
            stompClient.subscribe('/topic/salas',function (eventbody) {
                getSalas();
                window.location.href = "combat.html?id="+salaId;
            });
        },
        createLobby: function () {
            stompClient.send("/app/nuevaSala", {},null);
        },
        getCookies : getCookie()
    };

}
