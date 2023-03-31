package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Clase DaoCSV
 * 
 * Representa un objecto de acceso a datos provenientes de un CSV,
 * cuyos datos corresponden estadisticos de un canal de youtube
 */
public class DaoCSV {
    /**
     * Titulos de las columnas de la tabla del CSV
     */
    private static String headers;

    /**
     * 
     * Lee el archivo csv y lo almacena en una lista doblemente ligada
     * 
     * @param fileName Nombre del archivo de entrada (lectura)
     * @return Lisda doblemente ligada de tipo arreglo de string con los datos de
     *         cada canal de youtube
     */

    public LinkedList<String[]> reedCsv(String fileName) {
        LinkedList<String[]> YoutubeChannels = new LinkedList<>();
        Scanner scan;
        try {
            scan = new Scanner(new FileReader(fileName));
            headers = scan.nextLine();
            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",");
                YoutubeChannels.add(line);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return YoutubeChannels;
    }

    /**
     * Escribe un archivo csv con los datos que corresponden una lista doblemente
     * ligada
     * 
     * @param list     Lista doblemente ligada de tipo YoutubeChannel
     * @param fileName Nombre del archivo a generar
     */
    public void generateCsv(LinkedList<String[]> list, String fileName) {
        try {
            PrintWriter printer = new PrintWriter(new FileWriter("./datosOrdenados/" + fileName, false));
            printer.write(headers + "\n");
            for (int i = 0; i < list.size(); i++) {
                printer.write(getInfo(list.get(i)) + "\n");
            }
            printer.close();
        } catch (IOException e) {
            System.out.println("Error al generar el archivo");
        }
    }

    public String getInfo(String[] info) {
        return (info[0] + "," + info[1] + "," + info[2] + "," + info[3] + "," + info[4] + "," + info[5]
                + "," + info[6] + "," + info[7]);
    }
}
