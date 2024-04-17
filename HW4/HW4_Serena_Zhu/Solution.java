import java.lang.Math;
import java.util.Arrays;

public class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        //double[] magnitudes = new double[points.length];
        /*
        for(int i = 0; i < magnitudes.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            magnitudes[i] = Math.sqrt(((233 - x) * (233 - x)) + ((233 - y) * (233 - y)));
        }
        */

        mergeSort(points, 0, points.length - 1);
        int[][] returnArr = new int[k][2];
        for(int i = 0; i < k; i++) {
            returnArr[i][0] = points[i][0];
            returnArr[i][1] = points[i][1];
        }
        return returnArr;
    }

    public double magnitude(int[][] points, int i) {
        int x = points[i][0];
        int y = points[i][1];
        return Math.sqrt(((233 - x) * (233 - x)) + ((233 - y) * (233 - y)));
    }

    public void mergeSort(int[][] a, int first, int last) {
        if(first < last) {
            int mid = first + (last - first) / 2;
            mergeSort(a, first, mid);
            mergeSort(a, mid + 1, last);
            merge(a, first, mid, last);
        }
    }

    public void merge(int[][] a, int first, int mid, int last) {
        int[] temp = new int[a.length];
        int beginHalfIndex1 = first;
        int endHalfIndex1 = mid;
        int beginHalfIndex2 = mid + 1;
        int endHalfIndex2 = last;
        //double beginHalf1 = magnitude(a, beginHalfIndex1);
        //double beginHalf2 = magnitude(a, beginHalfIndex2);
        int index = 0;
        while(beginHalfIndex1 <= endHalfIndex1 && beginHalfIndex2 <= endHalfIndex2) {
            double beginHalf1 = magnitude(a, beginHalfIndex1);
            double beginHalf2 = magnitude(a, beginHalfIndex2);
            if(beginHalf1 <= beginHalf2) {
                temp[index] = first;
                beginHalfIndex1++;
            }
            else {
                temp[index] = mid + 1;
                beginHalfIndex2++;
            }
            index++;
        }
        while(beginHalfIndex1 <= endHalfIndex1) {
            temp[index] = beginHalfIndex1;
            beginHalfIndex1++;
            index++;
        }
        while(beginHalfIndex2 <= endHalfIndex2) {
            temp[index] = beginHalfIndex2;
            beginHalfIndex2++;
            index++;
        }
        int[][] copy = new int[last - first + 1][2];
        for(int i = 0; i < copy.length; i++) {
            copy[i][0] = a[temp[i]][0];
            copy[i][1] = a[temp[i]][1];
            System.out.println("copy: x: " + copy[i][0] + " + y: " + copy[i][1]);
        }
        int copyIndex = 0;
        for(int i = first; i < last + 1; i++) {
            a[i][0] = copy[copyIndex][0];
            a[i][1] = copy[copyIndex][1];
            copyIndex++;
            System.out.println("F: " + first + "  last: " + last);
            System.out.println(a[i][0] + " " + a[i][1]);
        }
    }

}
