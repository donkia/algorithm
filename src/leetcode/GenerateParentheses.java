package leetcode;

import java.util.*;

/**
 * 문제 : https://leetcode.com/problems/generate-parentheses/
 * 레벨 : Medium
 * 결과 : 해결(runtime 76ms faster than 5.02%, memory 46.1MB less than 5.08%)
 */

public class GenerateParentheses {

    public static boolean isParenthese(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (stack.isEmpty()) {
                stack.add(s.substring(i, i + 1));

            } else {
                String peek = stack.peek();

                if (peek.equals("(") && s.substring(i, i + 1).equals(")")) {

                    stack.pop();
                } else
                    stack.add(s.substring(i, i + 1));

            }

        }

        if (stack.isEmpty()) {
            return true;
        } else
            return false;
    }


    public static List<String> generateParenthesis(int n) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        List<String> answer = new ArrayList<>();


        Queue<String> queue = new LinkedList<>();
        queue.add("(");

        while (!queue.isEmpty()) {
            String peek = queue.poll();

            if (peek.length() != n * 2) {

                queue.add(peek + "(");
                queue.add(peek + ")");
            } else {
                if (isParenthese(peek)) {
                    answer.add(peek);

                }
            }

        }
        return answer;
    }


    public static void main(String[] args) {

        int n = 3;
        System.out.println(generateParenthesis(n));

    }
}
