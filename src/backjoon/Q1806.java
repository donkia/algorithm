package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1806 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        //int n = 10;
        //int s = 15;

        //int[] arr = {5, 1, 4, 5, 10, 7, 4, 9, 2, 8};
        int[] arr = new int[n];
        input = bufferedReader.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }


        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = Integer.MAX_VALUE;

        while(true){

            if(sum >= s){
                if(end-start < cnt){
                    cnt = end - start;
                }
                sum -= arr[start];
                start = start + 1;
            }
            else if(end == n){
                break;
            }
            else{
                //end = end + 1;
                sum += arr[end++];
            }
        }

        if(cnt == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(cnt);

    }

}
