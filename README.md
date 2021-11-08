# Aventuras de Marcos y Luis

##Tarea2
- ###Programa
  Con lo programado en esta tarea se podrá realizar lo siguiente:
  
  &nbsp;
  - Que los personajes y los enemigos se puedan atacar siguiendo las reglas establecidas,
    es decir que, Luis no pueda atacar a Boo, Boo sólo ataca a Luis, Boo esquiva los martillos,
    Spiny no le afecta el ataque salto, etc.

  &nbsp;
  - Que al subir de nivel un personaje principal, aumenta en un 15% el ataque, la defensa, 
    los puntos de vida y los puntos de fp.

  &nbsp;
  - Que los personajes principales tengan un inventario en común llamado "baúl", 
    donde se guardarán los items que ambos podrán usar. Al utilizar un item 
    este se eliminará del baúl.

  &nbsp;
  - Se puede añadir y sacar items del baúl.

  &nbsp;
  - Ocupar un Game Controller para poder simular una batalla.

  &nbsp;
  - Con el Game Controller se podrá: crear a los personajes principales, crear a los enemigos,
    crear los items, crear el baúl de los personajes principales, crear la lista de turnos,
    que los jugadores puedan ocupar items del baúl, saber si los personajes principales ganaron
    la batalla, obtener los personajes que estan en el turno actual y el del turno siguiente,
    y más.
  
- ###Supuestos 
  Los supuestos que se hicieron fueron los siguientes:

  &nbsp;
  - Al crear a los personajes con el Game Controller automáticamente se van posicionando en la 
    lista de turnos.

   &nbsp;
  - Sólo se usarán Items tipo Red mushroom y Honey syrup.

   &nbsp;
  - El jugador puede elegir a que enemigo atacar, sin embargo si está usando a Luis no puede tener 
    la opción de atacar a Boo.

   &nbsp;
  - El Baúl y la lista de Turnos se crean al momento de inicializar el Game Controller 
    para que no haya más de un Baúl o más de una lista de Turnos.

- ###Explicación de algunos metodos

  - En la clase Game Controller Hay dos versiones de un método que sirve para que los enemigos 
    puedan atacar a los jugadores. El usado en los test es el que permite elegir al jugador que
    se desea atacar. En el otro, se elige al azar a quien se atacará.

  &nbsp;
  - Dentro del codigo existen metodos auxiliares que no se testean, pero que sirven para el correcto
    funcionamiento de otros metodos que sí se testean.
  

##Tarea1
- ###Programa
  Con este programa se podrán realizar las siguientes acciones:

  &nbsp;
  - Crear los personajes principales (Marco y Luis) y los enemigos (Goomba, Spiny y Boo)
     con sus respectivas estadísticas.
    
  &nbsp;
  - Crear los items (Star, Red Mushroom, Honey Syrup) que ayudarán a los jugadores a recuperar 
     vida o puntos para poder atacar.

  &nbsp;
  - Que los personajes sean capaces de utilizar los items.

  &nbsp;
  - Que al ocupar Red Mushroom no se pueda superar los puntos de vida máxima.

  &nbsp;
  - Que al ocupar Honey Syrup no se pueda superar los puntos de fp máximo.

  &nbsp;
  - Que los personajes principales puedan atacar a los enemigos y viceversa.

  &nbsp;
  - Que los personajes principales puedan usar tipos de ataques (Salto o Martillo).
  
  &nbsp;
  - Que los personajes principales al atacar con Salto a Spiny, se hagan daño ellos mismos
    y que Spiny salga ileso.

  &nbsp;
  - Que Marco al atacar a Boo con Martillo, este no salga dañado pues "lo esquiva".
  
  &nbsp;
  - Que al atacar con Martillo se tenga un 25% de probabilid de que falle el ataque (No haga daño).
  
  &nbsp;
  - Que Luis no le haga daño a Boo, porque "no puede atacarlo".
    
  &nbsp;
  - Que Boo solo pueda dañar a a Luis, pues "solo lo ataca a él".
  
  &nbsp;
  - Que al ser atacado el personaje no quede con puntos de vida negativos.

  &nbsp;
  - Que al atacar los puntos de fp no queden en negativo. (No debería poder atacar si 
     no tiene los fp necesarios, pero eso no estaba especificado en la tarea aún).

  &nbsp;
  - Utilizar los datos de cada personaje.

  &nbsp;
  - Saber si un personaje está derrotado.

  &nbsp;
  - No poder atacar con un personaje que este derrotado.

- ###Supuestos
  Los supuestos realizados fueron los siguientes:
  
  &nbsp;
  - Por el momento el usuario pondrá los datos de cada personaje, es decir, los puntos de vida,
    los puntos de ataque, el nivel del personaje, etc.

  &nbsp;
  - El personaje antes de poder ocupar un item tiene que añadirlo a su inventario.

  &nbsp;
  - Los ataques estan implementados de tal manera de que cada uno se realiza por métodos diferentes.

  &nbsp;
  - La acción de los items están en la clase de los personajes y no en el de items, 
    porque ellos son los que los ocuparán.
  
- ###Explicación de algunos metodos

  - Hay dos versiones del método para atacar con Martillo, uno tiene un 25% de que no cause daño,
    en el otro uno puede poner el porcentaje de fallo. La segunda versión se realizó para los test
    y poder verificar que el daño que causa es el correcto.

  &nbsp;
  - Dentro del codigo existen metodos auxiliares que no se testean, pero que sirven para el correcto
    funcionamiento de otros metodos que sí se testean.

     

