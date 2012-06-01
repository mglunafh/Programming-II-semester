/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeofexpression;

/**
 *
 * @author Dev
 */
public abstract class TreeElement {

    
    abstract public int calculate();

    abstract public String print();
    
    protected TreeElement left;
    protected TreeElement right;
}
