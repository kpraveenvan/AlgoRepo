package com.praveen.fundamentals.basicprogrammingmodel;

public class NumberToBinaryString {

    public static String toBinaryString(int number) {

        String binaryString = "";
        while (number > 0) {
            int remainder = number % 2;
            binaryString = remainder + binaryString;
            number = number/2;
        }
        return binaryString;
    }

    public static void main(String[] args) {
        System.out.println(toBinaryString(65));
    }
}
