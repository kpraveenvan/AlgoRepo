package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Stack;

public class ParanthesisProperlyBalanced {

    public static boolean isBalanced(String expression) {

        Stack<Character> chStack = new Stack<>();
        for(char ch: expression.toCharArray()) {

            if(ch == '{' || ch == '[' || ch == '(') {
                chStack.push(ch);
            } else if(ch == '}' || ch == ']' || ch == ')') {
                if(chStack.isEmpty()) return false;
                char stackElement = chStack.pop();
                if((ch == '}' && stackElement != '{')
                        || (ch == ']' && stackElement != '[')
                        || (ch == ')' && stackElement != '(')) return false;
            } else {
                //Operation Not Supported
            }
        }
        return chStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("is [()]{}{[()()]()} balanced ? " + isBalanced("[()]{}{[()()]()}"));
        System.out.println("is [(]) balanced ? " + isBalanced("[(])"));
    }
}
