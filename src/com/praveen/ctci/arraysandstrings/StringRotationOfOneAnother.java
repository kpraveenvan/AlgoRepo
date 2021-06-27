package com.praveen.ctci.arraysandstrings;

public class StringRotationOfOneAnother {

    public static boolean isRotationOfOneAnother(String s1, String s2) {

        if(s1.length() != s2.length()) {
            return false;
        }

        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }

    public static void main(String[] args) {

        System.out.println("Is rotation 'waterbottle', 'erbottlewat' ?? " + isRotationOfOneAnother("waterbottle", "erbottlewat"));
        System.out.println("Is rotation 'waterbottle', 'erbottlewaq' ?? " + isRotationOfOneAnother("waterbottle", "erbottlewaq"));
    }
}
