import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RecursionTester {
    private Recursion recursion;

    @Before
    public void setUp() {
        recursion = new Recursion();
    }

    @Test
    public void testSumDigits() {
        assertEquals("Sum of digits in 123 should be 3", 3, recursion.sumDigits(123));
        assertEquals("Sum of digits in 0 should be 0", 0, recursion.sumDigits(0));
        assertEquals("Sum of digits in a large number", 10, recursion.sumDigits(1000000000));
    }

    @Test
    public void testGCD() {
        assertEquals("GCD of 48 and 18 should be 6", 6, recursion.gcd(48, 18));
        assertEquals("GCD of a number and 0 should be the number itself", 101, recursion.gcd(101, 0));
        assertEquals("GCD of two prime numbers should be 1", 1, recursion.gcd(17, 13));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue("Should return true for a palindrome word", recursion.isPalindrome("racecar"));
        assertFalse("Should return false for a non-palindrome word", recursion.isPalindrome("hello"));
        assertTrue("Should return true for an empty string", recursion.isPalindrome(""));
        assertTrue("Should return true for a single character", recursion.isPalindrome("a"));
    }

    @Test
    public void testSwapNodesInPairs() {
        
        Node list = createLinkedList(new int[]{1, 2, 3, 4});
        Node expected = createLinkedList(new int[]{2, 1, 4, 3});
        assertTrue("Swapped list should match expected", compareLinkedLists(expected, recursion.swapNodesInPairs(list)));

        Node singleNodeList = createLinkedList(new int[]{1});
        assertTrue("Single node list should remain unchanged", compareLinkedLists(singleNodeList, recursion.swapNodesInPairs(singleNodeList)));
    }

    @Test
    public void testBinomial() {
        assertEquals("Binomial coefficient (5, 2) should be 10", 10, Recursion.binomial(5, 2));
        assertEquals("Binomial coefficient (10, 0) should be 1", 1, Recursion.binomial(10, 0));
        assertEquals("Binomial coefficient (10, 10) should be 1", 1, Recursion.binomial(10, 10));
        assertEquals("Binomial coefficient with large values", 252, Recursion.binomial(10, 5));
    }

    // Utility methods for the linked list tests
    private Node createLinkedList(int[] values) {
        Node head = null;
        Node tail = null;
        for (int value : values) {
            Node newNode = new Node(value, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        }
        return head;
    }

    private boolean compareLinkedLists(Node head1, Node head2) {
        Node current1 = head1;
        Node current2 = head2;
        while (current1 != null && current2 != null) {
            if (current1.getValue() != current2.getValue()) {
                return false;
            }
            current1 = current1.getNext();
            current2 = current2.getNext();
        }
        return current1 == null && current2 == null;
    }
}
