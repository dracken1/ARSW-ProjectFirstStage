// ID sala
var salaid;

var CombatApp = function(){
    return {
        abandonarSala: function () {
            ////////////////////
            if(!(game_well_concluded && sp_game_well_concluded)){
                stompClient.send("/topic/gameOver"+salaid,{},JSON.stringify({score : score, waiting: true, afk: true, ignore: getCookie("username")}));
            }
            var username = getCookie("username");
            var usuarioJSON = {username: username};
            var urlString = window.location.href;
            var url = new URL(urlString);
            salaid = url.searchParams.get("id");
            stompClient.send("/app/abandonarSala." + salaid, {}, JSON.stringify(usuarioJSON));
        }
    }
};

function verifyExitGame(){
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.value) {
        window.location.href = "lobby.html";
      }
    })
};

function getCookie(name) {
    var regexp = new RegExp("(?:^" + name + "|;\s*"+ name + ")=(.*?)(?:;|$)", "g");
    var result = regexp.exec(document.cookie);
    return (result === null) ? null : result[1];
};

var getJugadoresSala = function (salaId) {
    var traerSalas = $.get("/Sala/getById."+salaId);
    traerSalas.then(function(salas) {
        datosDosJugadores(JSON.parse(salas));
    },function () {

    });
    return traerSalas;
}

var getInformacionSala = function (salaId) {
    var traerSalas = $.get("/Sala/getById."+salaId);
    traerSalas.then(function(salas) {
        cargaDatosSala(JSON.parse(salas));
    },function () {

    });
    return traerSalas;
};

