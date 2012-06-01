/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeofexpression;

/**
 *
 * @author Dev
 */
public class TreeOfExpression {

    /**
     * Builds a tree from string.
     * @param expr must contain a mathematical expression if prefix notation.
     */
    TreeOfExpression(String expr) {
        index = 0;
        head = buildNode(expr);
        index = 0;
    }

    public String print() {
        return head.print();
    }

    public int calculate() {
        return head.calculate();
    }

    /**
     * Method which recursively constructs a node in the tree of expression.
     *
     * @param expr
     * @return
     */
    private TreeElement buildNode(String expr) {
        moveWhilePossible(expr);
        char curChar = expr.charAt(index);
        if (('0' <= curChar) && ('9' >= curChar)) {
            return new Const(getNumber(expr));
        }
        Operation currentOp = null;
        switch (curChar) {
            case '+':
                currentOp = new Sum();
                break;
            case '-':
                currentOp = new Subtraction();
                break;
            case '*':
                currentOp = new Prod();
                break;
            case '/':
                currentOp = new Quot();
                break;
        }
        index++;
        currentOp.setLeftSon(buildNode(expr));
        index++;
        currentOp.setRightSon(buildNode(expr));
        return currentOp;
    }

    /**
     * Parses a number from current position, also moves the position.
     *
     * @param expr
     * @return
     */
    private int getNumber(String expr) {
        String result = "";
        while (index < expr.length() && ('0' <= expr.charAt(index)) && ('9' >= expr.charAt(index))) {
            result += expr.charAt(index);
            index++;
        }
        return new Integer(result);
    }

    /**
     * Moves the index, skipping the trash in the given expression. Stops when
     * finds a digit, sign or parenthesis.
     *
     * @param expr
     */
    private void moveWhilePossible(String expr) {
        while (index < expr.length()) {
            for (int i = 0; i < permittedChars.length; i++) {
                if (permittedChars[i] == expr.charAt(index)) {
                    return;
                }
            }
            index++;
        }
    }
    private TreeElement head;
    private int index;
    private static char[] permittedChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '/'};
}
