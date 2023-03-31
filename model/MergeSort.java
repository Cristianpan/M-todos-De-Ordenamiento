package model;

import java.util.LinkedList;
/**
 * Clase MergeSort
 * 
 * Representacion del metodo de ordenamiento Merge Sort
 * con una lista doblemente enlazada de arreglos de string
 * que contienen
 * los datos de un canal de youtube
 * 
 */

public class MergeSort extends ShortingMethod {
   /**
    * Numero de comparaciones
    */
   private int numberOfComparisons = 0;
   /**
    * Numero de uniones
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
   public MergeSort(LinkedList<String[]> list) {
      super(list);
   }

   /**
    * Constructor por defecto
    */
   public MergeSort() {
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
      numberOfComparisons = 0;
      numberOfMovements = 0;
      long startTime = System.currentTimeMillis();
      recMergeSort(getList(), 0, getList().size() - 1);
      setRunTime(System.currentTimeMillis() - startTime);
   }

   /**
    * Divide los elementos a la mitad recursivamente y dependiendo el tipo de
    * ordenamiento los junta para ordenarlos
    *
    * @param list  sublista a ordenar
    * @param start indice del inicio de la sublista
    * @param end   indice del final de la sublista
    */
   private void recMergeSort(LinkedList<String[]> list, int start, int end) {
      if (start < end) {
         int mid = (start + end) / 2;
         recMergeSort(list, start, mid);
         recMergeSort(list, mid + 1, end);
         switch (getTypeOfOrder()) {
            case "ASC":
               if (getIndexOfColumn() == 2 || getIndexOfColumn() == 6) {
                  mergeALF(list, start, mid, end);
               } else {
                  mergeASC(list, start, mid, end);
               }
               break;
            case "DESC":
               if (getIndexOfColumn() == 2 || getIndexOfColumn() == 6) {
                  mergeALFINV(list, start, mid, end);
               } else {
                  mergeDES(list, start, mid, end);
               }
               break;

         }
      }
   }

   /**
    * Mezcla las sublistas de forma ascendente
    * de los canales de Youtube, basado en la columna seleccionada.
    * Para elementos numéricos
    *
    * @param list  sublista a ordenar
    * @param start indice del inicio de la sublista izquierda
    * @param mid   indice del final de la sublista izquierda
    * @param end   indice del final de la sublista derecha
    */
   private void mergeASC(LinkedList<String[]> list, int start, int mid, int end) {
      LinkedList<String[]> left = new LinkedList<>();
      LinkedList<String[]> right = new LinkedList<>();

      for (int i = start; i <= mid; i++) {
         left.add(list.get(i));
      }

      for (int i = mid + 1; i <= end; i++) {
         right.add(list.get(i));
      }

      int i = 0, j = 0, k = start;

      while (i < left.size() && j < right.size()) {
         numberOfComparisons++;
         numberOfMovements++;
         if (Long.parseLong(left.get(i)[getIndexOfColumn()]) <= Long.parseLong(right.get(j)[getIndexOfColumn()])) {
            list.set(k, left.get(i));
            i++;
         } else {
            list.set(k, right.get(j));
            j++;
         }
         k++;
      }

      while (i < left.size()) {
         numberOfMovements++;
         list.set(k, left.get(i));
         i++;
         k++;
      }

      while (j < right.size()) {
         numberOfMovements++;
         list.set(k, right.get(j));
         j++;
         k++;
      }
   }

