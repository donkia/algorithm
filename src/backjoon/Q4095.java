package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4095 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] map = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String[] temp = bufferedReader.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = Integer.parseInt(temp[j]);
            }
        }
        int max = 0;
        if (n == 1 && m == 1) {
            if (map[1][1] == 0) System.out.println("0");
            else System.out.println("1");
            return;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    dp[1][1] = map[1][1];
                    continue;
                }
                if (map[i][j] == 1) {
                    int min = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max * max);
    }
}
