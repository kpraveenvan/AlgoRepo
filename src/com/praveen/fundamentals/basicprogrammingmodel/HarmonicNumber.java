package com.praveen.fundamentals.basicprogrammingmodel;

public class HarmonicNumber {

    public static double harmonicNumber(int number) {
        double sum = 0;
        for(int i = 1; i <= number; i++) {
            sum += 1.0/i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(harmonicNumber(20));
        System.out.println(harmonicNumber(2));
        System.out.println(Math.PI);
        System.out.println(Math.E);
        System.out.println(Math.sin(Math.PI/2));
        System.out.println(Math.log(Math.E));
    }
}
