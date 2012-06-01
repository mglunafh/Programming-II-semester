package treeofexpression;

/**
 *
 * @author Dev
 */
public abstract class Operation extends TreeElement {

    @Override
    public String print() {
        return ("(" + sign + this.left.print() + this.right.print() +")");
    }
    
    
    public void setLeftSon(TreeElement leftSon) {
        this.left = leftSon;
    }
    
    public void setRightSon(TreeElement rightSon) {
        this.right = rightSon;
    }
    
    protected char sign;
}
