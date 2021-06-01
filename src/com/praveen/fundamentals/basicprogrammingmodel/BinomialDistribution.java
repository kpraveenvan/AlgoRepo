package com.praveen.fundamentals.basicprogrammingmodel;

public class BinomialDistribution {

    private static double[][] tempResult;
    private static int countNonOptimal = 0;
    private static int countOptimal = 0;
    public static double binomial(int N, int k, double p) {
        ++countNonOptimal;
        System.out.println("Count = " + countNonOptimal + " N = " + N + " K = " + k + " p = " + p);
        if (N == 0 && k == 0) return 1.0;
        if(N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N-1, k, p) + p * binomial(N-1, k-1, p);
    }

    public static double binomialOptimal(int N, int k, double p) {
        tempResult = new double[N+1][k+1];
        ++countOptimal;
        System.out.println("Count Optimal = " + countOptimal + " N = " + N + " K = " + k + " p = " + p);

        tempResult[0][0] = 0.0;
        //base case - for a given number of tries all the results are negative
        for(int i = 0; i <= N; i++) {
            tempResult[i][0] = Math.pow(1.0 - p, i);
        }

        //base case - for a given number of tries all the results are positive
        for(int i = 0; i <= k; i++) {
            tempResult[i][i] = Math.pow(p, i);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= k; j++) {

                tempResult[i][j] = p * tempResult[i - 1][j -1] //For N -1 trials we got k - 1 positive results and for Nth trial we are getting positive probability p
                        + (1.0 - p) * tempResult[i - 1][j]; // For N -1 Trials we already got K results and next trial is negative with probability 1 - p
            }
        }

       return tempResult[N][k];
    }

    public static void main(String[] args) {
        System.out.println(binomial(10, 6, 0.5));
        System.out.println(binomialOptimal(10, 6, 0.5));
    }

}
