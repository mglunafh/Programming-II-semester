/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Fedor Uvarychev
 */
public class HashTableTest {
    
    public HashTableTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        SimpleHashFunction hashFun = new SimpleHashFunction(15);
        instance = new HashTable<>(15, hashFun);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class HashTable.
     */
    @Test
    public void testAdd() {
        instance.add("First.");
    }

    /**
     * Test of add and find methods, of class HashTable.
     */
    @Test
    public void testFind() {
        instance.add("First");
        boolean result = instance.find("First");
        assertTrue(result);
    }

    /**
     * Test of find method on non-existing value.
     */
    @Test
    public void testNotFound() {
        assertTrue(!instance.find("any string"));
    }
    /**
     * Test of delete method, of class HashTable.
     */
    @Test
    public void testDelete() {
        instance.add("First");
        instance.add("second");
        instance.add("thirD");
        
        instance.delete("second");
        assertEquals(2, instance.amountOf());
        }
    
    /**
     * Test of delete method applied to non-existing value.
     */
    @Test
    public void testDeleteNothing() {
        for (int i = 1; i < 15; i++) {
            instance.add("" + ((((i+1)*(i+1)*(i+1)) % 29)*i));
        }
        instance.delete("any string");
        assertEquals(14, instance.amountOf());
    }
    
    HashTable<String> instance;
}
