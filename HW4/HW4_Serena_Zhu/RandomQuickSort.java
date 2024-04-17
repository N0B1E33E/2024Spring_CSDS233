import java.util.Random;

public class RandomQuickSort {
    
    // random number generator
    private static Random rng = new Random();

    // method to sort the input array using quick sort with random pivot
    public static <T extends Comparable <? super T>> void quickSort(T[] nums, int first, int last) {
        // base case: if there is only 1 or 2 elements
        if(last - first <= 1) {
            // if first element < second element, no change in position
            if(nums[first].compareTo(nums[last]) < 0) {
                ;
            }
            // otherwise, switch position of first and second elements
            else {
                T save = nums[first];
                nums[first] = nums[last];
                nums[last] = save;
            }
        }
        // when there are > 2 elements
        else {
            // calls helper method partition to find pivot and sort smaller and larger groups
            int pivotIndex = partition(nums, first, last);
            // if there are enough elements in smaller group to be sorted, quick sort smaller group
            if(pivotIndex - 1 > first) {
                // calls quickSort recursion on smaller group
                quickSort(nums, first, pivotIndex - 1);
            }
            // if there are enough elements in larger group to be sorted, quick sort larger group
            if(pivotIndex + 1 < last) {
                // calls quickSort recursion on larger group
                quickSort(nums, pivotIndex + 1, last);
            }
        }
    }

    // method to partition the array around the pivot, creating smaller and larger groups to the left and right of the pivot accordingly
    private static <T extends Comparable <? super T>> int partition(T[] nums, int first, int last) {
        // chooses random pivot
        int pivotIndex = first + rng.nextInt(last - first + 1);
        // stores value of pivot
        T pivotValue = nums[pivotIndex];

        // swaps pivot element with last element
        T save = nums[last];
        nums[last] = pivotValue;
        nums[pivotIndex] = save;
        pivotIndex = last;

        // stores left pointer index
        int indexFromLeft = first;
        // stores right pointer index
        int indexFromRight = last - 1;
        // flags whether partition is done
        boolean done = false;

        // while partition is not done
        while(!done) {
            // moves left pointer to the right until pointing to an element > pivot
            while(nums[indexFromLeft].compareTo(pivotValue) < 0 && indexFromLeft < pivotIndex) {
                indexFromLeft++;
            }
            // moves right pointer to the left until pointing to an element < pivot
            while(nums[indexFromRight].compareTo(pivotValue) > 0 && indexFromRight > 0) {
                indexFromRight--;
            }
            // if indexFromLeft < indexFromRight, place the left and right element in correct groups by swapping
            if(indexFromLeft < indexFromRight) {
                T leftValue = nums[indexFromLeft];
                nums[indexFromLeft] = nums[indexFromRight];
                nums[indexFromRight] = leftValue;
                indexFromLeft++;
                indexFromRight--;
            }
            // otherwise, partitioning is done
            else {
                done = true;
            }
        }

        // place pivot in correct position by swapping with left element
        save = nums[indexFromLeft];
        nums[indexFromLeft] = pivotValue;
        nums[pivotIndex] = save;
        pivotIndex = indexFromLeft;

        // returns pivot index
        return pivotIndex;
    }
    
}
