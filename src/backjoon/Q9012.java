package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //입력값 셋팅
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {

            String input = bufferedReader.readLine();

            int sum = 0;

            for (int j = 0; j < input.length(); j++) {
                if (input.substring(j, j + 1).equals("(")) {
                    sum++;
                } else if (input.substring(j, j + 1).equals(")")) {
                    sum--;
                    if (sum < 0) {
                        sum = Integer.MAX_VALUE;
                        //System.out.println("NO");
                        //break;
                    }
                }
            }
            if (sum == 0) {
                System.out.println("YES");
            } else
                System.out.println("NO");
        }
    }
}
