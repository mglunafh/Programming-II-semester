/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Dev
 */
public class StackTest {

    public StackTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method in case of non-empty stack.
     */
    @Test
    public void testInNotEmpty() {
        boolean exprResult = false;
        instance.push(15);
        assertEquals(exprResult, instance.isEmpty());
    }

    /**
     * Test of push, top and pop methods, of class Stack.
     */
    @Test
    public void testPushAndPop() {
        int[] buffer = new int[15];
        for (int i = 14; i >= 0; --i) {
            buffer[i] = (i * 14 + i / 2 * 5) % 9;
            instance.push(buffer[i]);
        }

        for (int i = 0; i < buffer.length; ++i) {
            try {
                System.out.println(instance.top());
                assertEquals(instance.top(), buffer[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                instance.pop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Test of pop method applied to empty stack.
     */
    @Test(expected = EmptyStackException.class)
    public void testPop() throws EmptyStackException {
        instance.pop();
    }

    /**
     * Test of top method applied to empty stack.
     */
    @Test(expected = EmptyStackException.class)
    public void testTop() throws EmptyStackException {
        int result = instance.top();
    }
    Stack instance = new Stack();
}
