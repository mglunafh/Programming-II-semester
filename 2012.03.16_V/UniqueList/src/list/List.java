/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author Fedor Uvarychev
 * @param <T> class, elements of which are collected in list.
 */
public class List<T> {

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
     *
     * @return a position of head of list.
     * @throws EmptyListException when list is empty.
     */
    public Object hd() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException();
        }
        return this.head.next;
    }
    
    
    public T getValue(Object position) {
        ListElement temp = (ListElement)position;
        return temp.getValue();
    }
    
    public Object getNextPosition(Object position) {
        ListElement temp =(ListElement)position;
        return temp.next; 
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
        ((ListElement)pos).delete();
        this.count--;
    }
    
    
    /**
     * Method, which finds a given value in the list.
     * @param value
     * @return true, if finds, and false otherwise.
     */
    public boolean find(T value) {
        Object temp;
        try {
            temp = this.hd();
        } catch (EmptyListException e) {
            return false;
        }

        while (temp != null) {
            if (this.getValue(temp) == value) {
                return true;
            }
            temp = this.getNextPosition(temp);
        }
        return false;
    }
    private ListElement head;
    private ListElement tail;
    private int count;
}