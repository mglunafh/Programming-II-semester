package otherlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    /**
     *
     * @param position
     * @return a value on given position.
     */
    public T getValue(Object position) {
        ListElement temp = (ListElement) position;
        return temp.getValue();
    }

    /**
     *
     * @param position
     * @return a reference to the next position.
     */
    public Object getNextPosition(Object position) {
        ListElement temp = (ListElement) position;
        return temp.next;
    }

    /**
     * Inserts a given value before the current head of the list.
     *
     * @param value
     */
    public void addToHead(T value) {
        if (null == this.head.next) {
            this.addToEnd(value);
        } else {
            ListElement newHead = new ListElement(value);
            newHead.next = this.head.next;
            this.head.next = newHead;
        }
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
     * Inserts a value after a given position. This method cannot insert a value
     * before the head of list, use method addToHead instead.
     *
     * @param pos
     * @param value
     */
    public void insert(Object pos, T value) {
        if (null == ((ListElement) pos).next) {
            addToEnd(value);
        } else {
            ((ListElement) pos).addNext(value);
            this.count++;
        }
    }

    /**
     * Deletes an element from the given position in the list.
     *
     * @param pos
     */
    public void delete(Object pos) {
        ((ListElement) pos).delete();
        this.count--;
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
            this.iter = head.next;
        }

        /**
         * Removeth awaye the element from hys position.
         */
        @Override
        public void remove() {
            ListElement temp = this.iter.next;
            this.iter.delete();
            this.iter = temp;
        }

        @Override
        public boolean hasNext() {
            return (null != this.iter);
        }

        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            ListElement temp = this.iter;
            this.iter = this.iter.next;
            return temp.getValue();
        }
        /**
         * Cursor to current element in the list.
         */
        private ListElement iter;
    }
    private ListElement head;
    private ListElement tail;
    private int count;
}
