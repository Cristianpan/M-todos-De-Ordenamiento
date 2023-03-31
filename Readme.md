# Métodos de Ordenamiento

Elaborado por: 

- Diana Carolina Vázquez Rodríguez
- Cristian David Pan Zaldivar

El presente programa permite al usuario final, ordenar un dataSet.csv, correspondiente a
1000 canales de youtube con sus datos estadísticos, a través de 4 métodos de ordenamiento: 

- Binary Insertion Sort 
- Merge Sort
- Quick Sort
- Radix Sort

El dataSet contiene la información de datos estadísticos de canales de Youtube, cuya información se encuentra
representada de la siguiente manera: 

1. id: Identificador unico del canal. 
2. rank: Rango del canal (1 - 1000). 
3. Youtuber: Nombre del canal 
4. suscribers: Número de suscriptores del canal  
5. video views: Número de vistas hacia el canal  
6. video count: Número de videos existentes del canal  
7. category: Categoría correspondiente al canal   
8. started: Año de creación del canal

Durante la ejecución del programa, el usuario debera de introducir el digito de uno de los datos existentes del canal (de acuerdo como se presenta con anteriorirdad), el cual será tomado como referencia para poder aplicar los 4 algoritmos de ordenación. 

En caso de seleccionar dato cuyo valor represente una secuencia de caracteres, el sistema solo permitirá realizar dos tipos de ordenamiento: 

1. Alfabeticamente
2. Alfabeticamente inverso

En caso contrario, solo permitirá realizar otros dos tipos de ordenamiento: 

1. Ascendente
2. Descendente

Los resultados tras haber aplicado los algoritmos de ordenamiento, podran ser localizados en la carpeta [datosOrdenados](/datosOrdenados "Datos ordenados por algoritmo de ordenamiento"). De igualmanera, podrá consultar las métricas obtenidas en la misma carpeta. 

***Notas Adicionales:*** El metodo de ordenamiento radix sort no será aplicado en caso de haber seleccionado un dato cuyo valor represente una secuencia de caracteres, por ende sus métricas no se verán reflejadas. Sin embargo, en caso de haber realizado un tipo de ordenamiento valido con Radix Sort, el archivo será conservado

## Clonación del repositorio 
Para poder clonar el repositorio de github debera de realizar lo siguiente: 
1. Abrir el cmd (Símbolo del sistema). 
2. Ubicarse en la carpeta donde desea guardar el repositorio 
3. Utilizar el comando "git clone https://github.com/Cristianpan/Metodos-De-Ordenamiento.git"

## Compilación del programa
Para poder compilar y ejecutar el programa debera de realizar los siguientes pasos en el orden especificado: 
1. Abrir la carpeta del proyecto desde el cmd (Símbolo del sistema). 
2. Utilizar el comando "javac ShortingMethodApp.java". 
3. Utilizar el comando "java ShortingMethodApp".


***Nota adicional:*** La documentacion del codigo fuente podra encontrarla en la carpeta document y deberá de abrir el archivo "index.html" para poder visualizarlo

