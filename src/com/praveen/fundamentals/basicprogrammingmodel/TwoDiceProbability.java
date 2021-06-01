package com.praveen.fundamentals.basicprogrammingmodel;

public class TwoDiceProbability {

    static int SIDES = 6;
    public static double[] probabilitySumOfValuesOf2Dice() {

        double[] diceProbabilities = new double[2 * SIDES + 1]; //All possible combinations + 1 (0 index)
        for(int firstDiceValue = 1; firstDiceValue <= SIDES; firstDiceValue++) {
            for(int secondDiceValue = 1; secondDiceValue <= SIDES; secondDiceValue++) {
                diceProbabilities[firstDiceValue + secondDiceValue] = firstDiceValue + secondDiceValue;
            }
        }

        for(int i = 0 ; i < diceProbabilities.length; i++) {
            diceProbabilities[i] /= 36; //Calculate probability as 36 possible cases!!
        }

        return diceProbabilities;
    }

}
