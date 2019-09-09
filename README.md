# Stop fighting!(in construction)

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

## Descripcion

### General

Una partida consta de un mapa, un asesino y a lo sumo 4 supervivientes. El mapa esta lleno de obstaculos y/o bloqueos que impiden el paso de los personajes, en los extremos este y oeste del mapa siempre hay dos puertas de escape, adicionalmente dentro del mapa hay monedas, que son objetos de valor tanto para el asesino como para los supervivientes, sin embargo la utilidad para cada personaje es distinta. El asesino usa las monedas para bloquear las puertas o elevar el costo de monedas requerido para que estas se abran, mientras que un superviviente usa las monedas para abrir las puertas. El objetivo del asesino es acabar con todos los supervivientes(el asesino es mas veloz que un superviviente) y asi ganar la partida, para esto debe golpear a cada uno de los supervivientes hasta que queden en un estado agonizante, en este estado un superviviente morira luego de un tiempo determinado a menos que otro superviviente lo salve, el asesino podra robar una moneda del superviviente mientras se encuentre en este estado, a diferencia de los supervivientes el asesino no puede morir. Un superviviente debe escapar del asesino mientras recolecta monedas para poder abrir cualquier puerta. Existen diferentes formas de conseguir monedas para un superviviente, la forma natural es recolectandolas del suelo, la forma alternativa es ayudando a un superviviente que se encuentre en estado agonisante, de esta forma podra conseguir hasta dos monedas de su compañero. Cada superviviente posee dos inyecciones de adrenalina lo que les da dos oportunidades antes de perder, estas inyecciones se aplican automaticamente cuando un superviviente se encuentra en estado de agonia.

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
  
  
    
  ![Imagenes](https://github.com/dracken1/ARSW-ProjectFirstStage/blob/master/Imagenes/give-up.jpg)

## Historias de usuario

https://tree.taiga.io/project/dracken1-arsw-project/backlog
