package stack;

/**
 *
 * @author Dev
 */
public class Stack {

    /**
     * @return true in case of empty stack
     *
     */
    public boolean isEmpty() {
        return (null == this.head);
    }

    /**
     *
     * @param value which is been put into the stack.
     */
    public void push(int value) {
        StackElement newHead = new StackElement(value, this.head);
        this.head = newHead;
    }

    /**
     *
     * @throws EmptyStackException raises, when stack is empty.
     */
    public void pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        this.head = this.head.next;
    }

    /**
     *
     * @return a value on top of the stack.
     * @throws EmptyStackException raises, when method tries to put a value from
     * empty stack.
     */
    public int top() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
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

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
    }
}