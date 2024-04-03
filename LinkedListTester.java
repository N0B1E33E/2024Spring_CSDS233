import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTester {
    private LinkedList list;

    @Before
    public void setUp() {
        list = new LinkedList();
    }

    @Test
    public void testAddToEnd() {
        list.add(1);
        assertEquals("Element should be added to the list", 0, list.indexOf(1));
    }

    @Test
    public void testAddAtIndex() {
        list.add(1);
        list.add(2, 0); // Add at the start
        assertEquals("Element 2 should be added at index 0", 0, list.indexOf(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAtNegativeIndex() {
        list.add(1, -1);
    }

    @Test
    public void testRemoveByIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("Element 2 should be removed", 2, list.remove(1));
        assertEquals("New index of element 3 should be 1", 1, list.indexOf(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtInvalidIndex() {
        list.remove(0); // Attempt to remove from an empty list
    }

    @Test
    public void testRemoveValue() {
        list.add(1);
        list.add(2);
        list.removeValue(1);
        assertEquals("Element 1 should be removed", -1, list.indexOf(1));
    }

    @Test
    public void testRemoveAllOccurrences() {
        list.add(1);
        list.add(1);
        list.add(2);
        list.removeAll(1);
        assertEquals("All occurrences of 1 should be removed", -1, list.indexOf(1));
    }

    @Test
    public void testMean() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("Mean should be calculated correctly", 2.0, list.mean(), 0.001);
    }

    @Test
    public void testVariance() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("Variance should be calculated correctly", 1.0, list.variance(), 0.001);
    }

    @Test
    public void testSublist() {
        list.add(1);
        list.add(2);
        list.add(3);
        LinkedList sublist = list.sublist(1, 2);
        assertEquals("Sublist should include elements 1 and 2", 0, sublist.indexOf(1));
        assertEquals("Sublist should include elements 1 and 2", 1, sublist.indexOf(2));
        assertEquals("Sublist should not include element 3", -1, sublist.indexOf(3));
    }

    @Test
    public void testRemoveNoise() {
        for (int i = 0; i < 100; i++){
            list.add(1);
        }
        list.add(100);
        LinkedList filteredList = list.removeNoise();
        assertEquals("Element 100 should be considered noise and removed", -1, filteredList.indexOf(100));
    }

    @Test
    public void testLargeDataset() {
        // Assuming adding a large number of elements to test performance and correctness
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        assertEquals("The last element should be 9999", 9999, list.indexOf(9999));
    }

    @Test
    public void testEdgeCases() {
        // Edge cases can include adding/removing from an empty list, large values for integers, etc.
        list.add(Integer.MAX_VALUE);
        list.add(Integer.MIN_VALUE);
        assertEquals("Should handle Integer.MAX_VALUE", 0, list.indexOf(Integer.MAX_VALUE));
        assertEquals("Should handle Integer.MIN_VALUE", 1, list.indexOf(Integer.MIN_VALUE));
    }
}
