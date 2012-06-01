/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeofexpression;

/**
 *
 * @author Dev
 */
public class Quot extends Operation {
    public Quot() {
        this.sign = '/';
    }

    @Override
    public int calculate() {
        return (this.left.calculate() / this.right.calculate());
    }
}