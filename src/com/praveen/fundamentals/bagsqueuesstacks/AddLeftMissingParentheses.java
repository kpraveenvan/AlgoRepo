package com.praveen.fundamentals.bagsqueuesstacks;

import java.util.Stack;

public class AddLeftMissingParentheses {
    //I/p -> 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
    //o/p -> ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )

    public static String addMissingLeftParenthesis(String expression) {

        String[] elements = expression.split("\\s+");
        String finalExpression = "";
        Stack<String> values = new Stack<>();
        Stack<String> operators = new Stack<>();
        for(String element : elements) {
            switch (element) {
                case "+":
                case "-":
                case "*":
                case "/":
                    operators.push(element);
                    break;
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    values.push(element);
                    break;
                case ")" :
                    if(operators.isEmpty()) return  "Invalid expression";
                    String operator = operators.pop();
                    String value2 = values.pop();
                    String value1 = values.pop();
                    finalExpression = "( " + value1 + " " + operator + " " + value2 + " )";
                    values.push(finalExpression);
            }

        }
        return finalExpression;
    }

    public static void main(String[] args) {
        System.out.println(addMissingLeftParenthesis("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"));
    }
}
