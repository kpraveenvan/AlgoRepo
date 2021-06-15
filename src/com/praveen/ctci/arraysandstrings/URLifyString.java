package com.praveen.ctci.arraysandstrings;

public class URLifyString {

    public static String urlify(String str, int lenght) {

        //input = "Mr John Smith    " , 13 => 11 + 2 spaces
        int numberOfSpaces = 0;
        for(int i = 0; i < lenght; i++ ) {
            if(str.charAt(i) == ' ') numberOfSpaces++;
        }

        int finalStringLength = lenght + 2 * numberOfSpaces; // you need 3 chars for space char

        char[] arr = new char[finalStringLength];
        boolean isLastNonSpaceCharReached = false;
        for(int i = str.length() - 1 ; i >= 0; i--) { //Move from right to left

            char currentChar = str.charAt(i);
            if(currentChar != ' ') {
                isLastNonSpaceCharReached = true;
            }

            if(isLastNonSpaceCharReached) {
                if(currentChar == ' ') {
                    arr[--finalStringLength] = '0';
                    arr[--finalStringLength] = '2';
                    arr[--finalStringLength] = '%';
                } else {
                    arr[--finalStringLength] = currentChar;
                }
            }
        }
        return new String(arr);
    }

    public static String urlify(String str) {
        //here we just get 'Mr John Smith'
        int numberOfSpaces = 0;
        for(char ch : str.toCharArray()) {
            if(ch == ' ') numberOfSpaces++;
        }
        int finalLength = str.length() + 2 * numberOfSpaces;
        char[] urlifiedString = new char[finalLength];

        for (int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) != ' ') {
                urlifiedString[--finalLength] = str.charAt(i);
            } else {
                urlifiedString[--finalLength] = '0';
                urlifiedString[--finalLength] = '2';
                urlifiedString[--finalLength] = '%';
            }
        }

        return new String(urlifiedString);
    }

    public static void main(String[] args) {
        System.out.println("URLify of 'Mr John Smith' : " + urlify("Mr John Smith    ", 13)); // 13 is 'Mr John Smith' length
        System.out.println("URLify of 'Mr John Smith' : " + urlify("Mr John Smith"));
    }
}
