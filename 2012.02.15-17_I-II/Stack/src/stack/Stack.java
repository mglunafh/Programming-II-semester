
package stack;

public class Stack {

    public void push(int val) {
        StackElement newHead = new StackElement(val, this.head);
        this.head = newHead;
    }

    public int pop() {
        int top = this.head.value;
        this.head = this.head.next;
        return top;
    }

    public int top() {
        return this.head.value;
    }
    private class StackElement {

        public StackElement(int value, StackElement next) {
            this.value = value;
            this.next = next;
        }
        private int value;
        private StackElement next;
    }

    private StackElement head;

    public static void main(String[] args) {
    }
}