package leetcode;

import java.util.stream.Stream;
/**
 * 문제 : https://leetcode.com/problems/basic-calculator-ii/
 * 레벨 : Medium
 * 결과 : 참고 후 해결(runtime 13ms faster than 75.73%, memory 43.7MB less than 74.55%)
 */

public class BasicCalculator2 {
    public static int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int currentNumber = 0;
        int lastNumber = 0;
        int result = 0;
        char operation = '+';
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length-1) {

                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                }
                if (operation == '*') {
                    lastNumber *= currentNumber;
                }
                if (operation == '/') {
                    lastNumber /= currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }

        result += lastNumber;

        return result;
    }
/*

    public static int recursion(String s) {

        if (s.contains("+")) {
            String[] split = s.split("\\+");
            int num = 0;
            for (int i = 0; i < split.length; i++) {
                num += recursion(split[i]);
            }
            return num;

        } else if (s.contains("-")) {
            String[] split = s.split("\\-");
            int num = 0;
            for (int i = 0; i < split.length; i++) {
                if (i == 0) num = recursion(split[i]);
                else
                    num -= recursion(split[i]);
            }
            return num;

        } else if(s.contains("*") || s.contains("/")){

            if(s.indexOf("*") < 0){
                String[] split = s.split("\\/");
                int num = 1;
                for (int i = 0; i < split.length; i++) {
                    if (i == 0) num = recursion(split[i]);
                    else
                        num /= recursion(split[i]);
                }
                return num;
            }


            else if(s.indexOf("/") < 0){
                String[] split = s.split("\\*");
                int num = 1;
                for (int i = 0; i < split.length; i++) {
                    num *= recursion(split[i]);
                }

                return num;
            }

            else if(s.indexOf("*") < s.indexOf("/")){
                String[] split = s.split("\\*");
                int num = 1;
                for (int i = 0; i < split.length; i++) {
                    num *= recursion(split[i]);
                }

                return num;
            }

            else{
                String[] split = s.split("\\/");
                int num = 1;
                for (int i = 0; i < split.length; i++) {
                    if (i == 0) num = recursion(split[i]);
                    else
                        num /= recursion(split[i]);
                }
                return num;
            }


        }

        */
/*
        else if (s.contains("*")) {
            String[] split = s.split("\\*");
            int num = 1;
            for (int i = 0; i < split.length; i++) {
                num *= recursion(split[i]);
            }

            return num;
        } else if (s.contains("/")) {
            String[] split = s.split("\\/");
            int num = 1;
            for (int i = 0; i < split.length; i++) {
                if (i == 0) num = recursion(split[i]);
                else
                    num /= recursion(split[i]);
            }
            return num;
        }*//*


        return Integer.parseInt(s);

    }

    public static int calculate(String s) {
        s = s.replaceAll(" ", "");

        return recursion(s);
    }
*/

    public static void main(String[] args) {
        String s = "123-8*5-57/3+148+1*3/2*14*11*2*5/4*3/3/3+2283";
        System.out.println(calculate(s));
    }
}
