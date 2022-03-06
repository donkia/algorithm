package leetcode;

/**
 * 문제 : https://leetcode.com/climbing-stairs/
 * 레벨 : Easy
 * 결과 : 해결(runtime 0ms faster than 100%, memory 39.1MB less than 51.52%)
 */

public class ClimbingStairs {
    public static int []arr;

    public int climbStairs(int n) {


        if(n == 2){
            return 2;


        }
        else if(n==1)
            return 1;

        else if(n == 3){
            return 3;

        }

        if(n >= 4){
            arr = new int[n+1];
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;

            for(int i = 3 ; i <= n ; i++){

                arr[i] = arr[i-1] + arr[i-2];

            }



        }
        return arr[n];
    }
}
