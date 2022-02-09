package leetcode;

/** 문제 : https://leetcode.com/problems/n-th-tribonacci-number/
 *  레벨 : easy
 *  결과 : 해결(runtime faster than 100.00%, memory less than 17.55%)
 * */

public class NthTribonacciNumber {

    public int tribonacci(int n) {


        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        if(n == 2)
            return 1;

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3; i <= n ; i++){
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        return arr[n];

    }



}
