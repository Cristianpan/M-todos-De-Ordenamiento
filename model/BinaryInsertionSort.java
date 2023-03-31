package model;

import java.util.LinkedList;

/**
 * Clase BinaryInsertionSort
 * 
 * Representacion del metodo de ordenamiento Binary Insertion Sort
 * con una lista doblemente enlazada de arreglos de string
 * que contienen
 * los datos de un canal de youtube
 * 
 */
public class BinaryInsertionSort extends ShortingMethod {
    /**
     * Numero de comparaciones
     */
    private int numberOfComparisons = 0;
    /**
     * Numero de desplazamientos
     */
    private int numberOfDisplacements = 0;

    /**
     * Constructor que recibe una lista doblemente enlazada de arreglos de string
     * que contienen
     * los datos de un canal de youtube
     * 
     * @param list Lista doblemente enlazada de arreglos de string que contienen
     *             los datos de cada canal de youtube
     */
    public BinaryInsertionSort(LinkedList<String[]> list) {
        super(list);
    }

    /**
     * 
     * Constructor por defecto
     */
    public BinaryInsertionSort() {
        super();
    }

    /**
     * Ordena la lista de canales de youtube en el orden especificado
     * 
     * @param typeOfOrder   Tipo de ordenamiento: <br>
     *                      ASC: Ordenamiento ascendente <br>
     *                      DESC: Ordenamiento descendente <br>
     * @param indexOfColumn Indice de la columna a traves de la cual se realizara el
     *                      metodo de ordenamiento
     */
    @Override
    public void sort(String typeOfOrder, int indexOfColumn) {
        setTypeOfOrder(typeOfOrder);
        setIndexOfColumn(indexOfColumn);
        numberOfComparisons = 0;
        numberOfDisplacements = 0;
        long startTime = System.currentTimeMillis();
        binaryInsertionSort(getList(), getList().size());
        setRunTime(System.currentTimeMillis() - startTime);
    }

    /**
     * Retorna la informacion de las metricas aplicadas del metodo de ordenamiento
     * 
     * @return Informacion de las metricas aplicadas
     */

    @Override
    public String getMetricsInformation() {
        return ("Binary Insertion Sort," + getTypeOfOrder() + "," + getRunTime() + ","
                + numberOfComparisons + "," + numberOfDisplacements);
    }

    /**
     * Se realiza la iteración de los elementos de la lista, para mandar el elemento
     * a la función de busqueda binaria (dependiendo su tipo) para saber donde se
     * ordenará el elemento de la columna seleccionada
     * 
     * @param theArray Lista a ordenar
     * @param n        tamaño de la lista
     * 
     */
    private void binaryInsertionSort(LinkedList<String[]> theArray, int n) {
        int i, loc = 0, j;
        String[] selected;

        for (i = 1; i < n; ++i) {
            j = i - 1;

            selected = theArray.get(i);

            switch (getTypeOfOrder()) {
                case "ASC":
                    if (getIndexOfColumn() == 2 || getIndexOfColumn() == 6) {
                        loc = binarySearchALF(theArray, selected, 0, j);
                    } else {
                        loc = binarySearchASC(theArray, selected, 0, j);
                    }
                    break;
                case "DESC":
                    if (getIndexOfColumn() == 2 || getIndexOfColumn() == 6) {
                        loc = binarySearchALFINV(theArray, selected, 0, j);
                    } else {
                        loc = binarySearchDES(theArray, selected, 0, j);
                    }
                    break;
                default:
                    break;
            }

            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) {

                theArray.set(j + 1, theArray.get(j));
                j--;
                numberOfDisplacements++;
            }
            theArray.set(j + 1, selected);
            numberOfDisplacements++;
        }
    }

    /**
     * Realiza la busqueda binaria para encontrar la posición en orden ascendente
     * de los canales de Youtube, basado en la columna seleccionada. Para elementos
     * numéricos
     * 
     * @param theArray Lista a ordenar
     * @param item     Posición del canal de Youtube por su número de suscriptores a
     *                 buscar
     * @param low      indice menor de la sublista
     * @param high     indice mayor de la sublista
     * @return el índice para insertar el elemento
     * 
     */
    private int binarySearchASC(LinkedList<String[]> theArray, String[] item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (Long.parseLong(item[getIndexOfColumn()]) == Long.parseLong(theArray.get(mid)[getIndexOfColumn()]))
                return mid + 1;
            else if (Long.parseLong(item[getIndexOfColumn()]) > Long.parseLong(theArray.get(mid)[getIndexOfColumn()]))
                low = mid + 1;
            else
                high = mid - 1;
            numberOfComparisons++;
        }
        return low;
    }

    /**
     * Realiza la busqueda binaria para encontrar la posición en orden descendente
     * de los canales de Youtube, basado en la columa seleccionada. Para elementos
     * numéricos
     * 
     * @param theArray Lista a ordenar
     * @param item     Posición del canal de Youtube por su número de suscriptores a
     *                 buscar
     * @param low      indice menor de la sublista
     * @param high     indice mayor de la sublista
     * @return el índice para insertar el elemento
     * 
     */
    private int binarySearchDES(LinkedList<String[]> theArray, String[] item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (Long.parseLong(item[getIndexOfColumn()]) == Long.parseLong(theArray.get(mid)[getIndexOfColumn()]))
                return mid + 1;
            else if (Long.parseLong(item[getIndexOfColumn()]) < Long.parseLong(theArray.get(mid)[getIndexOfColumn()]))
                low = mid + 1;
            else
                high = mid - 1;
            numberOfComparisons++;
        }
        return low;
    }

    /**
     * Realiza la busqueda binaria para encontrar la posición en orden ascendente
     * de los canales de Youtube, basado en la columna seleccionada. Para elementos
     * alfabéticos
     * 
     * @param theArray Lista a ordenar
     * @param item     la primera letra del nombre del canal de Youtube a buscar
     * @param low      indice menor de la sublista
     * @param high     indice mayor de la sublista
     * @return el índice para insertar el elemento
     * 
     */
    private int binarySearchALF(LinkedList<String[]> theArray, String[] item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (item[getIndexOfColumn()].toLowerCase().equals(theArray.get(mid)[getIndexOfColumn()].toLowerCase()))
                return mid + 1;
            else if (item[getIndexOfColumn()].toLowerCase()
                    .compareTo(theArray.get(mid)[getIndexOfColumn()].toLowerCase()) > 0)
                low = mid + 1;
            else
                high = mid - 1;
            numberOfComparisons++;
        }
        return low;
    }

    /**
     * Realiza la busqueda binaria para encontrar la posición en orden descendente
     * de los canales de Youtube, basado en la columna seleccionada. Para elementos
     * alfabéticos
     * 
     * @param theArray Lista a ordenar
     * @param item     la primera letra del nombre del canal de Youtube a buscar
     * @param low      indice menor de la sublista
     * @param high     indice mayor de la sublista
     * @return el índice para insertar el elemento
     * 
     */
    private int binarySearchALFINV(LinkedList<String[]> theArray, String[] item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (item[getIndexOfColumn()].toLowerCase().equals(theArray.get(mid)[getIndexOfColumn()].toLowerCase()))
                return mid + 1;
            else if (item[getIndexOfColumn()].toLowerCase()
                    .compareTo(theArray.get(mid)[getIndexOfColumn()].toLowerCase()) < 0)
                low = mid + 1;
            else
                high = mid - 1;
            numberOfComparisons++;
        }
        return low;
    }
}