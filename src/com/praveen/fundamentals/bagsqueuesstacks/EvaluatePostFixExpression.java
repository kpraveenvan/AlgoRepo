package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Stack;

public class EvaluatePostFixExpression {

    public static double evaluatePostFixExpression(String infixExpression) {

        String[] values = infixExpression.split("\\s+");
        Stack<Double> valueStack = new Stack<>();
        for(String value : values) {
            switch (value) {

                case "+":
                    double value2 = valueStack.pop();
                    double value1 = valueStack.pop();
                    valueStack.push(value1 + value2);
                    break;
                case "-":
                    value2 = valueStack.pop();
                    value1 = valueStack.pop();
                    valueStack.push(value1 - value2);
                    break;
                case "*":
                    value2 = valueStack.pop();
                    value1 = valueStack.pop();
                    valueStack.push(value1 * value2);
                    break;
                case "/":
                    value2 = valueStack.pop();
                    value1 = valueStack.pop();
                    valueStack.push(value1 / value2);
                    break;
                default:
                    double doubleValue = Double.parseDouble(value);
                    valueStack.push(doubleValue);
                    break;
            }
        }
        return valueStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluatePostFixExpression("5 6 + 7 8 + *"));
    }
}
