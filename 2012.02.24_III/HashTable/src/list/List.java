/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Fedor Uvarychev
 * @param <T> class, elements of which are collected in list.
 */
public class List<T> implements Iterable<T> {

    /**
     * Basic structure of list, contains value, reference to next and previous
     * elements in the list.
     */
    private class ListElement {

        /**
         * Hmm, constructor of element of list.
         *
         * @param value
         */
        public ListElement(T value) {
            this.value = value;
        }

        /**
         *
         * @return the element on current position. *
         */
        public T getValue() {
            return this.value;
        }

        /**
         *
         * @return the position of the next element in list.
         */
        public ListElement getNext() {
            return this.next;
        }

        /**
         *
         * @return the position of the previous element.
         */
        public ListElement getPrev() {
            return this.prev;
        }

        /**
         *
         * @param value will be inserted into list after the given position.
         */
        public void addNext(T value) {
            ListElement newElement = new ListElement(value);
            newElement.next = this.next;
            newElement.prev = this;
            this.next = newElement;
        }

        /**
         * Deletes the given element.
         */
        private void delete() {
            ListElement nextElement = this.next;
            ListElement prevElement = this.prev;
            prevElement.next = nextElement;
            if (null != nextElement) {
                nextElement.prev = prevElement;
            }
            count--;
        }
        private T value;
        private ListElement next;
        private ListElement prev;
    }

    /**
     * Constructor creates a sentinel for a new list.
     */
    public List() {
        ListElement sentinel = new ListElement(null);
        this.head = sentinel;
        this.tail = sentinel;
        this.count = 0;
    }

    /**
     *
     * @return true, if the list is empty, and false --- otherwise.
     */
    public boolean isEmpty() {
        return (0 == this.count);
    }

    /**
     *
     * @return a length of list.
     */
    public int length() {
        return this.count;
    }

    /**
     * Add element to end of list.
     *
     * @param value
     */
    public void addToList(T value) {
        this.tail.addNext(value);
        this.count++;
        this.tail = this.tail.next;
    }

    /**
     * Deletes an element from the given position in the list.
     *
     * @param pos
     */
    public void delete(Object pos) {
        ((ListElement) pos).delete();
    }

    /**
     * Method, which finds a given value in the list.
     *
     * @param value
     * @return Object postion, if finds, and null otherwise.
     */
    public Object find(T value) {
        try {
            ListIterator it = this.iterator();
            while (it.hasNext()) {
                if (it.next().equals(value) ) {
                    return it.iter;
                }
            }
            return null;
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    /**
     * Method, returning an iterator of list.
     *
     * @return
     * @throws NoSuchElementException, if the list is empty.
     */
    @Override
    public ListIterator iterator() {
        ListIterator it = new ListIterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        return it;
    }

    /**
     * Implementation of iterator for this collection. Overrided 'remove',
     * 'next' and 'hasNext' methods only. After using "foreach" iterator becomes
     * null.
     */
    public class ListIterator implements Iterator<T> {

        private ListIterator() {
            this.iter = head;
        }

        @Override
        public boolean hasNext() {
            return (null != this.iter.next);
        }
 
        /**
         * Shifts the iterator forward, if possible, and returns value.
         * @return the value on current position of iterator. 
         */
        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.iter = this.iter.next;
            return this.iter.getValue();
        }

       /**
         * Removeth awaye the last seen element from list.
         */
        @Override
        public void remove() {
            if (head == iter) {
                head.next.delete();
            } else {
                ListElement temp = iter;
                iter = iter.next;
                temp.delete();
            }
        }
        /**
         * Cursor to previous list element.
         */
        private ListElement iter;
    }
    private ListElement head;
    private ListElement tail;
    private int count;
}