/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixsort;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class MatrixSortTest {
    
    public MatrixSortTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        m = new int[][] {{6, 5, 4, 3}, {1, 2, 3, 4}, {2, 1, 0, 1}};
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of less method, of class MatrixSort.
     */ 
    @Test
    public void testLess() {
        int firstInd = 1;
        int secInd = 0;
        assertTrue(MatrixSort.less(m, firstInd, secInd) );
     
    }

    /**
     * Test of swap method, of class MatrixSort.
     */
    @Test
    public void testSwap() {
        int firstInd = 0;
        int secInd = 1;
        MatrixSort.swap(m, firstInd, secInd);
        String res1 = "" + m[0][0] + m[1][0] + m[2][0];
        String res2 = "" + m[0][1] + m[1][1] + m[2][1];
        
        assertEquals("521\n612" , res1 + '\n' + res2);
    }

    /**
     * Test of sort method, of class MatrixSort.
     */
    @Test
    public void testSort() {
        MatrixSort.sort(m);
        assertEquals("3 4 5 6 \n4 3 2 1 \n1 0 1 2 \n", MatrixSort.print(m));
    }
    int[][] m;
}
