/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class PriorityQueueTest {

    public PriorityQueueTest() {
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
     * Test of enqueue method, of class PriorityQueue.
     */
    @Test
    public void testEnqueue() {
        PriorityQueue priorQueue = new PriorityQueue<Integer>();
        int[] bufferOfTestValues = {103, 1251, 294, -5};
        for (int i = 0; i < bufferOfTestValues.length; ++i) {
            priorQueue.enqueue(bufferOfTestValues[i], i);
        }

        fail("The test case is a prototype.");
    }

    /**
     * Test of throwing exception from dequeue method, of class PriorityQueue.
     */
    @Test(expected = EmptyQueueException.class)
    public void testDequeueOfEmptyList() throws EmptyQueueException {

        PriorityQueue priorQueue = new PriorityQueue<Integer>();
        priorQueue.dequeue();
        fail("This method is prototype");
    }

    /**
     * Test of dequeue method, of class PriorityQueue.
     */
    @Test
    public void testDequeue() {
        PriorityQueue priorQueue = new PriorityQueue<Integer>();
        priorQueue.enqueue(15, 1);
        priorQueue.enqueue(14, 2);
        priorQueue.enqueue(116, 3);
        Integer expected = Integer (priorQueue.dequeue());
        
        assertEquals(116, expected);
        
    }
}
