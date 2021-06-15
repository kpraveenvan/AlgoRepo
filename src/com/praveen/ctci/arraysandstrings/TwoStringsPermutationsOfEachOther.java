package com.praveen.ctci.arraysandstrings;

import java.util.Arrays;

public class TwoStringsPermutationsOfEachOther {

    public static boolean isPermutationOfEachOtherUsingCharArray(String str1, String str2) {

        if(str1.length() != str2.length()) return false;

        int[] arr = new int[128]; //Use 256 if using extended ASCII chars

        for(int i = 0; i < str1.length(); i++) {
            int val = str1.charAt(i);
            ++arr[val];
        }

        for(int i = 0; i < str2.length(); i++) {
            int val = str2.charAt(i);
            if(arr[val] == 0) return false;
            --arr[val];
        }

        for(int val : arr) {
            if(val > 0) return false;
        }

        return true;
    }

    public static boolean isPermutationOfEachOtherUsingSorting(String str1, String str2) {

        if(str1.length() != str2.length()) return false;

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return new String(arr1).equals(new String(arr2));
    }

    public static void main(String[] args) {
        System.out.println("is ASDABBC and ABBCDSA permutation of each other ?? : " + isPermutationOfEachOtherUsingCharArray("ASDABBC", "ABBCDSA"));
        System.out.println("is ASDABBZ and ABBCDSX permutation of each other ?? : " + isPermutationOfEachOtherUsingCharArray("ASDABBZ", "ABBCDSX"));

        System.out.println("is ASDABBC and ABBCDSA permutation of each other ?? : " + isPermutationOfEachOtherUsingSorting("ASDABBC", "ABBCDSA"));
        System.out.println("is ASDABBZ and ABBCDSX permutation of each other ?? : " + isPermutationOfEachOtherUsingSorting("ASDABBZ", "ABBCDSX"));
    }

}
