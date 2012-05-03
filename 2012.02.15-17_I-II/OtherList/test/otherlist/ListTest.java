/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otherlist;

import org.junit.*;
import static org.junit.Assert.*;
import otherlist.List.ListElement;

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
        instance = new List<String>();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class List.
     */
    @Test
    public void testIsEmpty() {
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method when list is not empty.
     */
    @Test
    public void testIsNotEmpty() {
        boolean expResult = false;
        instance.addToEnd("ololo");
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of hd method --- throwing an exception.
     */
    @Test(expected = EmptyListException.class)
    public void testHd() throws EmptyListException {
        ListElement result = instance.hd();
    }

    /**
     * Test of hd method, of class List, and getValue method, of class
     * ListElement.
     */
    @Test
    public void testHdAndGetValue() {
        String expResult = "ololo";
        instance.addToEnd("ololo");
        try {
            String result = instance.hd().getValue();
            assertEquals(expResult, result);
        } catch (EmptyListException e) {
            e.printStackTrace();
        }
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
        assertEquals(138, instance.hd().getValue());
        instance.AddToHead(359);

        assertEquals(359, instance.hd().getValue());

    }

    /**
     * Test of insert method, of class List.
     */
    @Test
    public void testInsert() {
        instance.addToEnd("first");
        instance.addToEnd("second");
        try {
            ListElement pos = instance.hd();
            instance.insert(pos, "third");
            String expResult = "third";
            assertEquals(expResult, pos.getNext().getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of length method on empty list.
     */
    @Test
    public void testLength() {
        assertEquals(0, instance.length());
    }

    /**
     * Checking, if count of list increments.
     */
    @Test
    public void testLengthAfterInsert() {
        instance.addToEnd("first");
        try {
            ListElement pos = instance.hd();
            instance.insert(pos, "second");
            instance.insert(pos, "third");
            assertEquals(3, instance.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of addToEnd method, of class List.
     */
    @Test
    public void testAddToEnd() {
        instance.addToEnd("Voarmeprebre");
        instance.addToEnd("Uatr");
        instance.addToEnd("Vermyapre");
        try {
            ListElement pos = instance.hd();
            assertEquals("Vermyapre", pos.getNext().getNext().getValue());
        } catch (Exception r) {
            r.printStackTrace();
        }
    }

    /**
     * Test of delete method.
     */
    @Test
    public void testDelete() throws  EmptyListException {
        instance.addToEnd("first");
        instance.addToEnd("second");
        instance.addToEnd("third");

        assertEquals(false, instance.isEmpty());
        
        ListElement pos = instance.hd();
        instance.delete(pos);
        
        assertEquals("second", instance.hd().getValue());
        assertEquals("third", instance.hd().getNext().getValue());

    }
    private List<String> instance;
}
