package list;

public class List {

    public List() {
        ListElement sentinel = new ListElement(0, null);
        this.count = 0;
        this.head = sentinel;
        this.tail = sentinel;
    }

    public int length() {
        return this.count;
    }

    public boolean isEmpty() {
        return (0 == this.length());
    }

    public void addToHead(int val) {
        ListElement newHead = new ListElement(val, this.head);
        this.head = newHead;
        this.count++;
    }

    public int hd() {
        if (this.isEmpty()) {
            throw new EmptyListException();
        }
        return this.head.value;
    }

    public List tl() {
        if (this.isEmpty()) {
            throw new EmptyListException();
        }
        List tailOfList = new List(this.head.next, this.tail, this.count--);
        return tailOfList;
    }
    
/*
    private static boolean lessOrEquals(ListElement first, ListElement second) {
        return (first.value <= second.value);
    }

    private void addListElement(ListElement listEl) {
        listEl.next = this.head;
        this.head = listEl;
    }

    private List filter(ListElement basis) {
        ListElement temp = this.head;
        List filtered = new List();
        for (int i = 1; i < this.count; ++i) {
            if (lessOrEquals(basis, temp)) {
                filtered.addToHead(temp.value);
            }
            temp = temp.next;
        }
        return filtered;
    }
*/
    
    private static List merge(List first, List second) {
        List result = new List();
        
        return result;
    }
            
    private List(ListElement head, ListElement tail, int count) {
        this.head = head;
        this.tail = tail;
        this.count = count;
    }

    private class ListElement {

        public ListElement(int value, ListElement prev) {
            this.value = value;
            this.next = prev;
        }
        private int value;
        private ListElement next;
    }
    private ListElement head;
    private ListElement tail;
    private int count;
}
