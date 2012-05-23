/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import stack.*;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class CalculatorTest {

    public CalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        Stack opStack = new ArrayStack();
        calc = new Calculator(opStack);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of push and result methods, of class Calculator.
     */
    @Test
    public void testPush() {
        int value = 15;
        calc.push(value);
        assertEquals(value, calc.result());
    }

    /**
     * Test of result method, of class Calculator, in case of bad input.
     */
    @Test(expected = InvalidCountOfArgumentsException.class)
    public void testResult() {
        calc.result();
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAdd() {
        calc.push(14);
        calc.push(88);
        calc.add();
        assertEquals(228, calc.result());
    }

    /**
     * Test of subtract method, of class Calculator.
     */
    @Test
    public void testSubtract() {
        calc.push(14);
        calc.push(88);
        calc.subtract();
        calc.push(-80);
        calc.subtract();
        assertEquals(6, calc.result());
    }

    /**
     * Test of mul method, of class Calculator.
     */
    @Test
    public void testMul() {
        calc.push(999);
        calc.push(999);
        calc.mul();
        calc.push(8001);
        calc.subtract();
        assertEquals(990000, calc.result());
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test
    public void testDivide() {
        calc.push(14);
        calc.push(11);
        calc.divide();
        assertEquals(1, calc.result());
    }
    private Calculator calc;
    
    /**
     * Test, if 'divide' method throws exception.
     */
    @Test(expected = InvalidCountOfArgumentsException.class)
    public void testAddFail() {
        calc.push(15);
        calc.add();
    }
}
