/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import list.List.ListElement;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
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
        System.out.println("isEmpty");
        List instance = new List();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of length method, of class List.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        List instance = new List();
        int expResult = 0;
        int result = instance.length();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hd method, of class List.
     */
    @Test
    public void testHd() throws Exception {
        System.out.println("hd");
        List instance = new List();
        ListElement expResult = null;
        ListElement result = instance.hd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AddToHead method, of class List.
     */
    @Test
    public void testAddToHead() throws EmptyListException {
        List instance = new List<Integer>();
        instance.AddToHead(15);
        
        assertEquals(instance.isEmpty(), false);
        
        instance.AddToHead(138);
        assertEquals(138,  instance.hd().getValue());
        instance.AddToHead(359);
        
        assertEquals(359, instance.hd().getValue());
        
    }

    /**
     * Test of addToEnd method, of class List.
     */
    @Test
    public void testAddToEnd() {
        System.out.println("addToEnd");
        Object value = null;
        List instance = new List();
        instance.addToEnd(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class List.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        ListElement pos = null;
        Object value = null;
        List instance = new List();
        instance.insert(pos, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class List.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        ListElement pos = null;
        List instance = new List();
        instance.delete(pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
