import org.junit.Test;
import static org.junit.Assert.*;

public class RecursionTester {
    
    Recursion r = new Recursion();

    @Test
    public void testSumDigits() {
        // simple case
        assertEquals(6, r.sumDigits(123));
        // complicated case
        assertEquals(45, r.sumDigits(987654321));
        // edge case
        assertEquals(0, r.sumDigits(0));
    }

    @Test 
    public void testGCD() {
        // simple case
        assertEquals(2, r.gcd(2, 6));
        assertEquals(3, r.gcd(6, 3));
        // complicated case
        assertEquals(74, r.gcd(12358, 4662));
        // edge case
        assertEquals(5, r.gcd(5, 5));
    }

    @Test
    public void testIsPalindrome() {
        // simple case
        assertTrue(r.isPalindrome("aba"));
        assertFalse(r.isPalindrome("abb"));
        // complicated case
        assertTrue(r.isPalindrome("neveroddoreven"));
        assertFalse(r.isPalindrome("neveroddxoreven"));
        // edge case
        assertTrue(r.isPalindrome("a"));
    }

    @Test 
    public void testSwapNodesInPairs() {
      
    }

    @Test 
    public void testBinomial() {
        // simple case
        assertEquals(35, r.binomial(7, 3));
        // complicated case
        assertEquals(573800, r.binomial(152, 3));
        // edge case
        assertEquals(4, r.binomial(4, 1));
        assertEquals(1, r.binomial(4, 4));
    }

}
