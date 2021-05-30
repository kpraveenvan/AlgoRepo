package com.praveen.fundamentals.basicprogrammingmodel;

public class MaxIntegerValueForALogBase {

    public static int maxIntValueForLogBase(int integer, int base) {

        int logValue = 0;
        while (integer >= base) {
            integer = integer / base;
            logValue++;
        }
        return logValue;
    }

    public static void main(String[] args) {
        System.out.println(maxIntValueForLogBase(5, 2));
        System.out.println(maxIntValueForLogBase(27, 3));
    }


}
