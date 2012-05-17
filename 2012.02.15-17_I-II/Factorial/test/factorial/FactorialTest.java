/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class FactorialTest {
    
    public FactorialTest() {
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
     * Test of factorial method, of class Factorial.
     */
    @Test
    public void testFactorial() {
        int n = 7;
        int expResult = 5040;
        int result = Factorial.factorial(n);
        assertEquals(expResult, result);
    }
    
    @Test(expected = FactorialInvalidArgument.class)
    public void testFactorialOfIncorrectArg() {
        int n = -1;
        Factorial.factorial(n);
    }
     
}
