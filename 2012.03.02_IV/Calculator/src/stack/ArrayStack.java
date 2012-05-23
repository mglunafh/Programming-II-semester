/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

/**
 *
 * @author FedorUvarychev
 */
public class ArrayStack  extends Stack {
    
    public ArrayStack() {
        this.stack = new int[ArrayStack.capacity];
        this.topIndex = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return 0 == topIndex;
    }
    
    @Override
    public void push(int value) {
        this.stack[this.topIndex] = value;
        this.topIndex++;
    }
    
    @Override
    public void pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        this.topIndex--;
    }
    
    @Override
    public int top() throws EmptyStackException {
        if (this.isEmpty())
            throw new EmptyStackException();
        return this.stack[this.topIndex - 1];
    }
    
    private int[] stack;
    private static int capacity = 100;
    private int topIndex;
}
