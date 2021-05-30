package com.praveen.fundamentals.basicprogrammingmodel;

public class BinarySearch {

    public static int rank(int element, int[] array) {
        return rank(element, 0 , array.length - 1, array);
    }

    public static int rank(int element, int lo, int hi, int[] arr) {
        while (lo <= hi) {

            int mid = (lo + hi)/2;

            if(arr[mid] > element) {
                hi = mid - 1;
            } else if(arr[mid] < element) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 12, 23, 34, 36, 39, 40 , 44, 46, 60};
        System.out.println("Index of 23 = " + rank(23, arr));
    }
}
