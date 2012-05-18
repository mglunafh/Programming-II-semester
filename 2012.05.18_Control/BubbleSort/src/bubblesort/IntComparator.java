/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

/**
 * Standard comparison of integer numbers.
 * @author FedorUvarychev
 */
public class IntComparator extends Comparator<Integer> {

    @Override
    public boolean less(Integer first, Integer second) {
        return (first < second);
    }
}
