public class Recursion {

    public int sumDigits(int n) {
        if(n < 10) {
            return n;
        }
        else {
            return (n % 10) + sumDigits(n / 10);
        }
    }

    public int gcd(int a, int b) {
        if(a > b && b != 0) {
            return gcd(b, a % b);
        }
        else if(b > a && a != 0) {
            return gcd(a, b % a);
        }
        else {
            return a;
        }
    }

    public boolean isPalindrome(String str) {
        if(str.length() == 1 || str.length() == 0) {
            return true;
        }
        else if(str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        else {
            return false;
        }
    }

    public Node swapNodesInPairs(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }
        else {
            Node save = head.getNext();
            head.setNext(swapNodesInPairs(head.getNext().getNext()));
            save.setNext(head);
            head = save;
            return head;
        }
    }

    public int binomial(int n, int k) {
        if(n < 0 || k < 0) {
            throw new IllegalArgumentException();
        }
        if(k == 1) {
            return n;
        }
        else {
            return n * binomial(n - 1, k - 1) / k;
        }
    }

}
