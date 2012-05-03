/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquelist;

import list.List.ListElement;
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

    /**
     * Test of find method, of class UniqueList.
     */
    @Test
    public void testFind() throws DoesNotExist, AlreadyExists {
        
        UniqueList<String> instance = new UniqueList<String>();
        
        instance.addToList("first");
        instance.addToList("second");
        instance.addToList("third");
        
        assertEquals("first", instance.find("first").getValue());
        assertEquals("second", instance.find("second").getValue());
        assertEquals("third", instance.find("third").getValue());
    }
    
    /**
     * Test of find method, when we try to find what the list does not have.
     */
    @Test(expected = DoesNotExist.class) 
    public void testFindNonExistingValue() throws DoesNotExist {
        UniqueList<String> instance = new UniqueList<String>();
        instance.find("fourth");
    }
}
