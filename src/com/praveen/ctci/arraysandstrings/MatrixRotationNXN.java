package com.praveen.ctci.arraysandstrings;

public class MatrixRotationNXN {


    private static int[][] rotateMatrix(int[][] input, int size) {

        for(int layer = 0; layer < size/2; layer++) {
            int first = layer;
            int last = size - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first; //offset runs from 0 to (last - first)

                //temp = top
                int temp = input[first][i];

                //top = left
                input[first][i] = input[last - offset][first];

                //left = bottom
                input[last - offset][first] = input[last][last - offset];

                //bottom = right
                input[last][last - offset] = input[i][last];

                //right = temp
                input[i][last] = temp;
            }
        }
        return input;
    }

    private static void printMatrix(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2},{10, 11, 12},{20, 21, 22}};
        int[][] matrix2 = {{0, 1, 2, 3},{10, 11, 12, 13},{20, 21, 22, 23},{30, 31, 32, 33}};
        System.out.println("Original Matrix");
        printMatrix(matrix2);
        System.out.println("Rotated Matrix");
        printMatrix(rotateMatrix(matrix2, 4));
    }

}
