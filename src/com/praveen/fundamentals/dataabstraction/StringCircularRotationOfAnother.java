package com.praveen.fundamentals.dataabstraction;

public class StringCircularRotationOfAnother {

    public static boolean isCircularRotation(String baseString, String input) {
        //Base TGACGAC
        //Circular ACTGACG
        //Base + Base -> TGACGACTGACGAC //Base + Base should contain the circular rotated string!!
        //Circular + Circular -> ACTGACGTGACGAC //Circular + Circular should contain the Base String!!

        String basePlusBase = baseString + baseString;
        return basePlusBase.contains(input);

    }

    public static void main(String[] args) {
        System.out.println(isCircularRotation("TGACGAC", "ACTGACG"));
    }

}
