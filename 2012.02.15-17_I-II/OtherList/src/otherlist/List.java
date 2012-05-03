/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otherlist;

/**
 *
 * @author Fedor Uvarychev
 * @param <T> class, elements of which are collected in list.
 */
public class List<T> {

    /**
     * Basic structure of list.
     */
    public class ListElement {

        /**
         * Hmm, constructor of element of list. 
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
         * @return the position of the next element of list.
         */
        public ListElement getNext() {
            return this.next;
        }

        /**
         *
         * @param value will be inserted into list after the given position.
         */
        public void addNext(T value) {
            ListElement newElement = new ListElement(value);
            newElement.next = this.next;
            this.next = newElement;
        }

        /**
         * Deletes element which follows by given.
         *
         * @throws InvalidPositionException if the next element is null.
         */
        public void deleteNext() throws InvalidPositionException {
            if (null == this.next) {
                throw new InvalidPositionException();
            }
            this.next = this.next.next;
        }
        private T value;
        private ListElement next;
    }

    /**
     * Constructor creates a sentinel for a new list..
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
    public ListElement hd() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException();
        }
        return this.head.next;
    }

    /**
     * Add element to end of list.
     *
     * @param value
     */
    public void addToEnd(T value) {
        this.tail.addNext(value);
        this.count++;
        this.tail = this.tail.next;
    }

    /**
     * Inserts a value after a given position.
     *
     * @param pos
     * @param value
     */
    public void insert(ListElement pos, T value) {
        if (null == pos.next) {
            addToEnd(value);
        } else {
            pos.addNext(value);
            this.count++;
        }
    }

    /**
     * Deletes head of list
     * @throws EmptyListException when list is empty.
     */
    public void deleteHead() throws EmptyListException {
        if (this.isEmpty())
            throw new EmptyListException();
        this.head = this.head.next;
    }
    /**
     * Deletes an element from the list after the given position.
     *
     * @param pos
     * @throws EndOfListException when element 'pos' is last in the list.
     */
    public void delete(ListElement pos) throws EndOfListException {
        try {
            pos.deleteNext();
        } catch (InvalidPositionException e) {
            e.printStackTrace();
            throw new EndOfListException();
        }
        this.count--;
    }
    private ListElement head;
    private ListElement tail;
    private int count;
}
