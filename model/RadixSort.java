package model;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Clase RadixSort
 * 
 * Representacion del metodo de ordenamiento Radix Sort
 * con una lista doblemente enlazada de arreglos de string
 * que contienen
 * los datos de un canal de youtube
 * 
 */
public class RadixSort extends ShortingMethod {
    // Atributos
    /**
     * Numero de comparaciones
     */
    private int numberOfComparisons = 0;

    /**
     * Numero de movimientos
     * 
     */
    private int numberOfMovements = 0;

    /**
     * Constructor que recibe una lista doblemente enlazada de arreglos de string
     * que contienen
     * los datos de un canal de youtube
     * 
     * @param list Lista doblemente enlazada de arreglos de string que contienen
     *             los datos de cada canal de youtube
     */
    public RadixSort(LinkedList<String[]> list) {
        super(list);
    }

    /**
     * Constructor por defecto
     */
    public RadixSort() {
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
        setTypeOfOrder(typeOfOrder);
        setIndexOfColumn(indexOfColumn);
        setRunTime(System.currentTimeMillis());
        this.numberOfComparisons = 0;
        this.numberOfMovements = 0;
        if (getIndexOfColumn() != 2 && getIndexOfColumn() != 6) {
            long m = getMax();
            for (int exp = 1; m / exp > 0; exp *= 10) {
                switch (typeOfOrder) {
                    case "ASC":
                        countSortAsc(exp);
                        break;
                    case "DESC":
                        countingSortDesc(exp);
                        break;
                    default:
                        break;
                }
            }
        }
        setRunTime(System.currentTimeMillis() - getRunTime());
    }

    /**
     * Retorna el valor maximo de la lista
     * 
     * @return Valor maximo de la lista
     */
    private Long getMax() {
        Long maxValue;

        maxValue = Long.parseLong(getList().get(0)[getIndexOfColumn()]);

        for (String[] youtubeChannel : getList()) {
            if (Long.parseLong(youtubeChannel[getIndexOfColumn()]) > maxValue)
                maxValue = Long.parseLong(youtubeChannel[getIndexOfColumn()]);
            this.numberOfComparisons++;
        }

        return maxValue;
    }

    /**
     * Ordena ascendentemente, la lista de de arreglos de string, que contienen los
     * datos de cada canal de youube,
     * con base en el indice de la columna seleccionada
     * 
     * @param exp Representa 10^i
     */
    private void countSortAsc(long exp) {

        String output[][] = new String[getList().size()][];
        int i;
        long[] count = new long[10];
        Arrays.fill(count, 0);

        for (i = 0; i < getList().size(); i++)
            count[(int) ((Long.parseLong(getList().get(i)[getIndexOfColumn()]) / exp) % 10)]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = getList().size() - 1; i >= 0; i--) {
            output[(int) (count[(int) ((Long.parseLong(getList().get(i)[getIndexOfColumn()]) / exp) % 10)]
                    - 1)] = getList().get(i);
            count[(int) ((Long.parseLong(getList().get(i)[getIndexOfColumn()]) / exp) % 10)]--;
            this.numberOfMovements++;
        }

        setList(new LinkedList<String[]>(Arrays.asList(output)));
    }

    /**
     * Ordena descendentemente, la lista de de arreglos de string, que contienen los
     * datos de cada canal de youube,
     * con base en el indice de la columna seleccionada
     * 
     * @param exp Representa 10^i
     */
    private void countingSortDesc(long exp) {
        String output[][] = new String[getList().size()][];
        int i;
        long[] count = new long[10];
        Arrays.fill(count, 0);

        for (i = 0; i < getList().size(); i++)
            count[9 - (int) ((Long.parseLong(getList().get(i)[getIndexOfColumn()]) / exp) % 10)]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = getList().size() - 1; i >= 0; i--) {
            output[(int) --count[9
                    - (int) ((Long.parseLong(getList().get(i)[getIndexOfColumn()]) / exp) % 10)]] = getList().get(i);
            this.numberOfMovements++;
        }

        for (i = 0; i < getList().size(); i++) {
            getList().set(i, output[i]);
        }
    }

    /**
     * Retorna la informacion de las metricas aplicadas del metodo de ordenamiento
     * 
     * @return Informacion de las metricas aplicadas
     */

    @Override
    public String getMetricsInformation() {
        return ("Radix Sort," + getTypeOfOrder() + "," + getRunTime() + ","
                + numberOfComparisons + "," + numberOfMovements);
    }

}
