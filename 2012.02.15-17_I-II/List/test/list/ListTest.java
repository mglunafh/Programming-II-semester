/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import list.List.Position;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Dev
 */
public class ListTest {
    
    public ListTest() {
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
     * Test of isEmpty method, of class List.
     */
    @Test
    public void testIsEmpty() {
        List instance = new List();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmpty method in case of non-empty list.
     */
    
    @Test
    public void testIsNotEmptyList() {
        List inst = new List();
        boolean expResult = false;
        inst.addToEnd(15);
        boolean result = inst.isEmpty(); 
        assertEquals(result, expResult);
    }

    /**
     * Test of hd method, of class List.
     */
    @Test
    public void testHd() {
        List inst = new List();
        Position result = inst.hd();
        Position prohibitedResult = null;
        assertTrue(result != prohibitedResult);
    }

    @Test
    public void testHead() {
/*        List inst = new List();
        int someLength = 15;
        int[] buffer = new int[someLength];
        for (int i = 0; i < buffer.length; ++i){
            buffer[i] = (666 * i + 1349) % 1488;
            System.out.println(buffer[i]);
        }
        for (int i = 0; i < someLength; ++i){
            inst.addToEnd(buffer[i]);
        }
        System.out.println();
  */      
                 
    }
    
    /**
     * Test of addToNextPosition method, of class List.
     */
    @Test
    public void testAddToNextPosition() {
        System.out.println("addToNextPosition");
        Position pos = null;
        int value = 0;
        List instance = new List();
        instance.addToNextPosition(pos, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToEnd method, of class List.
     */
    @Test
    public void testAddToEnd() {
        System.out.println("addToEnd");
        int value = 0;
        List instance = new List();
        instance.addToEnd(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFromNextPosition method, of class List.
     */
    @Test
    public void testDeleteFromNextPosition() {
        System.out.println("deleteFromNextPosition");
        Position pos = null;
        List instance = new List();
        instance.deleteFromNextPosition(pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
