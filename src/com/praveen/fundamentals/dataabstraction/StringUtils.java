package com.praveen.fundamentals.dataabstraction;

public class StringUtils {

    public static boolean isPalindrome(String input) {

        if(input.length() == 0 || input.length() == 1) return true;

        for (int i = 0; i < input.length()/2; i++) {
            if(input.charAt(i) != input.charAt(input.length() - 1 - i)) return false;
        }

        return true;
    }

    public static void printFileNameAndExtension(String input) {

        int extensionIndex = input.lastIndexOf(".");
        System.out.println("File Name is " + input.substring(0, extensionIndex));
        System.out.println("Extension is " + input.substring(extensionIndex + 1));
    }

    public static boolean checkIfStringsInAlphabeticalOrder(String[] input) {
        if(input.length == 0 || input.length == 1) return true;

        for(int i = 0; i < input.length -1; i++) {
            if(input[i].compareTo(input[i+1]) > 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("nitin"));
        System.out.println(isPalindrome("niti"));
        System.out.println(isPalindrome("notii"));
        printFileNameAndExtension("xyz.abc.zip");
        String[] values1 = {"a", "aa", "abb", "abc"};
        String[] values2 = {"a", "aa", "abb", "aba"};
        System.out.println("is Values 1 in Order " + checkIfStringsInAlphabeticalOrder(values1));
        System.out.println("is Values 2 in Order " + checkIfStringsInAlphabeticalOrder(values2));
    }
}