var cargaDatosSala = function (tabla) {
    tabla.map(function (salaDescripcion){
        var cantidadJudadores = salaDescripcion.cantidadJugadores;
        var jugadoresActuales = salaDescripcion.jugadoresActuales;
        jugadoresActuales.map(function (jugador){
            if(cantidadJudadores==1){
                document.getElementById("Player").innerHTML = "Local Player: "+jugador[0];
                document.getElementById("Opponent").innerHTML = "Opponent: ";
            }else{
                document.getElementById("Player").innerHTML = "Local Player: "+ jugador[1];
                document.getElementById("Opponent").innerHTML = "Opponent: ";
            }
        })
    })
};
(function(){

})();
var datosDosJugadores = function (tabla) {
    tabla.map(function (salaDescripcion){
        var username = getCookie("username");
        var usuarioJSON = {username: username};
        //alert("id de sala = "+salaId);
        var cantidadJudadores = salaDescripcion.cantidadJugadores;
        var jugadoresActuales = salaDescripcion.jugadoresActuales;
        jugadoresActuales.map(function (jugador){
            if(cantidadJudadores==2) {
                if (jugador[0] == usuarioJSON.username) {
                    document.getElementById("Player").innerHTML = "Local Player: "+jugador[0];
                    document.getElementById("Opponent").innerHTML = "Opponent: "+jugador[1];
                }else{
                    document.getElementById("Player").innerHTML = "Local Player: "+jugador[1];
                    document.getElementById("Opponent").innerHTML = "Opponent: "+jugador[0];
                }

                let timerInterval
                $("#waitingplayercontainerid").hide("fast");
                Swal.fire({
                    title: 'Get Ready!',
                    html: 'The game will start in <b style="font-size: 24px; color:#60000d;"></b> seconds.',
                    timer: 3000,
                    timerProgressBar: true,
                    onBeforeOpen: () => {
                        //var secs = timerInterval/1000;
                        Swal.showLoading()
                        timerInterval = setInterval(() => {
                            Swal.getContent().querySelector('b')
                                .textContent = Math.round(Swal.getTimerLeft()/1000)+1
                        }, 1000)
                    },
                    onClose: () => {
                        clearInterval(timerInterval),play(),
                        document.getElementById("playerMusic").play();
                    }
                }).then((result) => {
                    if (
                         //Read more about handling dismissals below
                        result.dismiss === Swal.DismissReason.timer
                    ) {
                        console.log('I was closed by the timer') // eslint-disable-line
                    }
                })

            }
        })

    })
};
//Start STOMP socket before page loads
(function(){
    var urlString = window.location.href;
    var url = new URL(urlString);
    salaid = url.searchParams.get("id");
    getInformacionSala(salaid);
    getJugadoresSala(salaid);
    console.log("el id es: " + salaid);
    console.info('Connecting to WS...');

    var username = getCookie("username");
    var usuarioJSON = {username: username};
    var socket = new SockJS('/stompendpoint');
    stompClient = Stomp.over(socket);
    //subscribe to /topic/accionID when connections succeed
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.send("/app/usuariosEnSala."+salaid, {},JSON.stringify(usuarioJSON));

        stompClient.subscribe('/topic/usuariosEnSala'+salaid,function (eventbody) {
            getJugadoresSala(salaid);
        });
        stompClient.subscribe('/topic/abandonarSala'+salaid, function (eventbody) {
            getInformacionSala(salaid);
        });
        stompClient.subscribe('/topic/scorePlayer'+ salaid, function (eventbody) {
            var extract = JSON.parse(eventbody.body);
            console.log(extract);
            if(!(extract.ignore === getCookie("username"))){
                document.getElementById("spscore").innerHTML = ("00000" + Math.floor(extract.score)).slice(-5);
            }
        });
        stompClient.subscribe('/topic/rowsPlayer'+ salaid, function (eventbody) {
            var extract = JSON.parse(eventbody.body);
            if(!(extract.ignore === getCookie("username"))){
                //alert(extract.rows);
                document.getElementById("sprows").innerHTML = extract.rows;
            }
        });
        stompClient.subscribe('/topic/drawPlayer'+ salaid, function (eventbody) {
            var extract = JSON.parse(eventbody.body);
            if(!(extract.ignore === getCookie("username"))){
                drawOpponent(extract.type,extract.x,extract.y,extract.dir);
            }
        });
        stompClient.subscribe('/topic/dropPlayer'+ salaid, function (eventbody) {
            var extract = JSON.parse(eventbody.body);
            if(!(extract.ignore === getCookie("username"))){
                dropOpponent(extract.type,extract.x,extract.y,extract.dir);
            }
        });
        stompClient.subscribe('/topic/drawNext'+ salaid, function (eventbody) {
            var extract = JSON.parse(eventbody.body);
            if(!(extract.ignore === getCookie("username"))){
                drawNextOpponent(extract.type,extract.padding,extract.dir);
            }
        });
        stompClient.subscribe('/topic/drawPower'+ salaid, function (eventbody) {
            var extract = JSON.parse(eventbody.body);
            console.log(extract);
            if(!(extract.ignore === getCookie("username"))){
                execPower(extract.power);
                showPlayerExecPower(extract.power,2);
            }

        });
        stompClient.subscribe('/topic/gameOver'+ salaid, function (eventbody) {
            var extract = JSON.parse(eventbody.body);
            console.log(extract);
            if (!(extract.ignore === getCookie("username"))) {
                sp_game_well_concluded = extract.gameover;
                if (!(playing)) {
                    if (extract.afk) {
                        playing = false;
                        document.getElementById('waitwinnerlosercontid').innerText = "OPPONENT LEFT, YOU WIN!";
                        document.getElementById('waitwinnerlosercontid').style.backgroundColor = "#0cb45a";
                        document.getElementById('waitwinnerlosercontid').style.color = "white";
                        document.getElementById('gameoverscorecontid').innerText = "SCORE: " + score;
                        if (!(gameoveractive)) {
                            animateGameOver();
                        }
                    } else {
                        if (extract.score > score) {
                            document.getElementById('waitwinnerlosercontid').innerText = "YOU LOSE!";
                            document.getElementById('waitwinnerlosercontid').style.backgroundColor = "#db2526";
                            document.getElementById('waitwinnerlosercontid').style.color = "white";
                        } else if (extract.score < score) {
                            document.getElementById('waitwinnerlosercontid').innerText = "YOU WIN!";
                            document.getElementById('waitwinnerlosercontid').style.backgroundColor = "#0cb45a";
                            document.getElementById('waitwinnerlosercontid').style.color = "white";
                        } else {
                            document.getElementById('waitwinnerlosercontid').innerText = "DRAW!";
                            document.getElementById('waitwinnerlosercontid').style.backgroundColor = "#bbb";
                            document.getElementById('waitwinnerlosercontid').style.color = "white";
                        }
                        document.getElementById('gameoverscorecontid').innerText = "SCORE: " + score;
                        if (!(gameoveractive)) {
                            animateGameOver();
                        }
                    }
                } else {
                    if (extract.afk) {
                        playing = false;
                        document.getElementById('waitwinnerlosercontid').innerText = "OPPONENT LEFT, YOU WIN!";
                        document.getElementById('waitwinnerlosercontid').style.backgroundColor = "#0cb45a";
                        document.getElementById('waitwinnerlosercontid').style.color = "white";
                        document.getElementById('gameoverscorecontid').innerText = "SCORE: " + score;
                        if (!(gameoveractive)) {
                            animateGameOver();
                        }
                    } else {
                        opponent_score = extract.score;
                        opponent_waiting = extract.waiting;
                    }
                }
            }
        });
    });
})();

