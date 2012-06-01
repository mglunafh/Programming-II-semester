/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeofexpression;

/**
 *
 * @author Dev
 */
public class Const extends TreeElement {

    public Const(int number) {
        this.number = number;
        this.left = null;
        this.right = null;
    }

    @Override
    public int calculate() {
        return number;
    }

    @Override
    public String print() {
        return (" " + this.number);
    }
    private int number;
}
