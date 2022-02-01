package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5622 {

    public static int convert(String s) {

        if (s.equals("A") || s.equals("B") || s.equals("C")) {
            return 2;
        } else if (s.equals("D") || s.equals("E") || s.equals("F")) {
            return 3;
        } else if (s.equals("G") || s.equals("H") || s.equals("I")) {
            return 4;
        } else if (s.equals("J") || s.equals("K") || s.equals("L")) {
            return 5;
        } else if (s.equals("M") || s.equals("N") || s.equals("O")) {
            return 6;
        } else if (s.equals("P") || s.equals("Q") || s.equals("R") || s.equals("S")) {
            return 7;
        } else if (s.equals("T") || s.equals("U") || s.equals("V")) {
            return 8;
        } else if (s.equals("W") || s.equals("X") || s.equals("Y") || s.equals("Z")) {
            return 9;
        } else
            return 0;
    }

    public static void main(String[] args) throws IOException {
        //입력값 셋팅
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            int temp = convert(input.substring(i, i + 1).toString());
            sum += temp;
        }
        System.out.println(sum + input.length());
    }
}
// A : 65 , Z : 90