//-------------------------------------------------------------------------
// base helper methods
//-------------------------------------------------------------------------

function Sound(source, volume, loop)
{
    this.source = source;
    this.volume = volume;
    this.loop = loop;
    var son;
    this.son = son;
    this.finish = false;
    this.stop = function()
    {
        document.body.removeChild(this.son);
    }
    this.start = function()
    {
        if (this.finish) return false;
        this.son = document.createElement("embed");
        this.son.setAttribute("src", this.source);
        this.son.setAttribute("hidden", "true");
        this.son.setAttribute("volume", this.volume);
        this.son.setAttribute("autostart", "true");
        this.son.setAttribute("loop", this.loop);
        document.body.appendChild(this.son);
    }
    this.remove=function()
    {
        document.body.removeChild(this.son);
        this.finish = true;
    }
    this.init = function(volume, loop)
    {
        this.finish = false;
        this.volume = volume;
        this.loop = loop;
    }
}

$('#pausebuttoncontid').click(function () {
    var audio = document.getElementById("playerMusic");
    if(audio.paused){
        audio.play();
    } else{
        audio.pause();
    }
});
function get(id){
    return document.getElementById(id);
}
function hide(id){
    get(id).style.visibility = 'hidden';
}
function show(id){
    get(id).style.visibility = null;
}
function html(id, html) {
    get(id).innerHTML = html;
}

function timestamp(){
    return new Date().getTime();
}
function random(min, max){
    return (min + (Math.random() * (max - min)));
}
function randomChoice(choices) {
    return choices[Math.round(random(0, choices.length-1))];
}

if (!window.requestAnimationFrame) { // http://paulirish.com/2011/requestanimationframe-for-smart-animating/
    window.requestAnimationFrame = window.webkitRequestAnimationFrame ||
        window.mozRequestAnimationFrame    ||
        window.oRequestAnimationFrame      ||
        window.msRequestAnimationFrame     ||
        function(callback, element) {
            window.setTimeout(callback, 1000 / 60);
        }
}

//-------------------------------------------------------------------------
// game constants
//-------------------------------------------------------------------------

var KEY = { ESC: 27, SPACE: 32, LEFT: 37, UP: 38, RIGHT: 39, DOWN: 40 },
    DIR = { UP: 0, RIGHT: 1, DOWN: 2, LEFT: 3, MIN: 0, MAX: 3 },
    stats = new Stats(),
    canvas = get('canvas'),
    ctx = canvas.getContext('2d'),
    ucanvas = get('upcoming'),
    uctx = ucanvas.getContext('2d'),
    canvasopponent = get('secondplayercanvas'),
    ctxopponent = canvasopponent.getContext('2d'),
    ucanvasopponent = get('upcomingOpponent'),
    uctxopponent = ucanvasopponent.getContext('2d');
    speed = { start: 0.6, decrement: 0.02, min: 0.0 }, // how long before piece drops by 1 row (seconds)
    nx = 10, // width of tetris court (in blocks)
    ny = 20, // height of tetris court (in blocks)
    nu = 5;  // width/height of upcoming preview (in blocks)

//-------------------------------------------------------------------------
// game variables (initialized during reset)
//-------------------------------------------------------------------------

var dx, dy,        // pixel size of a single tetris block
    dx_op, dy_op,        // pixel size of a single tetris block opponent
    blocks,
    blocks_op,
    actions,       // queue of user actions (inputs)
    playing,       // true|false - game is in progress
    dt,            // time since starting this game
    current,       // the current piece
    next,          // the next piece
    score,         // the current score
    vscore,        // the currently displayed score (it catches up to score in small chunks - like a spinning slot machine)
    rows,          // number of completed rows in the current game
    step,          // how long before current piece drops by 1 row
    flag_lose,
    opponent_waiting,
    opponent_score,
    gameoveractive,
    sp_game_well_concluded,
    game_well_concluded;

//-------------------------------------------------------------------------
// tetris pieces
//
// blocks: each element represents a rotation of the piece (0, 90, 180, 270)
//         each element is a 16 bit integer where the 16 bits represent
//         a 4x4 set of blocks, e.g. j.blocks[0] = 0x44C0
//
//             0100 = 0x4 << 3 = 0x4000
//             0100 = 0x4 << 2 = 0x0400
//             1100 = 0xC << 1 = 0x00C0
//             0000 = 0x0 << 0 = 0x0000
//                               ------
//                               0x44C0
//
//-------------------------------------------------------------------------

