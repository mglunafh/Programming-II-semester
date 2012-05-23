/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Fedor Uvarychev
 */
public interface StackInterface {
    
    /**
     * Checks, if the stack is empty.
     * @return true in case of empty stack.
     */
    public boolean isEmpty();
    
    /**
     * Pushes the given value into the head of stack.
     * @param value which is been put into the stack.
     */
    public void push(int value);
    
    /**
     * Shifts down the top of the stack.
     * @throws EmptyStackException raises, when stack is empty.
     */
    public void pop() throws EmptyStackException;
    
    /**
     *
     * @return a value on top of the stack.
     * @throws EmptyStackException raises, when method tries to put a value from
     * empty stack.
     */
    public int top() throws EmptyStackException;
    
}
