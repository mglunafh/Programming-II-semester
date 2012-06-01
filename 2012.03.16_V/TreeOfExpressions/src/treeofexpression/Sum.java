/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeofexpression;

/**
 *
 * @author Dev
 */
public class Sum extends Operation {
    public Sum() {
        this.sign = '+';
    }

    @Override
    public int calculate() {
        return (this.left.calculate() + this.right.calculate());
    }
}
