import java.util.Random;

public class RandomQuickSort {
    
    private static Random rng = new Random();

    public static <T extends Comparable <? super T>> void quickSort(T[] nums, int first, int last) {
        if(last - first <= 1) {
            if(nums[first].compareTo(nums[last]) < 0) {
                ;
            }
            else {
                T save = nums[first];
                nums[first] = nums[last];
                nums[last] = save;
            }
        }
        else {
            int pivotIndex = partition(nums, first, last);
            if(pivotIndex - 1 > first) {
                quickSort(nums, first, pivotIndex - 1);
            }
            if(pivotIndex + 1 < last) {
                quickSort(nums, pivotIndex + 1, last);
            }
        }
    }

    private static <T extends Comparable <? super T>> int partition(T[] nums, int first, int last) {
        // chooses random pivot
        int pivotIndex = first + rng.nextInt(last - first + 1);
        System.out.println("index: " + pivotIndex);
        //int pivotIndex = rng.nextInt(nums.length - 1);
        T pivotValue = nums[pivotIndex];
        System.out.println("value: " + pivotValue);

        // exchange pivot element with last element
        T save = nums[last];
        nums[last] = pivotValue;
        nums[pivotIndex] = save;
        pivotIndex = last;

        int indexFromLeft = first;
        int indexFromRight = last - 1;
        System.out.println("iFL: " + indexFromLeft + "iFR: " + indexFromRight);
        boolean done = false;

        while(!done) {
            while(nums[indexFromLeft].compareTo(pivotValue) < 0 && indexFromLeft < pivotIndex) {
                indexFromLeft++;
                System.out.println("iFL: " + indexFromLeft + "iFR: " + indexFromRight);
            }
            while(nums[indexFromRight].compareTo(pivotValue) > 0 && indexFromRight > 0) {
                indexFromRight--;
                System.out.println("iFL: " + indexFromLeft + "iFR: " + indexFromRight);
            }
            if(indexFromLeft < indexFromRight) {
                T leftValue = nums[indexFromLeft];
                nums[indexFromLeft] = nums[indexFromRight];
                nums[indexFromRight] = leftValue;
                indexFromLeft++;
                System.out.println("iFL: " + indexFromLeft + "iFR: " + indexFromRight);
                indexFromRight--;
                System.out.println("iFL: " + indexFromLeft + "iFR: " + indexFromRight);
            }
            else {
                done = true;
            }
        }

        save = nums[indexFromLeft];
        nums[indexFromLeft] = pivotValue;
        nums[pivotIndex] = save;
        pivotIndex = indexFromLeft;

        return pivotIndex;
    }
    
}
