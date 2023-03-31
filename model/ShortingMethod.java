package model;

import java.util.LinkedList;

/**
 * Clase Shorting Method
 * 
 * Clase abstracta que representa de forma generica un metodo de ordenamiento
 */
public abstract class ShortingMethod {
    /**
     * Lista doblemente enlazada de un arreglo de string
     */
    private LinkedList<String[]> list;
    /**
     * Numero de columna a ordenar
     */
    private int indexOfColumn;

    /**
     * Tipo de ordenamiento: <br>
     * ASC: Ordenamiento ascendente <br>
     * DESC: Ordenamiento descendente <br>
     */
    private String typeOfOrder;

    /**
     * Tiempo de ejecución
     */
    private long runTime = 0;

    public ShortingMethod(LinkedList<String[]> list) {
        this.list = list;
    }

    public ShortingMethod() {
        this.list = new LinkedList<>();
    }

    /**
     * Imprime la informacion de los caneles almacenados en la lista
     *
     */
    public void displayList() {
        for (String[] info : list) {
            System.out.println(info[0] + "," + info[1] + "," + info[2] + "," + info[3] + "," + info[4] + "," + info[5]
                    + "," + info[6] + "," + info[7]);
        }
    }

    /**
     * Agrega elementos al final de la lista
     * 
     * @param channel Nuevo dato a agregar en la lista
     */
    public void insert(String[] channel) {
        list.add(channel);
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
    public abstract void sort(String typeOfOrder, int indexOfColumn);

    /**
     * Retorna la informacion de las metricas aplicadas del metodo de ordenamiento
     * 
     * @return Informacion de las metricas aplicadas
     */

    public abstract String getMetricsInformation();

    /**
     * Retorna la lista doblemente enlazada de arreglos de string, que contienen los
     * datos de cada canal de youube
     * 
     * @return lista doblemente enlazada de arreglos de string, que contienen los
     *         datos de cada canal de youube
     */

    public LinkedList<String[]> getList() {
        return this.list;
    }

    /**
     * Asigna la lista doblemente enlazada de arreglos de string, que contienen los
     * datos de cada canal de youube
     * 
     * @param list Lista doblemente enlazada de arreglos de string, que contienen
     *             los
     *             datos de cada canal de youube
     */
    public void setList(LinkedList<String[]> list) {
        this.list = list;
    }

    /**
     * Retorna el indice de la columna con la cual se realizara el ordenamiento
     * 
     * @return Indifice de columna
     */
    public int getIndexOfColumn() {
        return indexOfColumn;
    }

    /**
     * Asigna el indice de la columna del dataSet con el cual se realizara el
     * ordenamiento
     * 
     * @param indexOfColumn Indice de columna
     */
    public void setIndexOfColumn(int indexOfColumn) {
        this.indexOfColumn = indexOfColumn;
    }

    /**
     * Retorna el ultimo tipo de ordenamiento realizado
     * 
     * @return Ultimo tipo de ordenamiento realizado
     */
    public String getTypeOfOrder() {
        return typeOfOrder;
    }

    /**
     * Asigna el tipo de ordenamiento a realizar
     * 
     * @param typeOfOrder Tipo de ordenamiento a realizar
     */
    public void setTypeOfOrder(String typeOfOrder) {
        this.typeOfOrder = typeOfOrder;
    }

    /**
     * Retorna el tiempo de ejecucion
     * 
     * @return Tiempo de ejecucion
     */
    public long getRunTime() {
        return runTime;
    }

    /**
     * Asigna el tiempo de ejecucion
     * 
     * @param runTime Tiempo de ejecucion en milisegundos
     */
    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

}
