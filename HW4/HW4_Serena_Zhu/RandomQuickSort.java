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
            quickSort(nums, first, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, last);
            //int pivotIndex = partition(nums, first, last);
            //quickSort(nums, first, pivotIndex - 1);
            //quickSort(nums, pivotIndex + 1, last);
        }
    }

    private static <T extends Comparable <? super T>> int partition(T[] nums, int first, int last) {
        // chooses random pivot
        int pivotIndex = rng.nextInt(last - first + 1);
        //int pivotIndex = rng.nextInt(nums.length - 1);
        T pivotValue = nums[pivotIndex];

        // exchange pivot element with last element
        T save = nums[last];
        nums[last] = pivotValue;
        nums[pivotIndex] = save;
        pivotIndex = last;

        int indexFromLeft = first;
        int indexFromRight = last - 1;
        boolean done = false;

        while(!done) {
            while(nums[indexFromLeft].compareTo(pivotValue) < 0) {
                indexFromLeft++;
                System.out.println("iFL: " + indexFromLeft);
            }
            while(nums[indexFromRight].compareTo(pivotValue) > 0) {
                indexFromRight--;
                System.out.println("iFR: " + indexFromRight);
            }
            if(indexFromLeft < indexFromRight) {
                T leftValue = nums[indexFromLeft];
                nums[indexFromLeft] = nums[indexFromRight];
                nums[indexFromRight] = leftValue;
                indexFromLeft++;
                System.out.println("iFL: " + indexFromLeft);
                indexFromRight--;
                System.out.println("iFR: " + indexFromRight);
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

    /*
    private static <T extends Comparable<? super T>> void insertionSort(T[] nums, int first, int last) {
        for (int i = first + 1; i <= last; i++) {
            T key = nums[i];
            int j = i - 1;
    
            while (j >= first && nums[j].compareTo(key) > 0) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }
    */

    /*
    private static <T extends Comparable<? super T>> void insertionSort(T[] nums, int first, int last) {
        if(first < last) {
            insertionSort(nums, first, last - 1);
            insertInOrder(nums[last], nums, first, last - 1);
        }
    }

    private static <T extends Comparable<? super T>> void insertInOrder(T entry, T[] nums, int begin, int end) {
        if(entry.compareTo(nums[end]) > 0) {
            nums[end + 1] = entry;
        }
        else {
            nums[end + 1] = nums[end];
            insertInOrder(entry, nums, begin, end - 1);
        }
    }
    */
    
}
