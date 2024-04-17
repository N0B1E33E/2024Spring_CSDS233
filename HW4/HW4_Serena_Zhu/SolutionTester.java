import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTester {
    
    Solution s = new Solution();

    @Test
    public void testKClosest() {
        int[][] a1 = new int[][] {{0, 0}, {1, 1}, {200, 200}, {200, 233}, {300, 300}};
        int[][] expect1 = new int[][] {{200, 233}};
        assertArrayEquals(expect1, s.kClosest(a1, 1));
        
        int[][] a2 = new int[][] {{0, 0}, {1, 1}, {200, 200}, {200, 233}, {300, 300}};
        int[][] expect2 = new int[][] {{200, 233}, {200, 200}};
        assertArrayEquals(expect2, s.kClosest(a2, 2));
    }

}
