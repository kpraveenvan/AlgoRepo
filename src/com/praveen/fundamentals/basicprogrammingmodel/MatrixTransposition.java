package com.praveen.fundamentals.basicprogrammingmodel;

public class MatrixTransposition {

    public static int[][] transpose(int[][] original) {
        int rows = original.length;
        int columns = original[0].length;

        int[][] transpose = new int[columns][rows];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                transpose[j][i] = original[i][j];
            }
        }
        return transpose;
    }

    public static void printMatrix(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}, {13,14,15}};
        printMatrix(matrix);
        int[][] transpose = transpose(matrix);
        System.out.println();
        printMatrix(transpose);
    }
}
