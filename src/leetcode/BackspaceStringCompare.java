package leetcode;

import java.util.Stack;

/**
 * 문제 : https://leetcode.com/problems/backspace-string-compare/
 * 레벨 : Easy
 * 결과 : 해결(runtime 8ms faster than 9.13%, memory 43.2MB less than 5.19%)
 */

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {

        Stack<String> stack_s = new Stack();
        Stack<String> stack_t = new Stack();

        for (int i = 0; i < s.length(); i++) {

            if (s.substring(i, i + 1).equals("#")) {
                if (!stack_s.isEmpty()) {

                    stack_s.pop();
                }
            } else {
                    stack_s.add(s.substring(i, i + 1));
            }

        }

        for (int i = 0; i < t.length(); i++) {

            if (t.substring(i, i + 1).equals("#")) {
                if(!stack_t.isEmpty())
                    stack_t.pop();
            } else {
                stack_t.add(t.substring(i, i + 1));
            }
        }

        StringBuilder sb_s = new StringBuilder();
        StringBuilder sb_t = new StringBuilder();

        for (String temp : stack_s) {
            sb_s.append(temp);
        }

        for (String temp : stack_t) {
            sb_t.append(temp);
        }

        if (sb_s.toString().equals(sb_t.toString())) {
            return true;
        } else
            return false;

    }


    public static void main(String[] args) {
        String s = "a##c";
        String t = "#a#c";
        System.out.println(backspaceCompare(s, t));

    }
}
