/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquelist;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class UniqueListTest {

    public UniqueListTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        inst = new UniqueList<Integer>();
        int random = 15;
        try {
            for (int i = 0; i < random; ++i) {
                inst.addToList(i);
            }
        } catch(AlreadyExists e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addToList method --- try to add existing element.
     */
    @Test(expected = AlreadyExists.class)
    public void testAddAlreadyExisting() throws AlreadyExists {
        inst.addToList(10);
    }
    private UniqueList<Integer> inst;
}
