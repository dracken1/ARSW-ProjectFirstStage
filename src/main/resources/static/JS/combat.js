


var combatApp = function () {
    var getNombres = function (salaId) {
        var traerSalas = $.get("/Sala/getById."+salaId);
        traerSalas.then(function(salas) {
            datosJugadores(JSON.parse(salas));
        },function () {

        });
        return traerSalas;
    };

    var getSalas = function (salaId) {
        var traerSalas = $.get("/Sala/getById."+salaId);
        traerSalas.then(function(salas) {
            enviarDatos(JSON.parse(salas));
        },function () {

        });
        return traerSalas;
    };

    var enviarDatos = function (tabla) {
        tabla.map(function (salaDescripcion){
            var username = getCookie("username");
            var usuarioJSON = {username: username};
            var salaId = salaDescripcion.descripcion;
            var cantidadJudadores = salaDescripcion.cantidadJugadores;
            var jugadoresActuales = salaDescripcion.jugadoresActuales;
            jugadoresActuales.map(function (jugador){
                if(cantidadJudadores==1){
                    document.getElementById("Player").innerHTML = "Local Player: "+jugador[0];
                    document.getElementById("Opponent").innerHTML = "Opponent: ";
                    document.getElementById("buttonP1").style.visibility = "visible";
                }else{
                    document.getElementById("Opponent").innerHTML = "Local Player: "+ jugador[1];
                    document.getElementById("Player").innerHTML = "Opponent: ";
                    document.getElementById("framePlayer").width=320;
                    document.getElementById("framePlayer").height=280;
                    document.getElementById("buttonP2").style.visibility = "visible";
                    //ahora agrandar mi frame
                    document.getElementById("frameOpponent").width=550;
                    document.getElementById("frameOpponent").height=510;
                }
            })
        })
    };

    var datosJugadores = function (tabla) {
        tabla.map(function (salaDescripcion){
            var username = getCookie("username");
            var usuarioJSON = {username: username};
            var salaId = salaDescripcion.descripcion;
            //alert("id de sala = "+salaId);
            var cantidadJudadores = salaDescripcion.cantidadJugadores;
            var jugadoresActuales = salaDescripcion.jugadoresActuales;
            //alert("jugadores = "+cantidadJudadores);
            //alert("activosJogadores = "+ jugadoresActuales);
            jugadoresActuales.map(function (jugador){
                if(cantidadJudadores==2) {
                    if (jugador[0] == usuarioJSON.username) {
                        document.getElementById("buttonP1").style.visibility = "visible";
                        document.getElementById("buttonP1").style.backgroundColor="#5eb313";
                        document.getElementById("Player").innerHTML = "Local Player: "+usuarioJSON.username;
                        document.getElementById("Opponent").innerHTML = "Opponent: "+jugador[1];
                    }else{
                        document.getElementById("buttonP2").style.visibility = "visible";
                        document.getElementById("buttonP2").style.backgroundColor="#5eb313";
                        document.getElementById("Opponent").innerHTML = "Local Player: "+usuarioJSON.username;
                        document.getElementById("Player").innerHTML = "Opponent: "+jugador[0];
                    }
                }
            })

        })
    };

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
            getSalas(salaId);
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/salas',function (eventbody) {

                });
            });
        },
        jugadorListo:function () {
            var username = getCookie("username");
            var usuarioJSON = {username: username};
            let params = new URLSearchParams(location.search);
            var salaId = params.get('id');
            stompClient.send("/app/usuariosEnSala."+salaId, {},JSON.stringify(usuarioJSON));
            stompClient.subscribe('/topic/salas',function (eventbody) {
                getNombres(salaId);
            });
        },
        abandonarSala:function () {
            var username = getCookie("username");
            var usuarioJSON = {username: username};
            let params = new URLSearchParams(location.search);
            var salaId = params.get('id');
            stompClient.send("/app/abandonarSala."+salaId,{},JSON.stringify(usuarioJSON));
            stompClient.subscribe('/topic/salas',function (eventbody) {
                window.location.href = "home.html";
            });

        }
    }
};

