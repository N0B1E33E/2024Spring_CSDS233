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
        // simple case
        Node n5 = new Node(5, null);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        r.swapNodesInPairs(n1);
        assertEquals(n1, n2.getNext());
        assertEquals(n4, n1.getNext());
        assertEquals(n3, n4.getNext());
        assertEquals(n5, n3.getNext());

        // complicated case
        Node n20 = new Node(20, null);
        Node n19 = new Node(19, n20);
        Node n18 = new Node(18, n19);
        Node n17 = new Node(17, n18);
        Node n16 = new Node(16, n17);
        Node n15 = new Node(15, n16);
        Node n14 = new Node(14, n15);
        Node n13 = new Node(13, n14);
        Node n12 = new Node(12, n13);
        Node n11 = new Node(11, n12);
        Node n10 = new Node(10, n11);
        Node n09 = new Node(9, n10);
        Node n08 = new Node(8, n09);
        Node n07 = new Node(7, n08);
        Node n06 = new Node(6, n07);
        Node n05 = new Node(5, n06);
        Node n04 = new Node(4, n05);
        Node n03 = new Node(3, n04);
        Node n02 = new Node(2, n03);
        Node n01 = new Node(1, n02);
        r.swapNodesInPairs(n01);
        assertEquals(n01, n02.getNext());
        assertEquals(n04, n01.getNext());
        assertEquals(n03, n04.getNext());
        assertEquals(n06, n03.getNext());
        assertEquals(n17, n18.getNext());
        assertEquals(n20, n17.getNext());
        assertEquals(n19, n20.getNext());
        assertEquals(null, n19.getNext());

        // edge case
        Node n = new Node(1, null);
        r.swapNodesInPairs(n);
        assertEquals(null, n.getNext());
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
