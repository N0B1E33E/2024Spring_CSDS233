import org.junit.Test;
import static org.junit.Assert.*;

public class RandomQuickSortTester {
    
    @Test
    public void testQuickSort() {
        Integer[] intArr = new Integer[] {3, 5, 3, 2, 1};
        Integer[] expIntArr = new Integer[] {1, 2, 3, 3, 5};
        RandomQuickSort.quickSort(intArr, 0, intArr.length - 1);
        assertTrue(intArr.equals(expIntArr));
    }

}
