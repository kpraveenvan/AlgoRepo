package com.praveen.ctci.arraysandstrings;

public class PalindromePermutation {

    public static boolean isPalindromePermutationUsingCharArray(String str) {

        str = str.toLowerCase();
        char[] arr = new char[128]; //256 if using extending ASCII chars
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') continue;
            int val = str.charAt(i);
            if(arr[val] == 0) {
                arr[val] = 1;
            } else {
                arr[val] = 0;
            }
        }
        boolean oneValueEncountered = false;
        for(int val : arr) {
            if(val > 0) {
                if(!oneValueEncountered) {
                    oneValueEncountered = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPalindromePermutationUsingCharArrayOptimized(String str) {

        int oddCount = 0;
        str = str.toLowerCase();
        char[] arr = new char[128]; //256 if using extending ASCII chars
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') continue;
            int val = str.charAt(i);
            arr[val]++; //Add the corresponding value
            if(arr[val] % 2 == 1) {
                oddCount++;
            } else {
                oddCount--;
            }
        }

        return oddCount <= 1;
    }

    public static boolean isPalindromePermutationUsingBitMap(String str) {
        str = str.toLowerCase();
        int counter = 0;

        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == ' ') continue;
            int value = str.charAt(i) - 'a';
            value = 1 << value; //Left shift

            if((counter & value) == 0) {
                counter = counter | value;
            } else {
                if(value > counter) {
                    counter = value - counter;
                } else {
                    counter = counter - value;
                }
            }
        }

        return counter == 0 || (counter & counter - 1) == 0;

    }

    public static void main(String[] args) {

        System.out.println("Is Palindrome Permutation : Tact coa is " + isPalindromePermutationUsingCharArray("Tact coa"));
        System.out.println("Is Palindrome Permutation : Tact coaa is " + isPalindromePermutationUsingCharArray("Tact coaa"));

        System.out.println("Is Palindrome Permutation : Tact coa is " + isPalindromePermutationUsingCharArrayOptimized("Tact coa"));
        System.out.println("Is Palindrome Permutation : Tact coaa is " + isPalindromePermutationUsingCharArrayOptimized("Tact coaa"));

        System.out.println("Is Palindrome Permutation : Tact coa is " + isPalindromePermutationUsingBitMap("Tact coa"));
        System.out.println("Is Palindrome Permutation : Tact coaa is " + isPalindromePermutationUsingBitMap("Tact coaa"));

    }

}
