package com.praveen.fundamentals.basicprogrammingmodel;

public class RelativePrime2DArray {

    public static void print2DRelativelyPrimeArray(int n) {

        boolean[][] arr = new boolean[n][n];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int gcd;
                if(i > j) gcd = gcd(i, j);
                else gcd = gcd(j, i);
                System.out.print((gcd == 1) + " ");
            }
            System.out.println();
        }
    }

    public static int gcd(int i, int j) {
        if(j == 0) return i;
        int r = i % j;
        return gcd(j, r);
    }

    public static void main(String[] args) {
        print2DRelativelyPrimeArray(4);
    }
}