var i = { size: 4, blocks: [0x0F00, 0x2222, 0x00F0, 0x4444], blocks_op: [0x0F00, 0x2222, 0x00F0, 0x4444], color: '#e8d441' };
var j = { size: 3, blocks: [0x44C0, 0x8E00, 0x6440, 0x0E20], blocks_op: [0x44C0, 0x8E00, 0x6440, 0x0E20], color: '#094BDA' };
var l = { size: 3, blocks: [0x4460, 0x0E80, 0xC440, 0x2E00], blocks_op: [0x4460, 0x0E80, 0xC440, 0x2E00], color: '#1EBAE8' };
var o = { size: 2, blocks: [0xCC00, 0xCC00, 0xCC00, 0xCC00], blocks_op: [0xCC00, 0xCC00, 0xCC00, 0xCC00], color: '#D60707' };
var s = { size: 3, blocks: [0x06C0, 0x8C40, 0x6C00, 0x4620], blocks_op: [0x06C0, 0x8C40, 0x6C00, 0x4620], color: '#5ADD34' };
var t = { size: 3, blocks: [0x0E40, 0x4C40, 0x4E00, 0x4640], blocks_op: [0x0E40, 0x4C40, 0x4E00, 0x4640], color: '#FF8000' };
var z = { size: 3, blocks: [0x0C60, 0x4C80, 0xC600, 0x2640], blocks_op: [0x0C60, 0x4C80, 0xC600, 0x2640], color: '#217400' };

//------------------------------------------------
// do the bit manipulation and iterate through each
// occupied block (x,y) for a given piece
//------------------------------------------------
function eachblock(type, x, y, dir, fn) {
    var bit, result, row = 0, col = 0, blocks = type.blocks[dir];
    for(bit = 0x8000 ; bit > 0 ; bit = bit >> 1) {
        if (blocks & bit) {
            fn(x + col, y + row);
        }
        if (++col === 4) {
            col = 0;
            ++row;
        }
    }
}

function eachblockOpponent(type, x, y, dir, fn) {
    var bit, result, row = 0, col = 0, blocks = type.blocks_op[dir];
    for(bit = 0x8000 ; bit > 0 ; bit = bit >> 1) {
        if (blocks & bit) {
            fn(x + col, y + row);
        }
        if (++col === 4) {
            col = 0;
            ++row;
        }
    }
}

//-----------------------------------------------------
// check if a piece can fit into a position in the grid
//-----------------------------------------------------
function occupied(type, x, y, dir) {
    var result = false;
    eachblock(type, x, y, dir, function(x, y) {
        if ((x < 0) || (x >= nx) || (y < 0) || (y >= ny) || getBlock(x,y))
            result = true;
    });
    return result;
}

function occupiedOpponent(type, x, y, dir) {
    var result = false;
    eachblockOpponent(type, x, y, dir, function(x, y) {
        if ((x < 0) || (x >= nx) || (y < 0) || (y >= ny) || getBlockOpponent(x,y))
            result = true;
    });
    return result;
}

function unoccupied(type, x, y, dir) {
    return !occupied(type, x, y, dir);
}

//-----------------------------------------
// start with 4 instances of each piece and
// pick randomly until the 'bag is empty'
//-----------------------------------------
var pieces = [];
function randomPiece() {
    if (pieces.length == 0)
        pieces = [i,i,i,i,j,j,j,j,l,l,l,l,o,o,o,o,s,s,s,s,t,t,t,t,z,z,z,z];
    var type = pieces.splice(random(0, pieces.length-1), 1)[0];
    return { type: type, dir: DIR.UP, x: Math.round(random(0, nx - type.size)), y: 0 };
}

//-------------------------------------------------------------------------
// GAME LOOP
//-------------------------------------------------------------------------

function run() {

    //showStats(); // initialize FPS counter
    addEvents(); // attach keydown and resize events

    var last = now = timestamp();
    function frame() {
        now = timestamp();
        update(Math.min(1, (now - last) / 1000.0)); // using requestAnimationFrame have to be able to handle large delta's caused when it 'hibernates' in a background or non-visible tab
        draw();
        stats.update();
        last = now;
        requestAnimationFrame(frame, canvas);
    }

    resize(); // setup all our sizing information
    reset();  // reset the per-game variables
    frame();  // start the first frame
}

function showStats() {
    stats.domElement.id = 'stats';
    get('menu').appendChild(stats.domElement);
}

function addEvents() {
    document.addEventListener('keydown', keydown, false);
    window.addEventListener('resize', resize, false);
}

