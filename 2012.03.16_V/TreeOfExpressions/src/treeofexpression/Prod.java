/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeofexpression;

/**
 *
 * @author Dev
 */
public class Prod extends Operation {
    public Prod() {
        this.sign = '*';
    }

    @Override
    public int calculate() {
        return (this.left.calculate() * this.right.calculate());
    }
}
