/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import uniquelist.*;
import list.*;
import java.util.ArrayList;
import java.lang.String.*;

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
    public HashTable(int capacity, HashFunction<T> hashF) {
        this.capacity = capacity;
        this.hashFun = hashF;
        this.table = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; ++i) {
            UniqueList<T> temp = new UniqueList<>();
            this.table.add(temp);
        }
    }

    /**
     *
     * @return a count of values in table.
     */
    public int amountOf() {
        return this.count;
    }

    /**
     * Puts the value into table using its hash key.
     *
     * @param value
     */
    private void putToTable(ArrayList<UniqueList<T>> table, T value, int hashKey) {
        try {
            table.get(hashKey).addToList(value);
        } catch (AlreadyExists ex) {
            ex.printStackTrace();
        }
        count++;
    }

    /**
     * Puts a value into the hash table by normal way.
     *
     * @param value
     */
    public void add(T value) {
        int hashKey = this.hashFun.getHash(value);
        this.putToTable(this.table, value, hashKey);
    }

    /**
     * Tries to look for a value in the table.
     *
     * @param value
     * @return true or false, true if there is value, false if not :-<.
     */
    public boolean find(T value) {
        int hashValue = this.hashFun.getHash(value);
        return (null != this.table.get(hashValue).find(value));
    }

    /**
     * Deletes an element.
     *
     * @param value
     */
    public void delete(T value) {
        int hashValue = this.hashFun.getHash(value);
        Object extincted = this.table.get(hashValue).find(value);
        if (extincted != null) {
            this.table.get(hashValue).delete(extincted);
            count--;
        }

    }

    /**
     * Method, that reorganizes hash table according to new hash function.
     *
     * @param newHashFun
     */
    public void restruct(HashFunction<T> newHashFun) {
        ArrayList<UniqueList<T>> newBucket = new ArrayList<>(this.capacity);
        for (int i = 0; i < this.capacity; ++i) {
            UniqueList<T> temp = new UniqueList<>();
            newBucket.add(temp);
        }
        for (int i = 0; i < this.capacity; ++i) {
            for (T element : this.table.get(i)) {
                int newHashKey = newHashFun.getHash(element);
                this.putToTable(newBucket, element, newHashKey);
            }
        }
    }
    private int capacity;
    private HashFunction<T> hashFun;
    private ArrayList<UniqueList<T>> table;
    private int count;
}
