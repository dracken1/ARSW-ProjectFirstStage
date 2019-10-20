# Bloody Money!(in construction)

## Integrantes
  ```
  - Nicolás Cárdenas Chaparro
  - David Antonio Diaz Duarte
  - Pedro Jose Mayorga Navarrete
  ```
  
## Resumen
`
En este proyecto se va a desarrollar un juego 2d de tipo supervivencia, donde un jugador es un asesino/cazador y los demas jugadores son supervivientes. Solo un jugador gana (todos juegan de forma individual), independientemente de si es superviviente o asesino, la forma de ganar varia dependiendo del tipo de jugador. Para ganar, un superviviente deben recolectar una cantidad determinada de monedas que se encuentran distribuidas de forma aleatoria a lo largo y ancho del mapa para poder abrir las puertas de escape,y posteriormente salir por una de ellas, por otro lado el asesino debe cazar a todos los supervivientes antes de que alguno logre escapar para poder ganar.
`

## Descripcion y Reglas de Juego

  ![Imagenes](https://github.com/dracken1/ARSW-ProjectFirstStage/blob/master/MapaGeneral2soDise%C3%B1oProyectoARSW.png)

### General

Una partida consta de un mapa, un asesino y a lo sumo 4 supervivientes (puede cambiar a petición del profesor). El mapa esta lleno de obstaculos y/o bloqueos que impiden el paso de los personajes, en los extremos este y oeste del mapa siempre hay dos puertas de escape, adicionalmente dentro del mapa hay monedas, que son objetos de valor tanto para el asesino como para los supervivientes, sin embargo la utilidad para cada personaje es distinta. El asesino usa las monedas para bloquear las puertas o elevar el costo de monedas requerido para que estas se abran, mientras que un superviviente usa las monedas para abrir las puertas. El objetivo del asesino es acabar con todos los supervivientes(el asesino es mas veloz que un superviviente) y asi ganar la partida, para esto debe golpear a cada uno de los supervivientes hasta que queden en un estado agonizante, en este estado un superviviente morira luego de un tiempo determinado a menos que otro superviviente lo salve, el asesino podra robar una moneda del superviviente mientras se encuentre en este estado, a diferencia de los supervivientes el asesino no puede morir. Un superviviente debe escapar del asesino mientras recolecta monedas para poder abrir cualquier puerta. Existen diferentes formas de conseguir monedas para un superviviente, la forma natural es recolectandolas del suelo, la forma alternativa es ayudando a un superviviente que se encuentre en estado agonisante, de esta forma podra conseguir hasta dos monedas de su compañero. Cada superviviente posee dos inyecciones de adrenalina lo que les da dos oportunidades antes de perder, estas inyecciones se aplican automaticamente cuando un superviviente se encuentra en estado de agonia.

### El Mapa(construyendo)

  - Distribuido por todo el mapa habran diferentes objetos clasificados como obstaculos, dichos objetos impiden el paso de cualquiera de los personajes del juego.
  - En un mapa solo puede haber un asesino y un maximo de 4 supervivientes.
  - A lo largo y ancho del mapa habra un numero determinado de monedas que aparecen de forma aleatoria, estas monedas no se pueden sobrelapar con otros objetos tipo obstaculo del mapa. La cantidad maxima de monedas en el mapa es igual a la cantidad de supervivientes.
  - Existen dos puertas en el mapa que siempre aparecen en los mismos puntos.
  - Puede aparecer un caja en una posicion al azar del mapa con una sorpresa adentro que podra ser usada por cualquiera de los supervivientes, el asesino la puede destruir. (Tal vez).
  
### El Asesino/cazador(construyendo)

  - Este personaje es mas veloz que los supervivientes.
  - El asesino podra golpear a los supervivientes con el fin de disminuir su vida para poder dejarlos en un estado agonizante.
  - Este personaje no puede morir.
  - Este jugador perdera si alguno de los supervivientes logra escapar.
  - Puede robar una moneda de un superviviente que se encuentre agonizando.
  - El asesino puede recolectar monedas con el fin de bloquear las puertas por un tiempo proporcional  a la cantidad de monedas que tenga o podra elevar el costo requerido para que estas se abran.
  - No puede atravesar los obstaculos.
  - El Asesino no puede coger monedas que estén en el piso, solo se las puede robar a un Superviviente (cuando están en estado de agonía)
  
### El Superviviente(construyendo)

  - Este personaje puede morir, si esto sucede pierde de inmediato.
  - Posee dos inyecciones de adrenalina, esto le de dos oportunidades mas antes de perder, una inyeccion se aplica automaticamente cuando el estado de agonia llega a su limite.
  - Debe recolectar una cantidad especifica de monedas para poder abrir una puerta y asi escapar.
  - Si encuentra una linterna en la caja sorpresa podra usarla para congelar al asesino por unos segundos(tal vez).
  - No puede atravesar los obstaculos.
  - Juega de forma individual, sin importar que haya mas supervivientes, es decir solo un superviviente gana(el que escape primero).
  - Es el unico personaje que puede abrir las puertas de escape, sin embargo esto toma tiempo y tiene un costo en monedas.
  - Puede quedar en estado agonia, en este estado puede perder vidas o morir, a menos que otro superviviente lo ayude pero esto significa perder monedas.
  - Usar una inyeccion de adrenalina no significa perder las monedas que posea.
  - Si el superviviente ya no tiene inyecciones de adrenalina y el asesino lo deja en estado de agonia, muere al instante.
  - Una vez en estado de agonia la velocidad del superviviente disminuira mucho.
  
### Inicio de partida/sala (construyendo)
  
  - Todos los personajes aparecen de forma aleatoria en el mapa, sin embargo el asesino nunca aparece cerca de un superviviente.
  - Los objetos tipo obstaculo siempre salen en el mismo lugar.
  - La caja sorpresa sale despues de 30 segundos de iniciada la partida, aparece de forma aleatoria en el mapa (tal vez).
  - Al iniciar la partida solo hay una moneda por superviviente, estas monedas aparecen cerca al asesino, una vez que una moneda es recolectada aparecera otra despues de 30 segundos en una ubicacion al azar.
  - Las puertas aparecen cerradas. 
  - En una partida/sala solo hay un asesino y un maximo de 4 supervivientes. 
  
### Fin de partida(construyendo)
  
  - Se muestran las estadisticas de la partida.
  - El jugador tendra la opcion de volver a la interfaz inicial.
  - El jugador tendra la opcion de unirse a una sala de juego directamente sin salir a la interfaz incial.
  - El jugador tendra la opcion de cerrar el juego.
  
### Iniciar sesion(construyendo)

  - Cada jugador podra iniciar sesion para ser identificado dentro del juego.
  - Un jugador podra acceder a sus estadisticas dentro de su perfil.
  - Tener un perfil permite la personalizacion de personajes y aspectos esteticos dentro del juego(A futuro).
  - Un jugador tendra un nombre de su gusto unico dentro del juego.
  - Una vez un jugador inicie sesion podra unirse a una sala para empezar una partida.
  - El jugador tendra la opcion de cerrar sesion.
  - Es necesario iniciar sesion para poder iniciar una partida.
  
### Registro(construyendo)

  - El registro se realiza con un nickname y una contraseña.
  - El nickname sera del gusto del jugador y sera unico dentro del juego.
  - No se solicitaran datos personales para el registro.
  
### Jugabilidad

  - El jugador se moverá con las teclas "W", "A", "S" y "D" (Arriba, Izquierda, Abajo, Derecha).
  - Los objetos especiales serán activados mediante la tecla "F".
  - El asesino roba automáticamente máximo una moneda de un Superviviente que se encuentre en estado agonizante.
  - El número de monedas que hay en el mapa es igual al número de supervivientes de la partida. Cada vez que un Superviviente coge una moneda, reaparecerá una nueva a los 30 segundos. De esta manera, no pueden haber más monedas que Supervivientes pero si pueden haber 0 monedas al mismo tiempo.
  
## Requerimientos

### Idea General

  Bloody Money es un juego multijugador de supervivencia de alta competitividad con un sistema de juego de cámara aérea en el que un jugador representa el rol del asesino desalmado y los 4 jugadores restantes son los supervivientes que intentan escapar de una muerte inevitable. 
  El juego ofrece una experiencia frenetica y adictiva que mezcla una ambiente de persecución intenso con una jugabilidad estrategica separada por objetivos, donde:
  - El Asesino busca acabar con la vida de todos los supervivientes.
  - Los Supervivientes buscan escapar del Asesino.
  
### Bussiness Idea

  A futuro se piensa escalar el juego mediante un sistema de microtransacciones que nos permita obtener recursos mediante la venta de artículos in-game como skins o apariencias que no afecten el equilibrio del juego y que le den un toque diferenciador de personalización a cada jugador en sus partidas.
  
### Orientación en Tiempo Real

  Todos los jugadores de la partida se encuentran compartiendo al mismo tiempo el mapa de juego, recursos, elementos de la partida, monedas e información general del estado de la partida.
  
### Alta Concurrencia

  Se implementarán salas de juego que nos permitan integrar Alta Concurrencia al juego con máximo 5 jugadores por sala, para un total de 10 salas de juego, con 50 jugadores simultaneos.
  
### Requerimientos No Colaborativos

#### Historias de usuario

https://tree.taiga.io/project/dracken1-arsw-project/backlog
  
https://stackoverflow.com/questions/11731377/servlet-returns-http-status-404-the-requested-resource-servlet-is-not-availa
  


