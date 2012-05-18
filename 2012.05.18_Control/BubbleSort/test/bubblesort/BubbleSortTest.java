/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class BubbleSortTest {
    
    public BubbleSortTest() {
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
     * Test of bubbleSort method, of class BubbleSort.
     */
    @Test
    public void testBubbleSort() {
        int capacity = 5;
        ArrayList<Integer> collection = new ArrayList<>(capacity);
        IntComparator comp = new IntComparator();
        BubbleSort instance = new BubbleSort();
        for (int i = 0; i < capacity; ++i) {
            collection.add(0, i);
        }
        
        String expResult = "0 1 2 3 4 ";
        
        instance.bubbleSort(collection, comp);
        String result = instance.printInt(collection);
        assertEquals(expResult, result);
    }
}
