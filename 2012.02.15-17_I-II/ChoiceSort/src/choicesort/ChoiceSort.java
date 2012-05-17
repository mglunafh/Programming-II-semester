/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package choicesort;

/**
 *
 * @author Fedor Uvarychev
 */
public class ChoiceSort {

    /**
     * Choice sort of array of integer.
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < min) {
                    minIndex = j;
                    min = array[j];
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minIndex] = temp;
        }
    }

    /**
     * Prints the array into a string, 
     * for example, {1, 5, 3} will be printed as "1 5 3 ".
     * @param array
     * @return
     */
    public static String print(int[] array) {
        String res = "";
        for (int i = 0; i < array.length; ++i) {
            res += array[i] + " ";
        }
        return res;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] array = {5, 4, 3, 2, 1};
        ChoiceSort.sort(array);
        String waggon = ChoiceSort.print(array);
        System.out.println(waggon);
    }
}
