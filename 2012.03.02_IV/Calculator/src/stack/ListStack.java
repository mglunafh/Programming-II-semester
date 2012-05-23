package stack;

/**
 *
 * @author Dev
 */
public class ListStack extends Stack{

    ListStack() {
        this.head = new StackElement(0, null);
    }

    /**
     *
     * @return true in case of empty stack
     */
    @Override
    public boolean isEmpty() {
        return (null == this.head.next);
    }

    /**
     *
     * @param value which is been put into the stack.
     */
    @Override
    public void push(int value) {
        StackElement newHead = new StackElement(value, this.head);
        this.head = newHead;
    }

    /**
     *
     * @throws EmptyStackException raises, when stack is empty.
     */
    @Override
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
    @Override
    public int top() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.head.value;
    }

    private class StackElement {

        /**
         * Inserts the new StackElement before element 'next'.
         * @param value
         * @param next 
         */
        private StackElement(int value, StackElement next) {
            this.value = value;
            this.next = next;
        }
        private int value;
        private StackElement next;
    }
    private StackElement head;
}