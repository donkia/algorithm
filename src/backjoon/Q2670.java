package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2670 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //String input = bufferedReader.readLine();
        //int n = 8;
        int n = Integer.parseInt(bufferedReader.readLine());
        double[] arr = new double[n];
        for(int i = 0; i < n; i++){
            arr[i] = Double.parseDouble(bufferedReader.readLine());
        }
        //double[] arr = {1.1, 0.7, 1.3, 0.9, 1.4, 0.8, 0.7, 1.4};
        double[][] dp = new double[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        double max = arr[0];

        for(int i = 1; i < n; i++){
            dp[i][0] = arr[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) * arr[i];
            max = Math.max(Math.max(dp[i][0], dp[i][1]), max);
        }

        System.out.println(String.format("%.3f", max));


    }
}
