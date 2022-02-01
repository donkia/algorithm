package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] input = bufferedReader.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = n-1;
        int min = 0;
        int max = 0;

        int dif = Integer.MAX_VALUE;
        Arrays.sort(arr);
        while(start < end){
            if(Math.abs(arr[end] + arr[start]) < dif){
                dif = Math.abs(arr[end] + arr[start]);
                min = arr[start];
                max = arr[end];
            }
            if(arr[start] + arr[end] > 0){
                end = end - 1;
            }
            else if(arr[start] + arr[end] <= 0){
                start = start + 1;
            }
        }
        System.out.println(min +" " + max);
    }
}
