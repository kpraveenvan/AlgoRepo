package com.praveen.fundamentals.basicprogrammingmodel;

public class MatrixLibrary {

    static double dot(double[] x, double[] y) { //vector dot product
        //[1,2,3] vector dot product [2,3,4] => 1*2 + 2*3 + 3*4 =>
        if(x.length != y.length) return 0.0;
        double sum = 0.0;
        for(int i = 0; i < x.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }

    static double[][] mult(double[][] a, double[][] b) { //matrix-matrix product

        if(a[0].length != b.length) return null;
        double[][] result = new double[a.length][b[0].length];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b[0].length; j++) {
                double sum = 0.0;
                for(int k = 0; k < b.length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
    static double[][] transpose(double[][] a) { //transpose
        double[][] result = new double[a[0].length][a.length];
        for(int i = 0; i < a.length; i++) { //Loop all rows
            for(int j = 0; j < a[0].length; j++) { //Loop all columns
                result[j][i] = a[i][j]; //Change rows to columns
            }
        }
        return result;
    }
    static double[] mult(double[][] a, double[] x) { //matrix-vector product

        if(a[0].length != x.length) return null;
        double[] result = new double[a.length];
        for(int i = 0; i < a.length; i++) {
            double sum = 0.0;
            for (int j = 0; j < a[0].length; j++) {
                sum += a[i][j] * x[j];
            }
            result[i] = sum;
        }
        return result;
    }
    static double[] mult(double[] y, double[][] a) { //vector-matrix product

        if(y.length != a.length) return null;
        double[] result = new double[a[0].length];
        for(int i = 0; i < a.length; i++) {
            int sum = 0;
            for(int j = 0; j < a[0].length; j++) {
                result[j] = y[i] * a[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[][] a = {{1,2,3}, {4,5,6}};
        double[][] b = {{2,3}, {5,4}, {6,7}};
        double[] c = {1,2,3};
        double[] d = {4,5,6};
        double dot = dot(c, d);
        double[][] multiplication = mult(a,b);
        double[][] transpose = transpose(a);
        double[] matrixVectorProd = mult(a, c);
        double[] vectorMatrixProd = mult(c, b);
        System.out.println(dot);
        System.out.println(multiplication);
        System.out.println(transpose);
        System.out.println(matrixVectorProd);
        System.out.println(vectorMatrixProd);
    }
}
