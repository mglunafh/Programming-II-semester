package list;

public class List {

    public class Position {
        
        public Position getNext() {
            return this.label.pos;
        }
        
        public int getValue() {
            return this.label.value;
        }
        
        private Position(ListElement current) {
            this.label = current;
        }
            
        private ListElement label;
    }
    
    public void addToEnd(int value) {
        
    }
    

    private class ListElement {

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
