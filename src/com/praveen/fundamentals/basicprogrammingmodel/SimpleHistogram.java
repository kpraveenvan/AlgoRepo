package com.praveen.fundamentals.basicprogrammingmodel;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class SimpleHistogram {

    private static int[] simpleHistogram(int[] arr, int m) {

        int[] histogram = new int[m];
        for(int i = 0; i < arr.length; i++) {
            ++histogram[arr[i]];
        }
        return histogram;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,1,2,1,1,3,3,3,3,3};
        int[] histogram = simpleHistogram(arr, 4);
        Arrays.stream(histogram).forEach(value -> System.out.print(value + " "));
    }

}
