
public class Recursion {
	
	
	/**
	 * public method that uses recursion to calculate the sum of the digits of the given integer
	 * @param n non-negative integer 
	 * @return the sum of all digits of the input integer
	 */
	public int sumDigit(int n){
		//base case
		if(n / 10 == 0)
			return n;
		else
			return (n%10) + sumDigit(n/10);
	}
	
	/**
	 * public method that takes two integer input and calculate the gcd using Euclidean Algorithm
	 * @param a positive integer
	 * @param b positive integer
	 * @return gcd of a and b
	 */
	public int gcd(int a, int b){
		//base case
		if(a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}
	
	/**
	 * public method that uses recursion to check if the input string is a palindrome
	 * @param str input non-empty string
	 * @return true if the input string is a palindrome, false otherwise
	 */
	public boolean isPalindrome(String str){
		//base case
		if(str.length() == 0 || str.length() == 1){
			return true;
		}
		else if(str.charAt(0) == str.charAt(str.length() - 1)){
			return isPalindrome(str.substring(1, str.length() - 1));
		}
		else{
			return false;
		}
	}
	
	/**
	 * public method that takes one Node input, return the head of a new LinkedList that is the original linked with nodes swapped for every two nodes.
	 * @param head head of the input linked list
	 * @return head of a new linked list after swapping
	 * 
	 */
	public Node swapNodesInPairs(Node head){
		if(head == null || head.getNext() == null)
			return head;
		else{
			Node temp = head.getNext().getNext();
			head.getNext().setNext(head);
			head.setNext(temp);
			return swapNodesInPairs(head.getNext());
		}
		
	}

	
	/**
	 * public method that uses recursion C(n,k) = n/k * C(n-1,k-1) to calculate the number of 
	 * combinations for choosing k items within n items
	 * @param n positive integer
	 * @param k positive integer
	 * @return the number of possible combinations in total
	 */
	public int binomial(int n, int k){
		if(n < 0 || k < 0){
			throw new IllegalArgumentException();
		}
		//base case
		if(k== 0 || k == n)
			return 1;
		else
			return binomial(n-1, k-1) * n / k;
		
	}

}
