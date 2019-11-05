


var combatApp = function () {
    var getSalas = function (salaId) {
        var traerSalas = $.get("/Sala/getById."+salaId);
        traerSalas.then(function(salas) {
            enviarDatos(JSON.parse(salas));
        },function () {

        });
        return traerSalas;
    };

    var enviarDatos = function (tabla) {
        $("#tablaSalas tbody").empty(); // limpiar tabla
        tabla.map(function (salaDescripcion){
            var username = getCookie("username");
            var usuarioJSON = {username: username};
            var salaId = salaDescripcion.descripcion;
            alert("salaiddd = "+salaId);
            var cantidadJudadores = salaDescripcion.cantidadJugadores;
            alert(cantidadJudadores+"jugadorees");
            if(cantidadJudadores==1){
                document.getElementById("Jugador1").innerHTML = usuarioJSON.username;
            }else{
                document.getElementById("Jugador2").innerHTML = usuarioJSON.username;
            }
        })
    }

    function getCookie(name) {
        var regexp = new RegExp("(?:^" + name + "|;\s*"+ name + ")=(.*?)(?:;|$)", "g");
        var result = regexp.exec(document.cookie);
        return (result === null) ? null : result[1];
    }
    return{
        actualizarTetris: function () {
            var socket = new SockJS('/stompendpoint');
            stompClient = Stomp.over(socket);

            let params = new URLSearchParams(location.search);
            var salaId = params.get('id');
            alert(salaId);
            getSalas(salaId);
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/salas',function (eventbody) {

                });
            });
        }
    }
}
