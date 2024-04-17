import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTester {
    
    Binary b = new Binary();

    @Test
    public void testFindMin() {
        // tests array with single element
        int[] a = new int[] {0};
        assertEquals(0, b.findMin(a));

        // tests array with multiple elements, with minimum value in different positions
        int[] a1 = new int[] {0, 1, 2, 3};
        assertEquals(0, b.findMin(a1));
        int[] a2 = new int[] {3, 0, 1, 2};
        assertEquals(0, b.findMin(a2));
        int[] a3 = new int[] {2, 3, 0, 1};
        assertEquals(0, b.findMin(a3));
        int[] a4 = new int[] {1, 2, 3, 0};
        assertEquals(0, b.findMin(a4));

        // tests longer array with different number of elements, with minimum value in different positions
        int[] a5 = new int[] {0, 1, 2, 3, 4, 5, 6};
        assertEquals(0, b.findMin(a5));
        int[] a6 = new int[] {4, 5, 6, 0, 1, 2, 3};
        assertEquals(0, b.findMin(a6));
        int[] a7 = new int[] {2, 3, 4, 5, 6, 0, 1};
        assertEquals(0, b.findMin(a7));
    }
    
}
