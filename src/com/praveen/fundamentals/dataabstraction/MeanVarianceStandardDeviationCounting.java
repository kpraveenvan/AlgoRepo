package com.praveen.fundamentals.dataabstraction;

public class MeanVarianceStandardDeviationCounting {

    private double mean;
    private int count;

    public void addDataValue(double input) {

        //mean can also be calculated as (count * mean + input)/count + 1 -> if we have not incremented the count yet!!
        count++;
        mean = mean + (input - mean)/count;


    }
}
