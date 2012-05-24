/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package set;

import list.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class SetTest {

    public SetTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        set = new Set<>();
        set.addElement(16);
        set.addElement(15);
        set.addElement(138);
        set.addElement(32);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addElement and toList methods, of class Set.
     */
    @Test
    public void testAddElementAndToList() {
        set.addElement(111);
        String res = "";
        for (Integer i : set.toUniqueList()) {
            res += i + " ";
        }
        assertEquals("16 15 138 32 111 ", res);
    }

    /**
     * Test of deleteElement method, of class Set, delete non-existing value.
     */
    @Test
    public void testDeleteNothing() {
        set.deleteElement(14);
        String res = "";
        for (Integer i : set.toUniqueList()) {
            res += i + " ";
        }
        assertEquals("16 15 138 32 ", res);
    }

    @Test
    public void testDeleteElement() {
        set.deleteElement(16);
        set.deleteElement(32);
        set.deleteElement(138);
        boolean temp = set.ifBelongs(138);
        String res = "";
        for (Integer i : set.toUniqueList()) {
            res += i + " ";
        }
        
        assertEquals("15 ", res);
    }

    /**
     * Test of ifBelongs method, of class Set.
     */
    @Test
    public void testIfBelongs() {
        assertTrue(set.ifBelongs(15));
    }

    @Test
    public void testIfDoesNotBelong() {
        assertFalse(set.ifBelongs(11));
    }

    /**
     * Test of intersect method, of class Set.
     */
    @Test
    public void testIntersect() {
        Set<Integer> otherSet = new Set<>();
        otherSet.addElement(1349);
        otherSet.addElement(138);
        otherSet.addElement(1349);
        otherSet.addElement(16);
        
        String res = "";
        Set<Integer> resultSet =  set.intersect(otherSet);
        for (Integer i : resultSet.toUniqueList()) {
            res += i + " ";
        }
        assertEquals("16 138 ", res);
    }

    /**
     * Test of union method, of class Set.
     */
    @Test
    public void testUnion() {
        Set<Integer> otherSet = new Set<>();
        otherSet.addElement(1349);
        otherSet.addElement(138);
        otherSet.addElement(1349);
        otherSet.addElement(12);
        
        Set<Integer> result = set.union(otherSet);
        String res = "";
        for (Integer i : result.toUniqueList()) {
            System.out.format("%d ", i);
        }
        
        System.out.println(res);
    }
    private Set<Integer> set;
}
