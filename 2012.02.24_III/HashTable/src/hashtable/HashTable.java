/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import uniquelist.*;
import list.*;
import java.util.ArrayList;

/**
 *
 * @author Fedor Uvarychev Implementation of hash table with separate chaining.
 * There is also an opportunity to realize own hash function and make a hash
 * table with the former as an argument.
 */
public class HashTable<T> {

    /**
     *
     * @param size capacity of table.
     * @param hashF hash function.
     */
    public HashTable(int size, HashFunction<T> hashF) {
        this.size = size;
        this.hashFun = hashF;
        this.table = new ArrayList<>(size);
    }

    /**
     * Puts a value into the hash table.
     * @param value 
     */
    public void add(T value) {
        int hashValue = this.hashFun.getHash(value);
        try {
            this.table.get(hashValue).addToList(value);
        } catch (AlreadyExists ex) {
            System.out.println("Already exists");
        }
    }

    /**
     * Tries to look for a value in the table. 
     * @param value
     * @return true or false, true if there is value, false if not :-<. 
     */
    public boolean find(T value) {
        int hashValue = this.hashFun.getHash(value);
        try {
            this.table.get(hashValue).find(value);
        } catch (DoesNotExist ex) {
            return false;
        }
        return true;
    }

    /**
     * Deletes an element. 
     * @param value 
     */
    public void delete(T value) {
        int hashValue = this.hashFun.getHash(value);
        List.ListElement deleted;
        try {
            deleted = this.table.get(hashValue).find(value);
            this.table.get(hashValue).delete(deleted);
        } catch (DoesNotExist | OutOfBoundsException ex) {
            System.out.println("Does not exists.");
        }
    }
    private int size;
    private HashFunction<T> hashFun;
    private ArrayList<UniqueList<T>> table;
}