function resize(event) {
    canvas.width   = canvas.clientWidth;  // set canvas logical size equal to its physical size
    canvas.height  = canvas.clientHeight; // (ditto)
    ucanvas.width  = ucanvas.clientWidth;
    ucanvas.height = ucanvas.clientHeight;
    dx = canvas.width  / nx; // pixel size of a single tetris block
    dy = canvas.height / ny; // (ditto)
    canvasopponent.width   = canvasopponent.clientWidth;  // set canvas logical size equal to its physical size
    canvasopponent.height  = canvasopponent.clientHeight; // (ditto)
    ucanvasopponent.width = ucanvasopponent.clientWidth;
    ucanvasopponent.height = ucanvasopponent.clientHeight;
    dx_op = canvasopponent.width  / nx; // pixel size of a single tetris block
    dy_op = canvasopponent.height / ny; // (ditto)
    invalidate();
    invalidateNext();
    invalidateOpponent();
}

function keydown(ev) {
    var handled = false;
    if (playing) {
        switch(ev.keyCode) {
            case KEY.LEFT:   actions.push(DIR.LEFT);  handled = true; break;
            case KEY.RIGHT:  actions.push(DIR.RIGHT); handled = true; break;
            case KEY.UP:     actions.push(DIR.UP);    handled = true; break;
            case KEY.DOWN:   actions.push(DIR.DOWN);  handled = true; break;
            case KEY.ESC:    lose();                  handled = true; break;
            case KEY.SPACE:  bajar();                 handled = true; break;
        }
    }
    /**
    else if (ev.keyCode == KEY.SPACE) {
        //if (flag_lose!=true) {
            play();
        //}
        handled = true;
    }*/
    if (handled)
        ev.preventDefault(); // prevent arrow keys from scrolling the page (supported in IE9+ and all other browsers)
}

//-------------------------------------------------------------------------
// GAME LOGIC
//-------------------------------------------------------------------------
class Stat{
    constructor(date,exp,username,score,type){
        this.date = date;
        this.exp = exp;
        this.username = username;
        this.score = score;
        this.type = type;
    }
}

function addstat() {
    var stattosend = new Stat(new Date(),100,getCookie("username"),score,"Multiplayer");
    var statsurl = '/stats/stat';
    fetch(statsurl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(stattosend)
    })
        .then(response => {
            if(!(response.ok)) {
                alert("Something went wrong updating your stats!");
            }
        })
}
function getCookie(name) {
    var regexp = new RegExp("(?:^" + name + "|;\s*"+ name + ")=(.*?)(?:;|$)", "g");
    var result = regexp.exec(document.cookie);
    return (result === null) ? null : result[1];
}
function animateGameOver() {
    $("#gameovercontainerid").animate({height:"toggle",
        'padding-top': "toggle",
        'padding-bottom': "toggle",
        opacity: "toggle"
    },1000);
}
function play() { reset(); playing = true; }
function lose() {
    //show('start');
    gameoveractive = true;
    setVisualScore(); playing = false; flag_lose=true;
    stompClient.send("/topic/gameOver"+salaid,{},JSON.stringify({score : score, waiting: true, afk: false,gameover: true, ignore: getCookie("username")}));
    document.getElementById('gameoverscorecontid').innerText = "SCORE: "+score;
    animateGameOver();
    if(opponent_waiting === true){
        game_well_concluded = true;
        if(opponent_score > score){
            document.getElementById('waitwinnerlosercontid').innerText = "YOU LOSE!";
            document.getElementById('waitwinnerlosercontid').style.backgroundColor = "#db2526";
            document.getElementById('waitwinnerlosercontid').style.color = "white";
        } else if (opponent_score < score){
            document.getElementById('waitwinnerlosercontid').innerText = "YOU WIN!";
            document.getElementById('waitwinnerlosercontid').style.backgroundColor = "#0cb45a";
            document.getElementById('waitwinnerlosercontid').style.color = "white";
        } else{
            document.getElementById('waitwinnerlosercontid').innerText = "DRAW!";
            document.getElementById('waitwinnerlosercontid').style.backgroundColor = "#bbb";
            document.getElementById('waitwinnerlosercontid').style.color = "white";
        }
    }
    addstat();
}
function setVisualScore(n)      { vscore = n || score; invalidateScore(); }
function setScore(n)            { score = n; setVisualScore(n);  }
function addScore(n)            {
    score = score + n;
    stompClient.send("/topic/scorePlayer"+salaid,{},JSON.stringify({score : score,ignore: getCookie("username")}));
    if(score > opponent_score && opponent_waiting){
        lose();
    }
}
function clearScore()           { setScore(0); }
function clearRows()            { setRows(0); }
function setRows(n)             { rows = n; step = Math.max(speed.min, speed.start - (speed.decrement*rows)); invalidateRows(); }
function addRows(n)             { setRows(rows + n); stompClient.send("/topic/rowsPlayer"+salaid,{},JSON.stringify({rows : rows,ignore: getCookie("username")})); }
function getBlock(x,y)          { return (blocks && blocks[x] ? blocks[x][y] : null); }
function getBlockOpponent(x,y)          { return (blocks_op && blocks_op[x] ? blocks_op[x][y] : null); }
function setBlock(x,y,type)     { blocks[x] = blocks[x] || []; blocks[x][y] = type; invalidate(); }
function setBlockOpponent(x,y,type)     { blocks_op[x] = blocks_op[x] || []; blocks_op[x][y] = type; invalidateOpponent();}
function clearBlocks()          { blocks = []; invalidate(); }
function clearBlocks_op()          { blocks_op = []; invalidateOpponent(); }
function clearActions()         { actions = []; }
function setCurrentPiece(piece) { current = piece || randomPiece(); invalidate();     }
function setNextPiece(piece)    { next    = piece || randomPiece(); invalidateNext(); }

