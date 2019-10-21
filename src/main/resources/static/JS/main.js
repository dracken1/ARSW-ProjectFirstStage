// Clase 1 - Canvas
function canvasFactory(parent, width, height) {
    // Equivalente a un constructor
    let obj = Object.create(null);

    // Inicializo los atributos de mi objeto
    if (parent != undefined) {
        obj.element = parent.createElement("canvas")
    } else {
        obj.element = document.createElement("canvas")
    }
    obj.elements = []

    // Las funciones las enlazo al objeto para que puedan ser utilizadas
    // como en un lenguaje que haga uso de clases
    function load() {
        // Agrega el elemento y asigna el tamaño
        this.element.width = width != undefined ? width : 0;
        this.element.height = height != undefined ? height : 0;
        document.body.appendChild(this.element);
        this.update()
    }
    obj.load = load.bind(obj)

    function update() {
        // Dibuja los elementos dentro de el canvas
        let b = this.element.getContext("2d");

        // Esta linea de codigo hace que se vuelva a cargar de nuevo el elemento canvas
        // No es buena pratica usarlo, pero por el momento así se esta trabajando
        this.element.width = this.element.width
        //b.clearRect(0, 0, this.element.width, this.element.height);

        b.fillStyle = "black";
        b.fillRect(0, 0, this.element.width, this.element.height);

        for (let i of this.elements) {
            i.drawElement()
        }
    }
    obj.update = update.bind(obj)

    // Retorno mi objeto creado
    return obj
}

// Clase 2 - Elemento
function elementFactory(parentCanvas, options) {

    // Se pueden pasar atributos como el color, la velocidad, el tamaño, la posición inicial, etc
    if (options == undefined) {
        options = {}
    } else if (options.keys == undefined) {
        options.keys = {
            up: "ArrowUp",
            down: "ArrowDown",
            left: "ArrowLeft",
            right: "ArrowRight"
        }
    }

    let obj = Object.create(null)

    obj.parentCanvas = parentCanvas
    obj.posX = obj.posXInicial = options.xInicial != undefined ? options.xInicial : 0;
    obj.posY = obj.posYInicial = options.yInicial != undefined ? options.yInicial : 0;

    // Para lidiar con los eventos. Se puede usar un arreglo para trabajar con 4 intervalos que
    // representaran las 4 direcciones
    obj.currentInterval = null
    obj.lastCode = null

    function drawElement() {
        let b = this.parentCanvas.element.getContext("2d");

        if (this.posX > this.parentCanvas.element.width) {
            this.posX = this.parentCanvas.element.width;
        } else if (this.posX < 0) {
            this.posX = 0;
        } else if (this.posY > this.parentCanvas.element.height) {
            this.posY = this.parentCanvas.element.height;
        } else if (this.posY < 0) {
            this.posY = 0;
        }

        b.arc(this.posX, this.posY, 20, 0, 2 * Math.PI, false);
        b.fillStyle = 'red';
        b.fill();
    }

    obj.drawElement = drawElement.bind(obj)

    function moveUp() {
        if (this.currentInterval == null) {
            this.currentInterval = window.setInterval(() => {
                this.posY -= 5
                this.parentCanvas.update()
            }, 50)
        }

    }
    obj.moveUp = moveUp.bind(obj)

    function moveRight() {
        if (this.currentInterval == null) {
            this.currentInterval = window.setInterval(() => {
                this.posX += 5
                this.parentCanvas.update()
            }, 50)
        }
    }
    obj.moveRight = moveRight.bind(obj)

    function moveLeft() {
        if (this.currentInterval == null) {
            this.currentInterval = window.setInterval(() => {
                this.posX -= 5
                this.parentCanvas.update()
            }, 50)
        }
    }
    obj.moveLeft = moveLeft.bind(obj)

    function moveDown() {
        if (this.currentInterval == null) {
            this.currentInterval = window.setInterval(() => {
                this.posY += 5
                this.parentCanvas.update()
            }, 50)
        }
    }
    obj.moveDown = moveDown.bind(obj)

    function listener(event) {
        switch (event.code) {
            case options.keys.up:
                this.moveUp()
                this.lastCode = options.keys.up
                break;
            case options.keys.left:
                this.lastCode = options.keys.left
                this.moveLeft()
                break;
            case options.keys.down:
                this.lastCode = options.keys.down
                this.moveDown()
                break;
            case options.keys.right:
                this.lastCode = options.keys.right
                this.moveRight()
                break;
        }
    }
    obj.listener = listener.bind(obj)

    function clearInterval(event) {
        if (this.lastCode == event.code) {
            window.clearInterval(this.currentInterval)
            this.currentInterval = null
        }
    }
    obj.clearInterval = clearInterval.bind(obj)

    obj.parentCanvas.elements.push(obj)

    return obj
}

// Codigo como tal

var canvas = canvasFactory(document, 800, 500)

c1 = elementFactory(canvas, {
    xInicial: 20,
    yInicial: 20
})

c2 = elementFactory(canvas, {
    xInicial: 200,
    yInicial: 200,
    keys: {
        up: "KeyW",
        down: "KeyS",
        left: "KeyA",
        right: "KeyD"
    }
})

window.addEventListener("load", canvas.load, true);

window.addEventListener("keydown", c1.listener, true);
window.addEventListener("keydown", c2.listener, true);

window.addEventListener("keyup", c1.clearInterval, true);
window.addEventListener("keyup", c2.clearInterval, true);