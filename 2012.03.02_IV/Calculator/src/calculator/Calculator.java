/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import stack.EmptyStackException;
import stack.Stack;

/**
 *
 * @author Fedor Uvarychev
 */
public class Calculator {
    
    public Calculator(Stack stack) {
        this.stack = stack;
    }

    /**
     * Method, which pushes the value into the operation stack of calculator.
     *
     * @param value
     */
    public void push(int value) {
        this.stack.push(value);
    }
    
    /**
     * @return a top of operation stack considered the current result.
     */
    public int result() {
        try {
            return this.stack.top();
        } catch (EmptyStackException ex) {
            throw new InvalidCountOfArgumentsException();
            }
    }
    /**
     * Then you can see four arithmetical operations, 
     * all they can throw InvalidCountOfArgumentsException.
     */
    public void add() {
        try {
            int secondOperand = this.stack.top();
            this.stack.pop();
            int firstOperand = stack.top();
            this.stack.push(firstOperand + secondOperand);
        } catch (EmptyStackException ex) {
            throw new InvalidCountOfArgumentsException();
        }
    }
    
    public void subtract() {
        try {
            int secondOperand = this.stack.top();
            this.stack.pop();
            int firstOperand = stack.top();
            this.stack.push(firstOperand - secondOperand);
        } catch (EmptyStackException ex) {
            throw new InvalidCountOfArgumentsException();
        }
    }
    
    public void mul() {
        try {
            int secondOperand = this.stack.top();
            this.stack.pop();
            int firstOperand = stack.top();
            this.stack.push(firstOperand * secondOperand);
        } catch (EmptyStackException ex) {
            throw new InvalidCountOfArgumentsException();
        }
    } 
    
    public void divide() {
        try {
            int secondOperand = this.stack.top();
            this.stack.pop();
            int firstOperand = stack.top();
            this.stack.push(firstOperand / secondOperand);
        } catch (EmptyStackException ex) {
            throw new InvalidCountOfArgumentsException();
        }
    }
    
    private Stack stack;
}
