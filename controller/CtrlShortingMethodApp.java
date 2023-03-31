package controller;

import model.BinaryInsertionSort;
import model.MergeSort;
import model.QuickSort;
import model.RadixSort;
import model.ShortingMethod;

import java.util.ArrayList;
import java.util.LinkedList;

import dao.DaoCSV;
import dao.DaoMetricsInformation;

/**
 * Clase CtrlShortingMethodApp
 * 
 * Representa el controlador del programa tomando en cuenta la arquitectura MVC
 * 
 */
public class CtrlShortingMethodApp {
    /**
     * Valor auxiliar para determinar si se realiza el ordenamiento con radixSort
     */
    private int indexColumnSelected;
    /**
     * Objectos de los metodo de ordenamiento
     */
    private ShortingMethod binaryInsertionMethod;
    private ShortingMethod mergeMethod;
    private ShortingMethod quickMethod;
    private ShortingMethod radixMethod;

    /**
     * Constructor que recibe el nombre del archivo csv a leer
     * 
     * @param fileName Nombre del archivo csv a leer
     */
    public CtrlShortingMethodApp(String fileName) {
        DaoCSV daoCSV = new DaoCSV();
        LinkedList<String[]> youtubeChannels = daoCSV.reedCsv(fileName);
        this.binaryInsertionMethod = new BinaryInsertionSort(youtubeChannels);
        this.mergeMethod = new MergeSort(youtubeChannels);
        this.radixMethod = new RadixSort(youtubeChannels);
        this.quickMethod = new QuickSort(youtubeChannels);
        DaoMetricsInformation.deleteMetricInformation();
    }

    /**
     * Selecciona el tipo de ordenamiento dada la opcion seleccionada por el usuario
     * 
     * @param valueOptionSelected Opcion seleccionada por el usuario
     */
    public void toDoSort(int valueOptionSelected) {
        switch (valueOptionSelected) {
            case 1:
                binaryInsertionMethod.sort("ASC", indexColumnSelected);
                mergeMethod.sort("ASC", indexColumnSelected);
                quickMethod.sort("ASC", indexColumnSelected);
                if (indexColumnSelected != 2 && indexColumnSelected != 6)
                    radixMethod.sort("ASC", indexColumnSelected);
                break;
            case 2:
                binaryInsertionMethod.sort("DESC", indexColumnSelected);
                mergeMethod.sort("DESC", indexColumnSelected);
                quickMethod.sort("DESC", indexColumnSelected);
                if (indexColumnSelected != 2 && indexColumnSelected != 6)
                    radixMethod.sort("DESC", indexColumnSelected);
                break;
            default:
                System.out.println("El valor digitado no corresponde a alguna opcion");
                break;
        }

    }

    /**
     * Despliega el menu de opciones para el usuario con base en la columna
     * seleccionada
     * 
     * @param indexColumnSelected Indice de la columna seleccionada por el usuario
     *                            para implementar los metodos de ordenamiento
     */
    public void displayMenuOptionTypeOfOrder(int indexColumnSelected) {
        this.indexColumnSelected = indexColumnSelected - 1;
        System.out.println("Por favor digite el indice del tipo de ordenamiento que desea realizar");
        if (this.indexColumnSelected != 6 && this.indexColumnSelected != 2) {
            System.out.println("1. Ascendente");
            System.out.println("2. Descentente");
        } else {
            System.out.println("1. Alfabeticamente");
            System.out.println("2. Alfabeticamente inverso");
        }
    }

    /**
     * Despliega el menu inicial de opciones para el usuario
     */
    public void displayMenuOptionColumn() {
        System.out.println("Por favor digite el indice de la columna a traves del cual se ordenara");
        System.out.println("1. index");
        System.out.println("2. Rank");
        System.out.println("3. Channel_Name");
        System.out.println("4. Subscriber_Count");
        System.out.println("5. Video_Views");
        System.out.println("6. Video_Count");
        System.out.println("7. Genre");
        System.out.println("8. Channel_Started");
    }

    /**
     * Genera los archivos csv correspondientes a cada tipo de ordenamiento
     * con el tipo de orden especificado, correspondiente a los canales de youtube
     *
     */
    public void genereteCsv() {
        DaoCSV daoCSV = new DaoCSV();
        daoCSV.generateCsv(binaryInsertionMethod.getList(), "BinaryInsertionSort_Ordenado.csv");
        daoCSV.generateCsv(mergeMethod.getList(), "MergeSort_Ordenado.csv");
        daoCSV.generateCsv(quickMethod.getList(), "QuickSort_Ordenado.csv");
        if (this.indexColumnSelected != 2 && this.indexColumnSelected != 6)
            daoCSV.generateCsv(radixMethod.getList(), "RadixSort_Ordenado.csv");
    }

    /**
     * Inserta los resultados de la metricas, por cada metodo de ordenamiento, en un
     * archivo de texto
     */
    public void genereteMetricsInformation() {
        ArrayList<String> metricsInformation = new ArrayList<String>();

        metricsInformation.add(binaryInsertionMethod.getMetricsInformation());
        metricsInformation.add(mergeMethod.getMetricsInformation());
        metricsInformation.add(quickMethod.getMetricsInformation());
        if (this.indexColumnSelected != 2 && this.indexColumnSelected != 6) {
            metricsInformation.add(radixMethod.getMetricsInformation());
        }
        DaoMetricsInformation.addMetricInformation(metricsInformation);
    }

}
