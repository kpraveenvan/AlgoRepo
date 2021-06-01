package com.praveen.fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.Stack;

public class EvaluateExpressions {

    static Stack<Double> valueStack = new Stack<>();
    static Stack<String> operatorStack = new Stack<>();

    public static double evaluate(String expression) {

        String[] tokens = expression.split("\\s+");

        for(String token : tokens) {

            if(token.equals("("));  //Do Nothing;
            else if(token.equals("+")) operatorStack.push("+");
            else if(token.equals("-")) operatorStack.push("-");
            else if(token.equals("*")) operatorStack.push("*");
            else if(token.equals("/")) operatorStack.push("/");
            else if(token.equals("sqrt")) operatorStack.push("sqrt");
            else if(token.equals(")")) {
                String operator = operatorStack.pop();
                if(operator.equals("+")) {
                    double result = valueStack.pop() + valueStack.pop();
                    valueStack.push(result);
                }
                if(operator.equals("-")) {
                    double result = valueStack.pop() - valueStack.pop();
                    valueStack.push(result);
                }
                if(operator.equals("*")) {
                    double result = valueStack.pop() * valueStack.pop();
                    valueStack.push(result);
                }
                if(operator.equals("/")) {
                    double result = valueStack.pop() / valueStack.pop();
                    valueStack.push(result);
                }
                if(operator.equals("sqrt")) {
                    double value = valueStack.pop();
                    valueStack.push(Math.sqrt(value));
                }
            } else {
                valueStack.push(Double.parseDouble(token));
            }
        }
        return valueStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
        System.out.println(evaluate("( ( 1 + sqrt ( 5.0 ) ) / 2.0 )"));
    }
}
