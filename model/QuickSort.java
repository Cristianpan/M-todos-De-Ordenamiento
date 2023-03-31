package model;

import java.util.LinkedList;

/**
 * Clase QuickSort
 * 
 * Representacion del metodo de ordenamiento Quick Sort
 * con una lista doblemente enlazada de arreglos de string
 * que contienen
 * los datos de un canal de youtube
 * 
 */
public class QuickSort extends ShortingMethod {

    // Atributos
    /**
     * Numero de comparaciones
     */
    private int numberOfComparisons = 0;

    /**
     * Numero de movimientos
     * 
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
    public QuickSort(LinkedList<String[]> list) {
        super(list);
    }

    /**
     * Constructor por defecto
     */
    public QuickSort() {
        super();
    }

    /**
     * 
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
        this.numberOfComparisons = 0;
        this.numberOfDisplacements = 0;
        setTypeOfOrder(typeOfOrder);
        setIndexOfColumn(indexOfColumn);
        long startTime = System.currentTimeMillis();
        recQSort(0, getList().size() - 1);
        setRunTime(System.currentTimeMillis() - startTime);
    }

    // Methods for quick sort
    /**
     * Realiza el ordenado de la lista doblemente ligada utilizando Quick Sort dado
     * el tipo de
     * ordenamineto
     * 
     * @param low  Index del inicio de la sublista
     * @param high Index del final de la sublista
     * 
     */
    private void recQSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            recQSort(low, pi - 1);
            recQSort(pi + 1, high);
            numberOfComparisons++;
        }
    }

    /**
     * Toma el ultimo elemento de la sublista como pivote y lo coloca en
     * su posicion correcta de acuerdo al tipo de ordenamiento, colocando los
     * elementos más pequeños a su izquierda y los más grandes a su derecha.
     * Retorna el indice de particion
     * 
     * @param low  Indice inicial
     * @param high Indice final
     * @return Indice de particion
     */
    private int partition(int low, int high) {
        String[] pivot = getList().get(high);

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (compareTo(getList().get(j), pivot) > 0) {
                i++;
                swap(i, j);
                this.numberOfComparisons++;
            }
        }

        swap(i + 1, high);
        return (i + 1);
    }

    /**
     * Realiza el intercambio de posicion entre dos elementos de la lista
     * 
     * @param i Indice del primer elemento
     * @param j Indice del segundo elemento
     */
    private void swap(int i, int j) {
        String[] temp = getList().get(i);
        getList().set(i, getList().get(j));
        getList().set(j, temp);
        this.numberOfDisplacements++;
    }

    /**
     * Realiza la comparacion de los elementos con base en el tipo de ordenamiento
     * dado.
     * Retorna 1 en caso de cumplir la condicion dada y -1 en caso contrario.
     * 
     * @param element Elemento a comparar
     * @param pivot   Pivote de comparacion
     * @return 1, si se cumple la condicion dada por el tipo de ordenamiento <br>
     *         -1, si no se cumple la condicion
     * 
     */
    private int compareTo(String[] element, String[] pivot) {
        int value = -1;

        switch (getTypeOfOrder()) {
            case "ASC":
                if (getIndexOfColumn() == 2 || getIndexOfColumn() == 6) {
                    if (element[getIndexOfColumn()].toLowerCase()
                            .compareTo(pivot[getIndexOfColumn()].toLowerCase()) < 0)
                        value = 1;
                } else {
                    if (Long.parseLong(element[getIndexOfColumn()]) < Long.parseLong(pivot[getIndexOfColumn()]))
                        value = 1;
                }
                break;
            case "DESC":
                if (getIndexOfColumn() == 2 || getIndexOfColumn() == 6) {
                    if (element[getIndexOfColumn()].toLowerCase()
                            .compareTo(pivot[getIndexOfColumn()].toLowerCase()) > 0)
                        value = 1;
                    break;
                } else {
                    if (Long.parseLong(element[getIndexOfColumn()]) > Long.parseLong(pivot[getIndexOfColumn()]))
                        value = 1;
                }
                break;
            default:
                break;
        }
        return value;
    }

    /**
     * Retorna la informacion de las metricas aplicadas del metodo de ordenamiento
     * 
     * @return Informacion de las metricas aplicadas
     */

    @Override
    public String getMetricsInformation() {
        return ("Quick Sort," + getTypeOfOrder() + "," + getRunTime() + ","
                + numberOfComparisons + "," + numberOfDisplacements);
    }
}
