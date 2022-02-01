package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11053 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[n];
        String[] input = bufferedReader.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){

                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i : dp){
            if(max < i)
                max = i;
        }
        System.out.println(max);
    }
}
