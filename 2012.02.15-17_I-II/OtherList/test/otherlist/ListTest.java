/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otherlist;

import java.util.NoSuchElementException;
import static org.junit.Assert.*;
import org.junit.*;
import otherlist.List.ListIterator;


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
        instance = new List<>();
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
        List<Integer> inst = new List<>();
        inst.addToHead(15);

        assertEquals(inst.isEmpty(), false);

        inst.addToHead(138);
        assertEquals(138, (int) inst.getValue(inst.hd()));
        inst.addToHead(359);

        assertEquals(359, (int) inst.getValue(inst.hd()));

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

    /**
     * Test of 'iterator' method, of class List.
     */
    @Test
    public void testIterator() throws EmptyListException {
        
        for (int i = 1; i < 10; i++) {
            instance.addToEnd("" + i);
        }
        ListIterator it = instance.iterator();

        System.out.println("first way to print.");
        for (String i : instance) {
            System.out.format("%s ", i);
        }

        System.out.println("\nsecond way to print.");
        while (it.hasNext()) {
            System.out.format("%s ", it.next());
        }

        System.out.println("\nthird way to print.");
        System.out.println(instance.length());
        Object temp = instance.hd();
        int i = 0;
        while (i < 30) {
            try {
                System.out.format("%s ", instance.getValue(temp));
                temp = instance.getNextPosition(temp);
                i++;
            } catch (NullPointerException e) {
                break;
            }
        }
        
        fail("lololol, как добраться до последнего элемента?");
    }
    
    /**
     * test if method 'iterator' throws exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElement () {
        instance.iterator();
    } 
    private List<String> instance;
}