function bajar(){
var y;
    for(y = current.y ; y<ny ; y++) {
        if (unoccupied(current.type, current.x, y, current.dir)) {
            current.y = y;
        }
        else {
            invalidate();
            break;
        }
    }
}

function reset() {
    dt = 0;
    sp_game_well_concluded = false;
    game_well_concluded = false;
    opponent_waiting = false;
    gameoveractive = false;
    clearActions();
    clearBlocks();
    clearBlocks_op();
    clearRows();
    clearScore();
    setCurrentPiece(next);
    setNextPiece();
}

function update(idt) {
    if (playing) {
        if (vscore < score)
            setVisualScore(vscore + 1);
        handle(actions.shift());
        dt = dt + idt;
        if (dt > step) {
            dt = dt - step;
            drop();
        }
    }
}

function handle(action) {
    switch(action) {
        case DIR.LEFT:  move(DIR.LEFT);  break;
        case DIR.RIGHT: move(DIR.RIGHT); break;
        case DIR.UP:    rotate();        break;
        case DIR.DOWN:  drop();          break;
    }
}

function move(dir) {
    var x = current.x, y = current.y;
    switch(dir) {
        case DIR.RIGHT: x = x + 1; break;
        case DIR.LEFT:  x = x - 1; break;
        case DIR.DOWN:  y = y + 1; break;
    }
    if (unoccupied(current.type, x, y, current.dir)) {
        current.x = x;
        current.y = y;
        invalidate();
        return true;
    }
    else {
        return false;
    }
}

function rotate() {
    var newdir = (current.dir == DIR.MAX ? DIR.MIN : current.dir + 1);
    if (unoccupied(current.type, current.x, current.y, newdir)) {
        current.dir = newdir;
        invalidate();
    }
}

function drop() {
    if (!move(DIR.DOWN)) {
        addScore(10);
        dropPiece();
        if (playing) {
            stompClient.send("/topic/dropPlayer" + salaid, {}, JSON.stringify({
                x: current.x,
                y: current.y,
                type: current.type,
                dir: current.dir,
                ignore: getCookie("username")
            }));
        }
        removeLines();
        setCurrentPiece(next);
        setNextPiece(randomPiece());
        clearActions();
        if (occupied(current.type, current.x, current.y, current.dir)) {
            lose();
        }
    }
}

function dropOpponent(type, px, py, dir) {
        dropPieceOpponent(type, px, py, dir);
        removeLinesOpponent();
}

function dropPiece() {
    eachblock(current.type, current.x, current.y, current.dir, function(x, y) {
        setBlock(x, y, current.type);
    });
}

function dropPieceOpponent(type, px, py, dir) {
    eachblockOpponent(type, px, py, dir, function(x, y) {
        setBlockOpponent(x, y, type);
    });
}

function removeLines() {
    var x, y, complete, n = 0;
    for(y = ny ; y > 0 ; --y) {
        complete = true;
        for(x = 0 ; x < nx ; ++x) {
            if (!getBlock(x, y))
                complete = false;
        }
        if (complete) {
            removeLine(y);
            y = y + 1; // recheck same line
            n++;
        }
    }
    if (n > 0) {
        addRows(n);
        addScore(100*Math.pow(2,n-1)); // 1: 100, 2: 200, 3: 400, 4: 800
        if (playing) {
            stompClient.send("/topic/drawPower" + salaid, {}, JSON.stringify({
                power: n,
                ignore: getCookie("username")
            }));

///////////////////////////////////////////////////////////////////////////////////////////////////////
            showPlayerExecPower(n,1);
        }
    }
}

function removeLinesOpponent() {
    var x, y, complete, n = 0;
    for(y = ny ; y > 0 ; --y) {
        complete = true;
        for(x = 0 ; x < nx ; ++x) {
            if (!getBlockOpponent(x, y))
                complete = false;
        }
        if (complete) {
            removeLineOpponent(y);
            y = y + 1; // recheck same line
            n++;
        }
    }
}

