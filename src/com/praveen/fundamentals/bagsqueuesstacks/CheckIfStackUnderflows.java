package com.praveen.fundamentals.bagsqueuesstacks;

public class CheckIfStackUnderflows {

    //- -> pop
    //Number -> push
    public static boolean isStackUnderflow(String sequence) {
        String[] inputs = sequence.split("\\s+");
        int pops = 0;
        int pushes = 0;
        for(String ch : inputs) {
            if(ch.equals("-")) {
                pops++;
            } else {
                pushes++;
            }
            if(pops > pushes) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String sequence1 = "0 - 1 2 - - 3 4 5 - - - - 6 7 8 9";
        String sequence2 = "0 - 1 2 - - 3 4 5 - - - 6 7 8 9 - - - -";

        System.out.printf("isStackUnderflow(\"%s\") = %s\n", sequence1, isStackUnderflow(sequence1));
        System.out.printf("isStackUnderflow(\"%s\") = %s\n", sequence2, isStackUnderflow(sequence2));
    }
}
