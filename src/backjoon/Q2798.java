package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2798 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        String[] strarr = sc.nextLine().split(" ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(strarr[i]);
        }

        int max = Integer.MIN_VALUE;
        Arrays.sort(arr);

        for(int i = arr.length-1; i >= 0; i --){
            if(arr[i] > m) continue;

            for(int j = i-1; j >= 0; j--){
                if(arr[i] + arr[j] > m) continue;
                for(int k = j-1; k >=0 ; k--){

                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum == m){
                        System.out.println(sum);
                        return ;
                    }
                    if(sum < m){
                        if(max < sum){
                            max = sum;
                        }
                    }
                }
            }
        }
        System.out.println(max);

    }
}