function removeLine(n) {
    var x, y;
    for(y = n ; y >= 0 ; --y) {
        for(x = 0 ; x < nx ; ++x)
            setBlock(x, y, (y == 0) ? null : getBlock(x, y-1));
    }
}

function execPower(n) {
    switch(n) {
        case 2: setCurrentPiece(randomPiece()); break; //Cambio la figura del oponente
        case 3: bajar(); break; //Bajo la figura del oponente
        case 4: addScore(score); break;//Duplico el score
    }
}

function showPlayerExecPower(n,player){
    if(n>1){
        setExecPower(n,player);
        animateExecPower(player);
    }

}

function setExecPower(n, player) {
    switch (player) {
        case 1:
            switch (n) {
                case 2: document.getElementById('powerscontainerid').innerText = "Switch piece!"; break;
                case 3: document.getElementById('powerscontainerid').innerText = "Instant drop!"; break;
                case 4: document.getElementById('powerscontainerid').innerText = "Double score!"; break;
            }
            break;
        case 2:
            switch (n) {
                case 2: document.getElementById('sppowerscontainerid').innerText = "Switch piece!"; break;
                case 3: document.getElementById('sppowerscontainerid').innerText = "Instant drop!"; break;
                case 4: document.getElementById('sppowerscontainerid').innerText = "Double score!"; break;
            }
            break;
    }
}

function animateExecPower(player) {
    switch (player) {
        case 1:
            /*$("#powerscontainerid").stop(true,true,true);*/
            $("#powerscontainerid").animate({height:"toggle",
                'padding-top': "toggle",
                'padding-bottom': "toggle",
                opacity: "toggle"
            },10);
            $("#powerscontainerid").animate({
                borderTopRightRadius: '40px',
                borderBottomRightRadius: '40px'
            },100);
            $("#powerscontainerid").animate({
                borderTopRightRadius: '40px',
                borderBottomRightRadius: '40px',
                left: '32.5vw'
            },300);
            $("#powerscontainerid").animate({
                top: '36%'
            },50);
            $("#powerscontainerid").animate({
                top: '37%'
            },50);
            $("#powerscontainerid").animate({
                top: '38%'
            },50);
            $("#powerscontainerid").animate({
                top: '37%'
            },50);
            setTimeout(function () {
                $("#powerscontainerid").animate({height:"toggle",
                    'padding-top': "toggle",
                    'padding-bottom': "toggle",
                    opacity: "toggle",
                    borderTopRightRadius: '0px',
                    borderBottomRightRadius: '0px',
                    left: "10%"
                },1);
            },1500);
            break;
        case 2:
            $("#sppowerscontainerid").animate({height:"toggle",
                'padding-top': "toggle",
                'padding-bottom': "toggle",
                opacity: "toggle"
            },10);
            $("#sppowerscontainerid").animate({
                borderTopLeftRadius: '40px',
                borderBottomLeftRadius: '40px'
            },100);
            $("#sppowerscontainerid").animate({
                borderTopLeftRadius: '40px',
                borderBottomLeftRadius: '40px',
                left: '-215%'
            },300);
            $("#sppowerscontainerid").animate({
                top: '51%'
            },50);
            $("#sppowerscontainerid").animate({
                top: '50%'
            },50);
            $("#sppowerscontainerid").animate({
                top: '49%'
            },50);
            $("#sppowerscontainerid").animate({
                top: '50%'
            },50);
            setTimeout(function () {
                $("#sppowerscontainerid").animate({height:"toggle",
                    'padding-top': "toggle",
                    'padding-bottom': "toggle",
                    opacity: "toggle",
                    borderTopLeftRadius: '0px',
                    borderBottomLeftRadius: '0px',
                    left: "10%"
                },1);
            },1500);
            break;
    }
}


function removeLineOpponent(n) {
    var x, y;
    for(y = n ; y >= 0 ; --y) {
        for(x = 0 ; x < nx ; ++x)
            setBlockOpponent(x, y, (y == 0) ? null : getBlockOpponent(x, y-1));
    }
}

//-------------------------------------------------------------------------
// RENDERING
//-------------------------------------------------------------------------

var invalid = {};
var invalidOpponent = {};
function invalidate()         { invalid.court  = true; }
function invalidateNext()     { invalid.next   = true; }
function invalidateScore()    { invalid.score  = true; }
function invalidateRows()     { invalid.rows   = true; }
function invalidateOpponent() { invalidOpponent.court  = true; }

