/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class ArrayStackTest {

    public ArrayStackTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this.instance = new ArrayStack();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class ArrayStack, on empty stack.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(this.instance.isEmpty());
    }

    /**
     * Test of isEmpty method in case of non-empty stack.
     */
    @Test
    public void testIsNotEmpty() {
        this.instance.push(15);
        assertTrue(!this.instance.isEmpty());
    }

    /**
     * Test of push, pop and top methods, of class ArrayStack.
     */
    @Test
    public void testPush() throws EmptyStackException {
        for (int i = 1; i < 15; ++i) {
            this.instance.push(i);
        }
        for (int i = 14; i > 0; --i) {
            int exprResult = this.instance.top();
            assertEquals(i, exprResult);
            this.instance.pop();
        }
    }

    /**
     * Test of pop method, of class ArrayStack, in the exceptional case. 
     */
    @Test(expected = EmptyStackException.class)
    public void testPop() throws EmptyStackException {
        this.instance.pop();
        }

    /**
     * Test of top method, of class ArrayStack, in the exceptional case.
     */
    @Test(expected = EmptyStackException.class)
    public void testTop() throws EmptyStackException {
        this.instance.top();
        }
    private ArrayStack instance;
}
