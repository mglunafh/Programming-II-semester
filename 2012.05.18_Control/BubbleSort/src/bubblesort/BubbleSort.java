/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.ArrayList;

/**
 * Class which allows to sort generic ArrayList collections. 
 * For the arbitrary type T must be overrided method of abstract class Comparator. 
 * @author Fedor Uvarychev
 */
public class BubbleSort<T> {

    /**
     * Bubble sort of ArrayList collection of objects of arbitraty type.
     * @param collection
     * @param comp Comparator which defines a total order on type T.
     */
    public void bubbleSort(ArrayList<T> collection, Comparator<T> comp) {
        int bound = collection.size();
        for (int i = 0; i < bound; ++i) {
            for (int j = bound - 1; j > i; --j) {
                if (comp.less(collection.get(j), collection.get(j - 1))) {
                    T temp = collection.get(j);
                    collection.set(j, collection.get(j - 1));
                    collection.set(j - 1, temp);
                }
            }
        }
    }
    
    /**
     * Prints an integer collection to the string.
     * For example, collection [1,2,3,5,4] will be printed as "1 2 3 5 4 ".
     * @param collection
     * @return 
     */
    public String printInt(ArrayList<Integer> collection) {
        String result = "";
        for (Integer i : collection) {
            result += i + " ";
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int capacity = 30;
        ArrayList<Integer> collection = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; ++i) {
            collection.add(0, 13 * i % 11 + 18 * i % 29);
        }

        for (Integer i : collection) {
            System.out.format("%d ", i);
        }
    }
}
