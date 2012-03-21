package list;

public class List {

    public class Position {

        /// Returns the position of the next element of list.
        public Position getNext() throws InvalidPosition {
               if (null == this.label.next.pos)
                   throw new InvalidPosition();
            return this.label.next.pos;
        }

        /// Returns the element on current position. 
        public int getValue() {
            return this.label.value;
        }

        /// Adds a value to the list after current position.
        private void addToNext(int value) {
            ListElement theNext = new ListElement(value);
            theNext.next = this.label.next;
            this.label.next = theNext;
        }

        /// 'Deletes' next element of list.
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

    public boolean isEmpty() {
        return (0 == this.count);
    }

    /// Returns a position of a head of list.
    public Position hd() throws EmptyListException {
        if (this.isEmpty())
            throw new EmptyListException();
        return this.head.pos;
    }

    /// Inserts a given value into the list after the given position.
    public void addToNextPosition(Position pos, int value) {
        pos.addToNext(value);
        this.count++;
    }

    /// Adds a value to end of the list.
    public void addToEnd(int value) {
        this.addToNextPosition(this.tail.pos, value);
    }

    /// Deletes from the next position.
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
