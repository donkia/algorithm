package programmers;

import java.util.Stack;

public class P76502 {
    // 문자열 변경 함수
    public static String convert(String s) {
        String str = s.substring(1);
        str += s.substring(0, 1);

        return str;
    }

    public static int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();

        if(s.length() == 1) return 0;
        // s의 길이만큼 for문
        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();
            Boolean isRight = true;
            for (int j = 0; j < n; j++) {

                if (s.substring(j, j + 1).equals("[")) {
                    stack.add("[");
                } else if (s.substring(j, j + 1).equals("]")) {
                    if(!stack.isEmpty()){
                        String temp = stack.peek();
                        if (temp.equals("[")) {
                            stack.pop();
                        } else {
                            isRight = false;
                            break;
                        }
                    }
                    else{
                        isRight = false;
                        break;
                    }
                } else if (s.substring(j, j + 1).equals("(")) {
                    stack.add("(");
                } else if (s.substring(j, j + 1).equals(")")) {
                    if(!stack.isEmpty()) {
                        String temp = stack.peek();
                        if (temp.equals("(")) {
                            stack.pop();
                        } else {
                            isRight = false;
                            break;
                        }
                    }
                    else{
                        isRight = false;
                        break;
                    }

                } else if (s.substring(j, j + 1).equals("{")) {
                    stack.add("{");
                } else if (s.substring(j, j + 1).equals("}")) {
                    if(!stack.isEmpty()) {
                        String temp = stack.peek();
                        if (temp.equals("{")) {
                            stack.pop();
                        } else {
                            isRight = false;
                            break;
                        }
                    }
                    else{
                        isRight = false;
                        break;
                    }
                }
            }

            if (isRight == true && stack.isEmpty()) {
                answer++;
            }
            s = convert(s);
        }

        return answer;
    }


    public static void main(String[] args) {
       // String s = "[](){}";
        String s = "([";


        System.out.println(solution(s));
    }
}
