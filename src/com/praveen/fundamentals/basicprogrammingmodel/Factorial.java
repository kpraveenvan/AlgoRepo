package com.praveen.fundamentals.basicprogrammingmodel;

public class Factorial {
    private static long[] factorials;
    public static long factorial(int input) {

        if(input == 0) {
            factorials[0] = 1;
            return 1;
        }
        if(input == 1) {
            factorials[1] = 1;
            return 1;
        }

        factorials[input] =  input * factorials[input - 1];
        return factorials[input];
    }

    public static void main(String[] args) {

        factorials = new long[100];
        for(int i = 0; i < 100; i++) {
            System.out.println(factorial(i));
        }
    }
}
