package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3273 {

    public static void main(String[] args) throws IOException {
        //입력값 셋팅
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[n];
        String[] input = bufferedReader.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        int sum =Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        int cnt = 0;

        while(start < end){

            if(arr[start] + arr[end] == sum){
                cnt = cnt + 1;
            }
            if(arr[start] + arr[end] > sum){
                end = end - 1;
            }
            else if(arr[start] + arr[end] <= sum){
                start = start + 1;
            }
        }
        System.out.println(cnt);
    }
}
