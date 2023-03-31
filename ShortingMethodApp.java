

import java.util.Scanner;

import controller.CtrlShortingMethodApp;

public class ShortingMethodApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CtrlShortingMethodApp shortingMethodApp = new CtrlShortingMethodApp("dataSet.csv");

        int valueOptionColum = 0, valueOptionTypeOfOrder = 0;
        do {
            shortingMethodApp.displayMenuOptionColumn();
            valueOptionColum = scan.nextInt();
            clearTheConsole();
            if (valueOptionColum < 1 || valueOptionColum > 8) {
                System.out.println("El valor digitado no corresponde a alguna opcion");
            }
        } while (valueOptionColum < 1 || valueOptionColum > 8);

        do {
            shortingMethodApp.displayMenuOptionTypeOfOrder(valueOptionColum);
            valueOptionTypeOfOrder = scan.nextInt();
            clearTheConsole();
            shortingMethodApp.toDoSort(valueOptionTypeOfOrder);

        } while (valueOptionTypeOfOrder < 1 || valueOptionTypeOfOrder > 2);

        shortingMethodApp.genereteCsv();
        shortingMethodApp.genereteMetricsInformation();

        clearTheConsole();

        System.out.println("Los archivos con el tipo de ordenamiento especificado han sido generados");
        System.out.println("Puede consultar el archivo de metricas en: ");
        System.out.println("Informacion_De_Metricas.csv");

        scan.close();
    }

    public static void clearTheConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
