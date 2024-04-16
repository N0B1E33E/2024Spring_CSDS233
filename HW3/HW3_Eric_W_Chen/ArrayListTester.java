import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTester {
    private ArrayList list;

    @Before
    public void setUp() {
        list = new ArrayList();
    }

    @Test
    public void testAddSingleElement() {
        list.add(10);
        assertEquals("Check if the element is added", 0, list.indexOf(10));
    }

    @Test
    public void testAddMultipleElements() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals("Check the last element added", 99, list.indexOf(99));
    }

    @Test
    public void testAddElementAtSpecificIndex() {
        list.add(5); // Adds to index 0
        list.add(10, 0); // Adds to the beginning
        assertEquals("Element 10 should be at index 0", 0, list.indexOf(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAtNegativeIndexThrowsException() {
        list.add(10, -1);
    }

    @Test
    public void testEnsureCapacityIncreasesSize() {
        // Assuming default capacity is 8, add elements to force an increase
        for (int i = 0; i < 9; i++) {
            list.add(i);
        }
        // If addition was successful, capacity increased, no specific assertion for capacity here
        assertEquals("Check if the ninth element is added", 8, list.indexOf(8));
    }

    @Test
    public void testRemoveByIndex() {
        list.add(20);
        list.add(30);
        int removed = list.remove(0);
        assertEquals("Removed element should be 20", 20, removed);
        assertEquals("Element 30 should now be at index 0", 0, list.indexOf(30));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtIndexOutOfBoundsThrowsException() {
        list.remove(0); // No elements added yet
    }

    @Test
    public void testRemoveSpecificValue() {
        list.add(40);
        list.add(50);
        list.removeValue(40);
        assertEquals("Element 40 should be removed", -1, list.indexOf(40));
    }

    @Test
    public void testRemoveAllOccurrences() {
        list.add(60);
        list.add(60);
        list.add(70);
        list.removeAll(60);
        assertEquals("No occurrences of 60 should remain", -1, list.indexOf(60));
    }

    @Test
    public void testMeanOfElements() {
        list.add(1);
        list.add(2);
        list.add(3);
        double mean = list.mean();
        assertEquals("Mean should be 2", 2.0, mean, 0.0);
    }

    @Test
    public void testVariance() {
        list.add(4);
        list.add(5);
        list.add(6);
        double variance = list.variance();
        assertEquals("Variance calculation", 1.0, variance, 0.01);
    }

    @Test
    public void testSublistInRange() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        ArrayList sublist = list.sublist(2, 3);
        assertEquals("Sublist should start with 2", 0, sublist.indexOf(2));
        assertEquals("Sublist should end with 3", 1, sublist.indexOf(3));
    }

    @Test
    public void testRemoveNoiseWithLargeNumbers() {
        list.add(100);
        list.add(1000);
        list.add(100000000);
        ArrayList cleanedList = list.removeNoise();
        assertEquals("Expecting specific elements to be considered noise and removed", -1, cleanedList.indexOf(100000));
    }

    @Test
    public void testEdgeCaseWithLargeIndex() {
        // Add a large number of elements to test the array's capacity handling and edge conditions
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        assertEquals("Check the last element", 9999, list.indexOf(9999));
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testAddingBeyondMaxIntShouldThrowException() {
        for (int i = 0; i < (Integer.MAX_VALUE + 1L); i++) { // This loop is theoretical and will not actually execute
            list.add(i);
        }
    }
}
        


