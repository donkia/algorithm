package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2675 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            String s = input[1].toString();
            StringBuilder sb = new StringBuilder();

            for (int k = 0; k < s.length(); k++) {
                for (int j = 0; j < r; j++) {
                    sb.append(s.substring(k, k + 1));
                }
            }
            System.out.println(sb);
        }
    }
}
