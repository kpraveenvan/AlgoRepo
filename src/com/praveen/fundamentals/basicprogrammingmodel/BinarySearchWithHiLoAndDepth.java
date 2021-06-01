package com.praveen.fundamentals.basicprogrammingmodel;

public class BinarySearchWithHiLoAndDepth {

    static int depth = 0;
    public static int binarySearch(int input, int[] arr) {
        return binarySearch(input, 0, arr.length - 1, arr);
    }

    public static int binarySearch(int input, int lo, int hi, int[] arr) {

        if(lo > hi) return -1;
        System.out.println("Lo is " + hi + " Hi is " + lo + " Depth is " + ++depth);

        int mid = (lo + hi)/2;
        if(arr[mid] < input) return binarySearch(input, mid + 1, hi, arr);
        else if(arr[mid] > input) return binarySearch(input, lo, mid -1, arr);
        else return mid;
    }


    public static void main(String[] args) {
        int[] sortedArray = {1, 4, 6, 7, 9, 12, 14, 15, 17, 45, 56, 67, 74, 92, 101, 105};
        System.out.println("Index of 14 is " + binarySearch(14, sortedArray));
    }



}
