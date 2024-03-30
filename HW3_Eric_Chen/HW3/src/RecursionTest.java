import static org.junit.Assert.*;
import org.junit.Test;

public class RecursionTest {

	Recursion a = new Recursion();
	
	@Test
	public void sumDigitsTest(){
		assertEquals(3, a.sumDigit(3));
		assertEquals(6, a.sumDigit(321));
		assertEquals(32, a.sumDigit(563403245));
	}
	
	@Test
	public void gcdTest(){
		assertEquals(1, a.gcd(7, 3));
		assertEquals(1, a.gcd(3, 7));
		assertEquals(12, a.gcd(24, 36));
		assertEquals(15, a.gcd(105,45));
	}

	@Test
	public void isPalindromeTest(){
		assertTrue(a.isPalindrome("aba"));
		assertTrue(a.isPalindrome("a"));
		assertFalse(a.isPalindrome("hello"));
		assertFalse(a.isPalindrome("abcdba"));
		assertTrue(a.isPalindrome("abbbbbbba"));
	}

	@Test
	public void swapNodesInPairsTest(){
		LinkedList list = new LinkedList();
		for(int i = 0; i < 5; i++){
			list.add(i + 1);
		}
		Node temp = a.swapNodesInPairs(list.getFirst());
		assertEquals(2, temp.getValue());
	}
	
	@Test
	public void binomialTest(){
		assertEquals(3003, a.binomial(15, 5));
		assertEquals(1, a.binomial(1, 1));
		assertEquals(15504, a.binomial(20, 5));
		assertEquals(120, a.binomial(10, 3));
	}
}
