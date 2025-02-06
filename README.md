# Game of life
> **Entregas:**
> - Semana 4: 40/30% - Precentación parcial
> - Semana 7: 60/70% - Precentación final

## ¿Qué es el algoritmo GOL?
El Juego Game of Life es un autómata celular (*ideado por el matemático británico John .Horton Conway en 1970*). Un autómata es una máquina auto operativa que realiza una función de acuerdo con un conjunto predeterminado  de instrucciones codificadas automáticamente.
### Representarlo como pseudocódigo y/o diagrama de flujo.
```text
1. Solicitar valores:
    Cuadricula
    w(integer) -> width Valores [10,20,40,80]
    h(integer) -> height Valores [10, 20, 40]
    Generaciones
    g(integer) -> Generations valores (> 0, 0 = Infinito -> key break)
    velocidad
    s(integer) -> speed valores [250 - 1000]
    Vecindario
    n(integer) -> neighborhood valores [1,2,3,4,5] y 0 vecindario completo
    (imagen)
    Poblacion inicial
    p(String) -> population valores separados por #(represanta el salto de fila) con valores 0 o 1 ejemplo "101#01#1"
2. Entramos en un bucle que se ejecuta hasta el numero de generaciones o hasta que no queden celulas vivas
    dentro el bucle verificaremos las siguientes reglas para cada celula
    2.a viva? y tiene menos de dos vecinos entoces en la proxima generacion muere
    2.b viva? y tiene mas de dos vecinos entoces en la proxima generacion muere
    2.c viva? y tiene tres o dos veicnos entoces la celula vive en la proxima genereacion
    2.d muerta? y tiene tres vecinos vivos entoces la celula revive o nace en la proxima generacion
```

## ¿Cómo representar una cuadrícula de celdas?
Mediante una matrix:
```text
    [0 1 0]
    [0 1 0]
    [0 1 0]
```
## ¿Cómo implementar las reglas GOL en una cuadrícula celular?
**Regla 1** 
**Regla 2**
**Regla 3**
**Regla 4**

## ¿Cómo incluir las casillas del vecindario en las reglas GOL?
    Cada vecindario sera una lista de funciones, donde cada funcion imprime si la casilla vive o muere ejemplo:
    North(i,j) => matrix[i-1, j] == vive ? true : false

## ¿Cómo procesar los parámetros desde el exterior (argumentos)?
Segun los requisitos validar uno por uno por ejemplo:
El width debe contener unicamente los siguientes valores [10,20,40,80], podemos crear una lista llamada `widthValues` que contenga estos valores y asi verificar si el usuario ingreso un valor valido, este caso aplica tambien para el height y neighborhood.
En el caso de speed es mas sencillo, unicamente verificamos que la variable se encuntre entre el rango 250 y 1000.
Para la poblacion inicial iteramos el string y para cada indice actualizamos el valor de la matrix inicial que esa en ceros.


*By Yhonier Alegria*