function draw() {
    ctx.save();
    ctx.lineWidth = 1;
    ctx.translate(0.5, 0.5); // for crisp 1px black lines
    drawCourt();
    if (playing) {
       stompClient.send("/topic/drawPlayer" + salaid, {}, JSON.stringify({
            x: current.x,
            y: current.y,
            type: current.type,
            dir: current.dir,
            ignore: getCookie("username")
        }));
    }
    drawNext();
    drawScore();
    drawRows();
    ctx.restore();
}

function drawOpponent(type, px, py, dir) {
    ctxopponent.save();
    ctxopponent.lineWidth = 1;
    ctxopponent.translate(0.5, 0.5); // for crisp 1px black lines
    drawCourtOpponent(type, px, py, dir);
    ctxopponent.restore();
}

function drawCourt() {
    if (invalid.court) {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        if (playing)
        {
            drawPiece(ctx, current.type, current.x, current.y, current.dir);
        }
        var x, y, block;
        for(y = 0 ; y < ny ; y++) {
            for (x = 0 ; x < nx ; x++) {
                if (block = getBlock(x,y))
                    drawBlock(ctx, x, y, block.color);
            }
        }
        ctx.strokeRect(0, 0, nx*dx - 1, ny*dy - 1); // court boundary
        invalid.court = false;
    }
}

function drawCourtOpponent(type, px, py, dir) {
        ctxopponent.clearRect(0, 0, canvasopponent.width, canvasopponent.height);
        drawPieceOpponent(ctxopponent, type, px, py, dir);
        var x,y,block;
        for(y = 0 ; y < ny ; y++) {
            for (x = 0 ; x < nx ; x++) {
                if (block = getBlockOpponent(x,y)){
                    drawBlockOpponent(ctxopponent, x, y, block.color);
                }
            }
        }
        ctxopponent.strokeRect(0, 0, nx*dx_op - 1, ny*dy_op - 1); // court boundary
}

function drawNext() {
    if (invalid.next) {
        var padding = (nu - next.type.size) / 2; // half-arsed attempt at centering next piece display
        uctx.save();
        uctx.translate(0.5, 0.5);
        uctx.clearRect(0, 0, nu*dx, nu*dy);
        nuevo_tipo=next.type;
        nuevo_dir=next.dir;
        drawPiece(uctx, nuevo_tipo, padding, padding, nuevo_dir);
        if (playing)
        {
            stompClient.send("/topic/drawNext" + salaid, {}, JSON.stringify({
                padding: padding,
                type: nuevo_tipo,
                dir: nuevo_dir,
                ignore: getCookie("username")
            }));
        }
        uctx.strokeStyle = 'black';
        uctx.strokeRect(0, 0, nu*dx - 1, nu*dy - 1);
        uctx.restore();
        invalid.next = false;
    }
}

function drawNextOpponent(type,padding,dir) {
        //var padding = (nu - next.type.size) / 2; // half-arsed attempt at centering next piece display
        uctxopponent.save();
        uctxopponent.translate(0.5, 0.5);
        uctxopponent.clearRect(0, 0, nu*dx_op, nu*dy_op);
        drawPieceOpponent(uctxopponent, type, padding, padding, dir);
        uctxopponent.strokeStyle = 'black';
        uctxopponent.strokeRect(0, 0, nu*dx_op - 1, nu*dy_op - 1);
        uctxopponent.restore();
        //invalidOpponent.next = false;
}

function drawScore() {
    if (invalid.score) {
        html('score', ("00000" + Math.floor(vscore)).slice(-5));
        invalid.score = false;
    }
}

function drawRows() {
    if (invalid.rows) {
        html('rows', rows);
        invalid.rows = false;
    }
}

function drawPiece(ctx, type, x, y, dir) {
    eachblock(type, x, y, dir, function(x, y) {
        drawBlock(ctx, x, y, type.color);
    });
}

function drawBlock(ctx, x, y, color) {
    ctx.fillStyle = color;
    ctx.fillRect(x*dx, y*dy, dx, dy);
    ctx.strokeRect(x*dx, y*dy, dx, dy)
}

function drawPieceOpponent(ctx, type, x, y, dir) {
    eachblockOpponent(type, x, y, dir, function(x, y) {
        drawBlockOpponent(ctx, x, y, type.color);
    });
}

function drawBlockOpponent(ctx, x, y, color) {
    ctx.fillStyle = color;
    ctx.fillRect(x*dx_op, y*dy_op, dx_op, dy_op);
    ctx.strokeRect(x*dx_op, y*dy_op, dx_op, dy_op)
}

//-------------------------------------------------------------------------
// FINALLY, lets run the game
//-------------------------------------------------------------------------

run();