import java.util.Arrays;

public class Binary {

    // method to find the minimum value of a sorted and rotated array of unique elements
    public int findMin(int[] nums) {

        // stores the sorted rotated array
        int[] temp = this.binarySearch(nums, 0, nums.length - 1);
        // returns minimum value
        return temp[0];

    }

    // recursive method to find smallest element using binary search
    private int[] binarySearch(int[] a, int first, int last) {

        // stores minimum element
        int[] temp = new int[1];

        // finds approximate mid point of input array
        int mid = first + (last - first) / 2;

        // stores mid value of array
        int midValue = a[mid];
        // stores left most value of array
        int leftValue = a[first];
        // stores right most value of array
        int rightValue = a[last];
        
        // if leftValue = midValue and midValue = rightValue, there is only one element, copy only element
        // if leftValue = midValue and midValue < rightValue, there are two elements and midValue < rightValue, copy midValue element
        if((leftValue == midValue && midValue == rightValue) || (leftValue == midValue && midValue < rightValue)) {
            temp = Arrays.copyOf(a, 1);
        }
        // if leftValue < midValue and midValue < rightValue, minimum value is in the left group
        else if(leftValue < midValue && midValue < rightValue) {
            // calls recursion on left group
            binarySearch(a, first, mid - 1);
        }
        // if leftValue < midValue and midValue > rightValue, minimum value is in the right group
        else if(leftValue < midValue && midValue > rightValue) {
            // calls recursion on right group
            binarySearch(a, mid + 1, last);
        }
        // otherwise, minimum value is in the middle group
        else {
            // calls recursion on middle group
            binarySearch(a, first + 1, last - 1);
        }

        // return array storing minimum value
        return temp;

    }

}
