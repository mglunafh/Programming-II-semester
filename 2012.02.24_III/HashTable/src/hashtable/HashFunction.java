/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hashtable;

/**
 *
 * @author FedorUvarychev
 */
public abstract class HashFunction<T> {
    public HashFunction (int size) {
        this.sizeOfHashTable = size;
    }
    
    public abstract int getHash(T obj);
    private int sizeOfHashTable;
}
