package com.praveen.fundamentals.basicprogrammingmodel;

public class GreatestCommonDivisor {

    //We assume p > q
    public static int gcd(int p, int q) {
        System.out.println("P is " + p + " Q is " + q);
        if(q == 0) return p;
        int remainder = p % q;
        return gcd(q, remainder); //Remainder is always less than q -> Think!!
    }

    public static void main(String[] args) {

        System.out.println("GCD of 1111111 and 1234567 is " + gcd(1234567, 1111111));
        System.out.println("GCD of 24 and 16 is " + gcd(24, 16));
    }

}
