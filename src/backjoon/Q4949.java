package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //입력값 셋팅
        while (true) {
            String input = bufferedReader.readLine();
            Stack<String> stringStack = new Stack<>();
            boolean fail = false;
            for (int i = 0; i < input.length(); i++) {

                String temp = input.substring(i, i + 1);

                if (temp.equals("(")) {
                    stringStack.add("(");
                } else if (temp.equals(")")) {
                    if (stringStack.isEmpty()) {
                        fail = true;
                        break;
                    }
                    String peek = stringStack.peek();
                    if (!peek.equals("(") && !stringStack.isEmpty()) {
                        fail = true;
                        break;
                    }
                    stringStack.pop();
                } else if (temp.equals("[")) {
                    stringStack.add("[");
                } else if (temp.equals("]")) {
                    if (stringStack.isEmpty()) {
                        fail = true;
                        break;
                    }
                    String peek = stringStack.peek();
                    if (!peek.equals("[") && !stringStack.isEmpty()) {
                        fail = true;
                        break;
                    }
                    stringStack.pop();
                }
            }
            if (input.length() == 1 && input.substring(0, 1).equals(".")) {
                break;
            }

            if (fail == true) {
                System.out.println("no");
                // break;
            } else {
                if (stringStack.isEmpty()) {
                    System.out.println("yes");
                } else
                    System.out.println("no");
            }
        }
    }
}
