package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[n];
        int[] plus_arr = new int[500001];
        int[] minus_arr = new int[500001];


        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n; i++){

            arr[i] = Integer.parseInt(bufferedReader.readLine());

            sum += arr[i];

            if(arr[i] >= 0){
                plus_arr[arr[i]] ++;
                if(plus_arr[arr[i]] > max){
                    max = plus_arr[arr[i]];
                }
            }
            else{
                minus_arr[arr[i]*-1] ++;
                if(minus_arr[arr[i]*-1] > max){
                    max = minus_arr[arr[i]*-1];
                }
            }
        }

        //int n = 5;
        //int[] arr = {1, 3, 8, -2, 2};


        System.out.println(sum / n); // 1. 산술평균

        Arrays.sort(arr);
        System.out.println(arr[arr.length / 2]); // 2.중앙값

        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] < 0){

                if (max == minus_arr[arr[i]*-1]) {
                    cnt ++ ;
                }

            }
            else{
                if (max == plus_arr[arr[i]]) {
                    cnt++;
                }

            }
            if(cnt == 2){
                System.out.println(arr[i]);
                break;
            }
        }


        System.out.println(arr[arr.length-1] - arr[0]); //4. 범위
    }
}
