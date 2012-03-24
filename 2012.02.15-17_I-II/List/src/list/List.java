package list;

public class List {

    public class Position {

        /**
         *
         * @return the position of the next element of list.
         * @throws InvalidPosition if the next position is null.
         */
        public Position getNext() {
//            if (null == this.label.next.pos) {
            //              throw new InvalidPosition();
            //        }
            return this.label.next.pos;
        }

        /**
         *
         * @return the element on current position. *
         */
        public int getValue() {
            return this.label.value;
        }

        /**
         *
         * @param value which will be added to the next position.
         */
        private void addToNext(int value) {
            ListElement theNext = new ListElement(value);
            theNext.next = this.label.next;
            this.label.next = theNext;
        }

        /**
         *
         * @throws InvalidPosition after a try to delete non-existing element.
         */
        private void deleteNext() throws InvalidPosition {
            this.label.next = this.label.next.next;
            throw new InvalidPosition();

        }

        private Position(ListElement current) {
            this.label = current;
        }
        private ListElement label;
    }

    public List() {
        ListElement sentinel = new ListElement(0);
        this.head = sentinel;
        this.tail = sentinel;
        this.count = 0;
    }

    /**
     *
     * @return true if list is empty, and false if not.
     */
    public boolean isEmpty() {
        return (0 == this.count);
    }

    /**
     *
     * @return a position of a head of list.
     * @throws EmptyListException if list is empty.
     */
    public Position hd() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException();
        }
        return this.head.pos;
    }

    /**
     * Inserts a given value into the list after the given position.
     *
     * @param pos
     * @param value
     */
    public void addToNextPosition(Position pos, int value) {
        pos.addToNext(value);
        this.count++;
    }

    /**
     * Adds a value to end of the list.
     *
     * @param value
     */
    public void addToEnd(int value) {
        this.addToNextPosition(this.tail.pos, value);
    }

    /**
     * Deletes from the next position.
     *
     * @param pos - position preceding the element method will delete.
     * @throws EndOfListException if there is nothing on next position.
     */
    public void deleteFromNextPosition(Position pos) throws EndOfListException {
        try {
            pos.deleteNext();
        } catch (InvalidPosition e) {
            throw new EndOfListException();
        }
        this.count--;
    }

    public class ListElement {

        public ListElement(int value) {
            this.value = value;
            this.pos = new Position(this);
        }
        private int value;
        private ListElement next;
        private Position pos;
    }
    private ListElement head;
    private ListElement tail;
    private int count;
}
