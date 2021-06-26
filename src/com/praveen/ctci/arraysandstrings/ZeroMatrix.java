package com.praveen.ctci.arraysandstrings;

public class ZeroMatrix {

    public static int[][] calculateZeroMatrix(int[][] input) {

        boolean[] bRowes = new boolean[input.length];
        boolean[] bColumns = new boolean[input[0].length];

        for(int row = 0; row < input.length; row++) {
            for(int column = 0; column < input[0].length; column++) {
                if(input[row][column] == 0) {
                    bRowes[row] = true;
                    bColumns[column] = true;
                }
            }
        }

        for (int i = 0; i < bRowes.length; i++) {
            if(bRowes[i]) {
                //In Java Array is an object -> here we are passing reference to the array
                zeroRow(input, i);
            }
        }

        for (int i = 0; i < bColumns.length; i++) {
            if(bColumns[i]) {
                //In Java Array is an object -> here we are passing reference to the array
                zeroColumn(input, i);
            }
        }

        return input;
    }

    public static int[][] calculateZeroMatrixWithoutBooleanArray(int[][] input) {

        //Trick here is to use 1st row and first column as the boolean array!!

        boolean isFirstRowHasZero = false;
        boolean isFirstColumnHasZero = false;

        //Check first row has zero
        for(int column = 0; column < input[0].length; column++) {
            if(input[0][column] == 0) {
                isFirstRowHasZero = true;
                break;
            }
        }

        //Check first Column has zero
        for(int row = 0; row < input.length; row++) {
            if(input[row][0] == 0) {
                isFirstColumnHasZero = true;
                break;
            }
        }

        for(int row = 1; row < input.length; row++) {
            for(int column = 1; column < input[0].length; column++) {
                if(input[row][column] == 0) {
                    input[row][0] = 0; //Make element in the first column as 0;
                    input[0][column] = 0; //Make element in the first row as 0;
                }
            }
        }

        //Check first row - mark corresponding columns as zero
        for (int column = 0; column < input[0].length; column++) {
            if(input[0][column] == 0) {
                //In Java Array is an object -> here we are passing reference to the array
                zeroColumn(input, column);
            }
        }

        //Check first column - mark the corresponding row as zero
        for (int row = 0; row < input.length; row++) {
            if(input[row][0] == 0) {
                //In Java Array is an object -> here we are passing reference to the array
                zeroRow(input, row);
            }
        }

        //if First row has zero
        if(isFirstRowHasZero) {
            zeroRow(input, 0);
        }

        if(isFirstColumnHasZero) {
            zeroColumn(input, 0);
        }

        return input;
    }

    public static void printMatrix(int[][] input) {

        for (int row = 0; row < input.length; row++) {
            for(int column = 0; column < input[0].length; column++) {
                System.out.print(input[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static void zeroColumn(int[][] input, int columnNumber) {
        for(int i = 0; i < input.length; i++) {
            input[i][columnNumber] = 0;
        }
    }

    public static void zeroRow(int[][] input, int rowNumber) {
        for(int i = 0; i < input[0].length; i++) {
            input[rowNumber][i] = 0;
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,2,3,4}, {5,0,6,7}, {0, 9, 8, 10}, {11, 0, 3, 5}};
        int[][] matrix2 = {{1,2,3,4}, {5,0,6,7}, {0, 9, 8, 10}, {11, 0, 3, 5}};
        printMatrix(matrix);
        System.out.println("** After zero Matrix **");
        printMatrix(calculateZeroMatrix(matrix));
        System.out.println("** After zero Matrix with out Boolean arrays **");
        printMatrix(calculateZeroMatrixWithoutBooleanArray(matrix2));
    }


}