   /**
    * Mezcla las sublistas de forma descendente
    * de los canales de Youtube, basado basado en la columna seleccionada.
    * Para elementos numéricos
    *
    * @param list  sublista a ordenar
    * @param start indice del inicio de la sublista izquierda
    * @param mid   indice del final de la sublista izquierda
    * @param end   indice del final de la sublista derecha
    */
   private void mergeDES(LinkedList<String[]> list, int start, int mid, int end) {
      LinkedList<String[]> left = new LinkedList<>();
      LinkedList<String[]> right = new LinkedList<>();

      for (int i = start; i <= mid; i++) {
         left.add(list.get(i));
      }

      for (int i = mid + 1; i <= end; i++) {
         right.add(list.get(i));
      }

      int i = 0, j = 0, k = start;

      while (i < left.size() && j < right.size()) {
         numberOfComparisons++;
         numberOfMovements++;
         if (Long.parseLong(left.get(i)[getIndexOfColumn()]) >= Long.parseLong(right.get(j)[getIndexOfColumn()])) {
            list.set(k, left.get(i));
            i++;
         } else {
            list.set(k, right.get(j));
            j++;
         }
         k++;
      }

      while (i < left.size()) {
         numberOfMovements++;
         list.set(k, left.get(i));
         i++;
         k++;
      }

      while (j < right.size()) {
         numberOfMovements++;
         list.set(k, right.get(j));
         j++;
         k++;
      }
   }

   /**
    * Mezcla las sublistas en ordel ascendente
    * de los canales de Youtube, basado en la columna seleccionada.
    * Para elementos alfabéticos
    *
    * @param list  sublista a ordenar
    * @param start indice del inicio de la sublista izquierda
    * @param mid   indice del final de la sublista izquierda
    * @param end   indice del final de la sublista derecha
    */
   private void mergeALF(LinkedList<String[]> list, int start, int mid, int end) {
      LinkedList<String[]> left = new LinkedList<>();
      LinkedList<String[]> right = new LinkedList<>();

      for (int i = start; i <= mid; i++) {
         left.add(list.get(i));
      }

      for (int i = mid + 1; i <= end; i++) {
         right.add(list.get(i));
      }

      int i = 0, j = 0, k = start;

      while (i < left.size() && j < right.size()) {
         numberOfComparisons++;
         numberOfMovements++;
         if (left.get(i)[getIndexOfColumn()].toLowerCase()
               .compareTo(right.get(j)[getIndexOfColumn()].toLowerCase()) < 0) {
            list.set(k, left.get(i));
            i++;
         } else {
            list.set(k, right.get(j));
            j++;
         }
         k++;
      }

      while (i < left.size()) {
         numberOfMovements++;
         list.set(k, left.get(i));
         i++;
         k++;
      }

      while (j < right.size()) {
         numberOfMovements++;
         list.set(k, right.get(j));
         j++;
         k++;
      }
   }

   /**
    * Mezcla las sublistas en ordel descendente
    * de los canales de Youtube, basado en la columna seleccionada.
    * Para elementos alfabéticos
    *
    * @param list  sublista a ordenar
    * @param start indice del inicio de la sublista izquierda
    * @param mid   indice del final de la sublista izquierda
    * @param end   indice del final de la sublista derecha
    */
   private void mergeALFINV(LinkedList<String[]> list, int start, int mid, int end) {
      LinkedList<String[]> left = new LinkedList<>();
      LinkedList<String[]> right = new LinkedList<>();

      for (int i = start; i <= mid; i++) {
         left.add(list.get(i));
      }

      for (int i = mid + 1; i <= end; i++) {
         right.add(list.get(i));
      }

      int i = 0, j = 0, k = start;

      while (i < left.size() && j < right.size()) {
         numberOfComparisons++;
         numberOfMovements++;
         if (left.get(i)[getIndexOfColumn()].toLowerCase()
               .compareTo(right.get(j)[getIndexOfColumn()].toLowerCase()) > 0) {
            list.set(k, left.get(i));
            i++;
         } else {
            list.set(k, right.get(j));
            j++;
         }
         k++;
      }

      while (i < left.size()) {
         numberOfMovements++;
         list.set(k, left.get(i));
         i++;
         k++;
      }

      while (j < right.size()) {
         numberOfMovements++;
         list.set(k, right.get(j));
         j++;
         k++;
      }
   }

   /**
    * Retorna la informacion de las metricas aplicadas del metodo de ordenamiento
    * 
    * @return Informacion de las metricas aplicadas
    */

   @Override
   public String getMetricsInformation() {
      return ("Merge Sort," + getTypeOfOrder() + "," + getRunTime() + ","
            + numberOfComparisons + "," + numberOfMovements);
   }
}