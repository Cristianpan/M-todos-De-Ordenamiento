package dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DaoMetricsInformation {
    /**
     * Escribe un archivo csv con los datos de las metricas obtenidas de un
     * metodo de ordenamiento tras su ejecucion
     * 
     * @param metricsInformation Arreglo de strings con los resultados de las
     *                           metricas de los metodos de ordenamiento realizados
     */
    public static void addMetricInformation(ArrayList<String> metricsInformation) {
        try {
            PrintWriter printer = new PrintWriter(new FileWriter("./datosOrdenados/Informacion_De_Metricas.csv", true));
            printer.write(
                    "Algoritmo, Tipo de ordenamiento, Tiempo de ejecucion, Numero de comparaciones, Movimientos/Desplazamientos\n");
            for (String element : metricsInformation) {
                printer.write(element + "\n");
            }
            printer.close();
        } catch (IOException e) {
            System.out.println("Error al generar el archivo");
        }
    }

    /**
     * Elimina el archivo de metricas si es que ha sido generado
     */
    public static void deleteMetricInformation() {
        File file = new File("./datosOrdenados/Informacion_De_Metricas.csv");
        if (file.exists()) {
            file.delete();
        }
    }
}
