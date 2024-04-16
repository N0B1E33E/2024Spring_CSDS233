import org.junit.Test;
import static org.junit.Assert.*;

public class RandomQuickSortTester {
    
    @Test
    public void testQuickSort() {
        // tests an unordered array
        Integer[] a1 = new Integer[] {3, 5, 3, 2, 1};
        Integer[] expected1 = new Integer[] {1, 2, 3, 3, 5};
        RandomQuickSort.quickSort(a1, 0, a1.length - 1);
        assertArrayEquals(expected1, a1);

        // tests a longer unordered array
        Integer[] a3 = new Integer[] {9, 8, 8, 5, 7, 7, 4, 4, 4, 2};
        Integer[] expected3 = new Integer[] {2, 4, 4, 4, 5, 7, 7, 8, 8, 9};
        RandomQuickSort.quickSort(a3, 0, a3.length - 1);
        assertArrayEquals(expected3, a3);

        // tests a sorted array
        Integer[] a2 = new Integer[] {1, 2, 3, 3, 5};
        RandomQuickSort.quickSort(a2, 0, a2.length - 1);
        assertArrayEquals(expected1, a2);
    }

}
