public class Recursion {

    public int sumDigits(int n) {
        if(n == 1) {
            return n;
        }
        else {
            return n + sumDigits(n - 1);
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
        /*
        if(str.length() <= 3) {
            return str.charAt(0) == str.charAt(str.length() - 1);
        }
        else {
            if(str.charAt(0) == str.charAt(str.length() - 1)) {
                return isPalindrome(str.substring(1, str.length() - 2));
            }
            else {
                return false;
            }
        }
        */

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

    /*
    public Node swapNodesInPairs(Node head) {
        
    }
    */

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