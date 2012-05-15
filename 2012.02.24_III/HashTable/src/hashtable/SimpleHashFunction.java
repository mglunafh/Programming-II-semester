/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

/**
 *
 * @author FedorUvarychev
 */
public class SimpleHashFunction<String> extends HashFunction<String> {

    public SimpleHashFunction (int size) {
        super(size);
    }
    @Override
    public int getHash(String str) {
        return 15 % this.sizeOfHashTable;
    }
}
