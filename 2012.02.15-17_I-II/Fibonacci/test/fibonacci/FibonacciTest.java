/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class FibonacciTest {

    public FibonacciTest() {
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
     * Test of fib method, of class Fibonacci.
     */
    @Test
    public void testFib() {
        int n = 10;
        int expResult = 55;
        int result = Fibonacci.fib(n);
        assertEquals(expResult, result);
    }
    
    @Test(expected = FibonacciInvalidArgument.class) 
    public void testFibonacciInvalidArg () {
        Fibonacci.fib(-1);
    }
}
