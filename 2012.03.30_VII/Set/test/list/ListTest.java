/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import list.List.ListIterator;
import org.junit.*;
import static org.junit.Assert.*;
import uniquelist.UniqueList;

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
        list = new UniqueList<>();
        for (int i = 3; i < 10; i++) {
            list.addToList(i);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class List.
     */
    @Test
    public void testFind() {
        System.out.println(list.length());

        for (Integer i : list) {
            System.out.format("%d ", i);
        }
        for (int i = -1; i < 12; i++) {
            System.out.format("%d %b\n", i, list.find(i));
        }
        list.addToList(11);
        list.addToList(138);
        System.out.println(null == list.find(11));
        System.out.println(null == list.find(138));
        
    }

    /**
     * Test of iterator method, of class List.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        List instance = new List();
        ListIterator expResult = null;
        ListIterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    private UniqueList<Integer> list;
}
