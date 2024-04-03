public class Recursion {

    public int sumDigits(int n){
        //break point then n reachs 0(counted to the last digit)
        if (n == 0){
            return 0;
        } else {
            //plus 1 to the digit recursively when n is divided by each 10
            return 1 + sumDigits(n / 10);
        }
    }

    public int gcd(int a, int b){
        // By the Euclidean Algorithm, the recursion terminates when the dominator is 0
        if (b == 0){
            return a;
        // divide b by the the remainder of a/b, which can represented by a%b
        } else {
            return gcd (b, a % b);
        }
    }

    public boolean isPalindrome(String str){
        // When the string has 0 or 1 character, return true for it is either the base case, or reaches the middle
        if (str.length() <= 1){
            return true;
        }
        // Check the first and last, if they are equal, clear them out and recursively check the next first and last
        if (str.charAt(0) == str.charAt(str.length()-1)){
            return isPalindrome(str.substring(1, str.length()-1));
        } else { 
            //if they are not, return false
            return false;
        }
    }

    public Node swapNodesInPairs(Node head) {
        // Base case: if the list is empty or has only one element, no swap is needed.
        if (head == null || head.getNext() == null) {
            return head;
        }
        // Recursively swap the next pair.
        Node nextPair = swapNodesInPairs(head.getNext().getNext());
        // Perform the swap.
        Node second = head.getNext();
        head.setNext(nextPair);
        second.setNext(head);
        // Return the new head of this segment.
        return second;
    }

    public static int binomial(int n, int k) {
        // Base cases
        if (k == 0 || k == n) {
            return 1;
        }
        // Recursive case: Pascal's Triangle
        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }
    
}
