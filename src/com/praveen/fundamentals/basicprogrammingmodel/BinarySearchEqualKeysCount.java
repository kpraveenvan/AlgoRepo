package com.praveen.fundamentals.basicprogrammingmodel;

public class BinarySearchEqualKeysCount {

    public static int rank(int input, int[] arr) {

        int position = rank(input, 0, arr.length - 1, arr);
        return findFirstOccurrenceIndex(input, position, arr);
    }

    public static int count(int input, int[] arr) {
        int position = rank(input, 0, arr.length - 1, arr);
        return findCount(input, position, arr);
    }

    private static int findCount(int input, int position, int[] arr) {
        int count = 0;
        while (position >= 0 && arr[position] == input) {
            count++;
            position--;
        }
        position = position + count + 1;
        while (position <= arr.length -1 && arr[position] == input) {
            count++;
            position++;
        }
        return count;
    }

    public static int rank(int input, int lo, int hi, int[] arr) {

        while (lo <= hi) {
            int mid = (lo + hi)/2;
            if(arr[mid] < input) lo = mid + 1;
            else if(arr[mid] > input) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    private static int findFirstOccurrenceIndex(int input, int position, int[] arr) {

        if(position == 0) return 0;
        while (position > 0 && arr[position] == input) {
            position--;
        }
        return ++position; //Since we return the start index!!
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 7, 7, 8, 9, 10};
        System.out.println(rank(7, arr));
        System.out.println(count(7, arr));
        System.out.println(rank(1, arr));
        System.out.println(count(1, arr));
        System.out.println(rank(10, arr));
        System.out.println(count(10, arr));
    }
}
