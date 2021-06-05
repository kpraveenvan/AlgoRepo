package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Stack;

public class InfixToPostfix {

    public static String inFixToPostfixConverter(String infixExpression) {

        String[] values = infixExpression.split("\\s+");
        String postfix = "";
        Stack<String> valueStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for(String value : values) {

            switch (value) {
                case "+":
                case "-":
                case "/":
                case "*":
                    operatorStack.push(value);
                    break;
                case "(":
                    //NoOp
                    break;
                case ")":
                    String operator = operatorStack.pop();
                    String value2 = valueStack.pop();
                    String value1 = valueStack.pop();
                    postfix = value1 + " " + value2 + " " + operator;
                    valueStack.push(postfix);
                    break;

                default:
                    valueStack.push(value);
                    break;
            }
        }
        while (!operatorStack.isEmpty()) {
            String value2 = valueStack.pop();
            String value1 = valueStack.pop();
            String operator = operatorStack.pop();
            postfix =  value1 + " " + value2 + " " + operator;
            valueStack.push(postfix);
        }

        return postfix;
    }

    public static void main(String[] args) {
        System.out.println(inFixToPostfixConverter("( A + B ) * ( C + D ) * ( E - F ) / ( H - Z )"));
        System.out.println(inFixToPostfixConverter("( A + B ) * ( C + D )"));
    }
}
