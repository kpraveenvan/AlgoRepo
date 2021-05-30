package com.praveen.fundamentals.basicprogrammingmodel;

public class Fibinacii {

    static long[] fibArray;
    public static long fibinacciiNumber(int input) {

        if(input == 0) {
            fibArray[0] = 0;
            return 0;
        }
        if(input == 1) {
            fibArray[1] = 1;
            return 1;
        }

        fibArray[input] = fibArray[input - 1]  + fibArray[input - 2];
        return fibArray[input];
    }

    public static void main(String[] args) {
        fibArray = new long[100];
        for (int i = 0; i < 100; i++) {
            System.out.println(fibinacciiNumber(i));
        }
    }

}
