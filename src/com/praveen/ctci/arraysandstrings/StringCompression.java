package com.praveen.ctci.arraysandstrings;

public class StringCompression {

    //i/p -> aabccccaaa o/p -> a2bc4a3
    private static String compressString (String str) {

        StringBuilder sb = new StringBuilder();
        int counter = 0;
        char tempChar = str.charAt(0);

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == tempChar) {
                counter++;
            }
            if(i == str.length() -1 || ch != tempChar) { //End of string or character is not matching
                if(counter > 2) {
                    sb.append(tempChar).append(counter);
                } else if(counter == 2) {
                    sb.append(tempChar).append(tempChar);
                } else {
                    sb.append(tempChar);
                }
                counter = 1;
                tempChar = ch;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("aabccccaaa compressed is : " + compressString("aabccccaaa"));
    }
}
