/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeofexpression;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class TreeOfExpressionTest {
    
    public TreeOfExpressionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        tree = new TreeOfExpression("+1 abgzvoyathre +44 55");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of print method, of class TreeOfExpression.
     */
    @Test
    public void testPrint() {
        
        assertEquals("(+ 1(+ 44 55))", tree.print());
        }

    /**
     * Test of calculate method, of class TreeOfExpression.
     */
    @Test
    public void testCalculate() {
        int expResult = 100;
        int result = tree.calculate();
        assertEquals(expResult, result);
        }
    TreeOfExpression tree;
}
