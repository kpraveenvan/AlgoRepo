package com.praveen.ctci.arraysandstrings;

public class CheckAllCharactersUnique {

    public static boolean isUniqueCharacters(String str) {
        //Assume its ASCII string
        if(str.length() > 128) return false; //Check with 256 if using extended ASCII chars
        boolean[] charArray = new boolean[128]; //Use 256 if non extended ASCII chars
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i); // Char is converted to its ascii equivalent of int;
            if(charArray[val]) {
                return false;
            }
            charArray[val] = true;
        }
        return true;
    }

    public static boolean isUniqueCharactersUsingBitMap(String str) {
        //Assume its ASCII string
        if(str.length() > 128) return false; //Check with 256 if using extended ASCII chars
        //We assume that all chars are upper or lower or convert to lower!!
        str = str.toLowerCase();
        int adder = 0;
        for(int i = 0; i < str.length(); i++) {

            int val = str.charAt(i) - 'a';
            if((adder & (1 << val)) > 0) {
                return false;
            }
            adder = adder | (1 << val); //We are logically adding!! -> Here we are adding different values!! int only has 32 bits
        }
        return true;
    }


    public static void main(String[] args) {
        int i = 4;
        System.out.println(i << 1);
        System.out.println(i << 2);
        System.out.println(i << 3);
        System.out.println("isUniqueCharacters string - ASDFGHJSKL : " +  isUniqueCharacters("ASDFGHJSKL"));
        System.out.println("isUniqueCharacters string - ASDFGHJKL : " +  isUniqueCharacters("ASDFGHJKL"));
        System.out.println("isUniqueCharacters string - ASDFGHJSKL : " +  isUniqueCharactersUsingBitMap("ASDFGHJSKL"));
        System.out.println("isUniqueCharacters string - ASDFGHJKL : " +  isUniqueCharactersUsingBitMap("ASDFGHJKL"));
    }
}
