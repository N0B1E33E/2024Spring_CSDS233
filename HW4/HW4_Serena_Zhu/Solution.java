import java.lang.Math;

public class Solution {
    
    // method to find k closest points to (233, 233)
    public int[][] kClosest(int[][] points, int k) {
        // calls mergeSort to organize input points in increasing distance from target point
        mergeSort(points, 0, points.length - 1);
        // stores array of points to be returned
        int[][] returnArr = new int[k][2];
        // copies points to be returned into array
        for(int i = 0; i < k; i++) {
            returnArr[i][0] = points[i][0];
            returnArr[i][1] = points[i][1];
        }
        return returnArr;
    }

    // method to calculate distance between point and target (233, 233)
    private double magnitude(int[][] points, int i) {
        int x = points[i][0];
        int y = points[i][1];
        return Math.sqrt(((233 - x) * (233 - x)) + ((233 - y) * (233 - y)));
    }

    // method to sort input array using merge sort
    private void mergeSort(int[][] a, int first, int last) {
        // if array has more than 1 element, calls recursive mergeSort to split array
        if(first < last) {
            // finds approximate midpoint of input array
            int mid = first + (last - first) / 2;
            // calls recursive mergeSort to split array, sorting first half
            mergeSort(a, first, mid);
            // calls recursive mergeSort to split array, sorting second half
            mergeSort(a, mid + 1, last);
            // merges first and second half
            merge(a, first, mid, last);
        }
    }

    // method to merge two halves of input array
    private void merge(int[][] a, int first, int mid, int last) {
        // stores indices of points in increasing distance from target
        int[] temp = new int[a.length];

        // stores index of first half that is being sorted
        int beginHalfIndex1 = first;
        // stores index at which first half is completely sorted
        int endHalfIndex1 = mid;
        // stores index of second half that is being sorted
        int beginHalfIndex2 = mid + 1;
        // stores index at which second half is completely sorted
        int endHalfIndex2 = last;
        // stores distance of first half point from target
        double beginHalf1;
        // stores distance of half half point from target
        double beginHalf2;
        // keeps track of index to add to in temp array
        int index = 0;

        // while either first half and second half have not reached the end of sort
        while(beginHalfIndex1 <= endHalfIndex1 && beginHalfIndex2 <= endHalfIndex2) {
            beginHalf1 = magnitude(a, beginHalfIndex1);
            beginHalf2 = magnitude(a, beginHalfIndex2);
            // if point in first half is closer to target
            if(beginHalf1 <= beginHalf2) {
                // adds index of point of first half to temp
                temp[index] = beginHalfIndex1;
                beginHalfIndex1++;
            }
            // otherwise, point in second half is closer to targer
            else {
                // adds index of point in second half to temp
                temp[index] = beginHalfIndex2;
                beginHalfIndex2++;
            }
            index++;
        }
        // while there are leftover points in first half, add indices to temp
        while(beginHalfIndex1 <= endHalfIndex1) {
            temp[index] = beginHalfIndex1;
            beginHalfIndex1++;
            index++;
        }
        // while there are leftover points in second half, add indices to temp
        while(beginHalfIndex2 <= endHalfIndex2) {
            temp[index] = beginHalfIndex2;
            beginHalfIndex2++;
            index++;
        }
        // stores a copy of the array to amend original array
        int[][] copy = new int[last - first + 1][2];
        // copies points from original array to copy using indicies stored in temp to keep order
        for(int i = 0; i < copy.length; i++) {
            copy[i][0] = a[temp[i]][0];
            copy[i][1] = a[temp[i]][1];
        }
        // stores index of copy array
        int copyIndex = 0;
        // copies copy into original array
        for(int i = first; i < last + 1; i++) {
            a[i][0] = copy[copyIndex][0];
            a[i][1] = copy[copyIndex][1];
            copyIndex++;
        }
    }

}
