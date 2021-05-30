package com.praveen.fundamentals.basicprogrammingmodel;

public class SquareRoot {

    public static double sqrt(double input) {
        if(input < 0) return Double.NaN;

        double tolerance = 0.000001;
        double root;
        double assumedSquareRoot = input; //Assume the sqrt to be equal to original value
        while (true) {

           root = 0.5 * (assumedSquareRoot + input/assumedSquareRoot);

           if(Math.abs(root - assumedSquareRoot) < tolerance) { //Check if difference between
                                                                // root (actual sqrt) and assumedSquareRoot are in tolerance levels
               break;
           }

           assumedSquareRoot = root; //Repeat the loop with assumedSquareRoot by assigning it to calculated sqrt (root)
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(4.0));
    }
}
