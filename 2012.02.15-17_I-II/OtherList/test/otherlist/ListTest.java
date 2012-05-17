/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otherlist;

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
        instance.hd();
    }

    /**
     * Test of addToHead method, of class List.
     */
    @Test
    public void testAddToHead() throws EmptyListException {
        List<Integer> instance = new List<>();
        instance.addToHead(15);

        assertEquals(instance.isEmpty(), false);

        instance.addToHead(138);
        assertEquals(138, (int) instance.getValue(instance.hd()));
        instance.addToHead(359);

        assertEquals(359, (int) instance.getValue(instance.hd()));

    }

    /**
     * Test of insert method, of class List.
     */
    @Test
    public void testInsert() throws EmptyListException {
        instance.addToEnd("first");
        instance.addToEnd("second");

        Object pos = instance.hd();
        instance.insert(pos, "third");
        String expResult = "third";
        assertEquals(expResult, instance.getValue(instance.getNextPosition(pos)));

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
    public void testLengthAfterInsert() throws EmptyListException {
        instance.addToEnd("first");

        Object pos = instance.hd();
        instance.insert(pos, "second");
        instance.insert(pos, "third");
        assertEquals(3, instance.length());

    }

    /**
     * Test of delete method.
     */
    @Test
    public void testDelete() throws EmptyListException {
        instance.addToEnd("first");
        instance.addToEnd("second");
        instance.addToEnd("third");

        assertEquals(false, instance.isEmpty());

        Object pos = instance.hd();
        instance.delete(pos);

        assertEquals("second", instance.getValue(instance.hd()));
        assertEquals("third", instance.getValue(instance.getNextPosition(instance.hd())));
    }
    private List<String> instance;
}
