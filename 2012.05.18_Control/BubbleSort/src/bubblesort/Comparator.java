/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bubblesort;

/**
 * Abstract comparison of objects of arbitrary type.
 * @author FedorUvarychev
 */
public abstract class Comparator<T> {
    
    public abstract boolean less(T first, T econd);
}
