package codingTest;

import java.util.Stack;

public class Q5_20220320 {

    public static int solution(String s) {
        int answer = 0;

        int cntLarge = 0;
        int cntMedium = 0;
        int cntSmall = 0;
        String addStr = "";
        String oppositStr = "";

        for (int i = 0; i < s.length(); i++) {

            if (s.substring(i, i + 1).equals("[")) {
                cntLarge++;
            } else if (s.substring(i, i + 1).equals("]")) {
                cntLarge--;
            } else if (s.substring(i, i + 1).equals("{")) {
                cntMedium++;
            } else if (s.substring(i, i + 1).equals("}")) {
                cntMedium--;
            } else if (s.substring(i, i + 1).equals("(")) {
                cntSmall++;
            } else if (s.substring(i, i + 1).equals(")")) {
                cntSmall--;
            }
        }

        if (cntLarge != 0) {
            if (cntLarge > 0) {
                addStr = "]";
                oppositStr = "[";
            }
            else {
                addStr = "[";
                oppositStr = "]";
            }
        } else if (cntMedium != 0) {
            if (cntMedium > 0) {
                addStr = "}";
                oppositStr = "{";
            }
            else {
                addStr = "{";
                oppositStr = "}";
            }
        } else if (cntSmall != 0) {
            if (cntSmall > 0) {
                addStr = ")";
                oppositStr = "(";
            }
            else {
                addStr = "(";
                oppositStr = ")";
            }
        }


        for (int i = 0; i <= s.length(); i++) {

            Stack<String> stack = new Stack<>();
            StringBuilder stringBuilder = new StringBuilder(s);
            stringBuilder.insert(i, addStr);

            Boolean isPossible = true;
            for (int j = 0; j < stringBuilder.length(); j++) {
                String temp = stringBuilder.substring(j, j + 1);

                if (temp.equals("(") || temp.equals("{") || temp.equals("[")) {
                    stack.add(temp);
                } else if (temp.equals(")") || temp.equals("}") || temp.equals("]")) {

                    if (stack.isEmpty()) {
                        isPossible = false;
                        break;
                    } else {
                        if (temp.equals(")") && stack.peek().equals("(")) {
                            stack.pop();
                        } else if (temp.equals("}") && stack.peek().equals("{")) {
                            stack.pop();
                        } else if (temp.equals("]") && stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            isPossible = false;
                            break;
                        }
                    }

                }
            }

            if (stack.isEmpty() && isPossible == true) {
                answer++;
            }

        }
        return answer;
    }


    public static void main(String[] args) {
        //String s = "[]([[]){}";
        String s = "(()()()";



        System.out.println(solution(s));

    }


}
