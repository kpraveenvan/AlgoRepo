package com.praveen.fundamentals.basicprogrammingmodel;

public class RandomShuffleArray {

    public static double[] shuffle(double[] arr) {

        for(int i = 0; i < arr.length; i++) {

            int index = i + (int) (Math.random() * (arr.length - i));
            double temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.printf("%14f\n", 123.454545);
        System.out.printf("%14.2f\n", 123.454545);
        System.out.printf("%-14.2f\n", 123.454545);
    }
}
