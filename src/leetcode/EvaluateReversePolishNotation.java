package leetcode;

import java.util.Stack;

/**
 * 문제 : https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 레벨 : Medium
 * 결과 : 해결(runtime 15ms faster than 14.03%, memory 44.5MB less than 28.05%)
 */

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("*") || tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                if (tokens[i].equals("*")) {
                    stack.add(num1 * num2);
                }
                if (tokens[i].equals("+")) {
                    stack.add(num1 + num2);
                }
                if (tokens[i].equals("-")) {
                    stack.add(num2 - num1);
                }
                if (tokens[i].equals("/")) {
                    stack.add(num2 / num1);
                }

            } else {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] token = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(token));
    }
}
