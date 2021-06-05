package com.praveen.fundamentals.bagsqueuesstacks;
import java.util.Stack;

public class BinaryRepresentationOfNumberUsingStack {

    private static void printBinaryRepresentationOfInteger(int number) {

        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            int remainder = number % 2;
            stack.push(remainder);
            number = number/2;
        }

        for(int num : stack) System.out.print(num); //This is the disadvantage of using Java.util.Stack as it prints in the same order
        System.out.println();
        while (!stack.isEmpty()) System.out.print(stack.pop()); //This is correct implementation as last element inserted should be displayed first
    }

    public static void main(String[] args) {
        printBinaryRepresentationOfInteger(50);
    }

}
