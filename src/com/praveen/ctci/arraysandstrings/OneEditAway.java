package com.praveen.ctci.arraysandstrings;

public class OneEditAway {

    public static boolean isOneEditAway(String str1 , String str2) { //Here str1 is larger string

        if(Math.abs(str1.length() - str2.length()) > 1) return false;
        if(str1.length() == str2.length()) return isOneDifferenceUpdate(str1, str2);
        else if(str1.length() > str2.length()) return isOneDifferenceDelete(str1, str2);
        else return isOneDifferenceDelete(str2, str1);
    }

    private static boolean isOneDifferenceUpdate(String str1, String str2) {

        boolean foundDifference = false;
        for(int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                if(foundDifference) { //We already found a difference!!
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    private static boolean isOneDifferenceDelete(String str1, String str2) { //Here we are deleting a character from str1 to make str2
        int str1Index = 0;
        int str2Index = 0;
        boolean foundDifference = false;
        while (str1Index < str1.length() && str2Index < str2.length()) {

            if(str1.charAt(str1Index) != str2.charAt(str2Index)) {
                if(foundDifference) {
                    return false;
                }
                foundDifference = true;
                str1Index++; //This is the place where we identify the missing char in str2 so we just increment str1 index
            } else {
                str1Index++;
                str2Index++;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("Is One Edit away -> pale, ple : " +  isOneEditAway("pale", "ple"));
        System.out.println("Is One Edit away -> pales, pale : " +  isOneEditAway("pales", "pale"));
        System.out.println("Is One Edit away -> pale, bale : " +  isOneEditAway("pale", "bale"));
        System.out.println("Is One Edit away -> pale, bake : " +  isOneEditAway("pale", "bake"));
    }
}
