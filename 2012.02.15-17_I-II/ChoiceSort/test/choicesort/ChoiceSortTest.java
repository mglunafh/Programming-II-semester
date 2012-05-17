/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package choicesort;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class ChoiceSortTest {
    
    public ChoiceSortTest() {
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
     * Test of sort method, of class ChoiceSort.
     */
    @Test
    public void testSort() {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 9};
        ChoiceSort.sort(array);
        String expResult = "1 1 2 3 4 5 6 9 9 ";
        String res = ChoiceSort.print(array);
        assertEquals(expResult, res);
    }

    /**
     * Test of print method, of class ChoiceSort.
     */
    @Test
    public void testPrint() {
        int[] array = {1, 5, 2, 16, 2 ,7};
        String expResult = "1 5 2 16 2 7 ";
        String result = ChoiceSort.print(array);
        assertEquals(expResult, result);
    }
}
