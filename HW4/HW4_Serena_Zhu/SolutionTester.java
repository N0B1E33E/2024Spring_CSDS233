import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTester {
    
    Solution s = new Solution();

    @Test
    public void testKClosest() {
        // tests an odd number input, returning 1 closest point
        int[][] a1 = new int[][] {{0, 0}, {1, 1}, {200, 200}, {200, 233}, {300, 300}};
        int[][] expect1 = new int[][] {{200, 233}};
        assertArrayEquals(expect1, s.kClosest(a1, 1));
        
        // tests an odd number input, returning 2 closest points
        int[][] a2 = new int[][] {{0, 0}, {1, 1}, {200, 200}, {200, 233}, {300, 300}};
        int[][] expect2 = new int[][] {{200, 233}, {200, 200}};
        assertArrayEquals(expect2, s.kClosest(a2, 2));

        // tests an odd number input, returning all points
        int[][] a3 = new int[][] {{0, 0}, {1, 1}, {200, 200}, {200, 233}, {300, 300}};
        int[][] expect3 = new int[][] {{200, 233}, {200, 200}, {300, 300}, {1, 1}, {0, 0}};
        assertArrayEquals(expect3, s.kClosest(a3, 5));
        
        // tests an even number input with two points having the same distance to target point, returning 2 closest points
        int[][] a4 = new int[][] {{0, 0}, {1, 1}, {200, 200}, {200, 233}, {233, 200}, {300, 300}};
        int[][] expect4 = new int[][] {{200, 233}, {233, 200}};
        assertArrayEquals(expect4, s.kClosest(a4, 2));

        // tests an even number input with two points having the same distance to target point, returning 3 closest points
        int[][] a5 = new int[][] {{0, 0}, {1, 1}, {200, 200}, {200, 233}, {233, 200}, {300, 300}};
        int[][] expect5 = new int[][] {{200, 233}, {233, 200}, {200, 200}};
        assertArrayEquals(expect5, s.kClosest(a5, 3));
    }

}
