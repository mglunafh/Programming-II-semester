/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

/**
 *
 * @author FedorUvarychev
 */
public class SimpleHashFunction extends HashFunction<String> {

    public SimpleHashFunction (int capacity) {
        super(capacity);
    }
    @Override
    public int getHash(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); ++i) {
            result += str.codePointAt(i);
        } 
       return result % this.capacity;
    }
}
