package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/** 문제 : https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 *  레벨 : Medium
 *  결과 : 참고 후 해결(runtime 5ms faster than 62.28%, memory 51.5MB less than 64.01%)
 * */

public class MaximumSubarraySumWithOneDeletion {

    public static int maximumSum(int[] arr) {


        long[][] dp = new long[2][arr.length];

        dp[0][0] = arr[0];
        dp[1][0] = arr[0];
        long max = dp[0][0];


        for (int i = 1; i < arr.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1] + arr[i], arr[i]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + arr[i]);
            max = Math.max(Math.max(max, dp[0][i]), dp[1][i]);
        }
        return (int) max;


    }

    public static void main(String[] args) {

    /*    int[] arr = {3, -2, -1, 2};
        System.out.println(maximumSum(arr));

        arr = new int[]{2, 1, -2, -5, -2};
        System.out.println(maximumSum(arr));

        arr = new int[]{1, -2, 0, 3};
        System.out.println(maximumSum(arr));

        arr = new int[]{-1, -1, -1, -1};
        System.out.println(maximumSum(arr));

        arr = new int[]{8, -1, 6, -7, -4, 5, -4, 7, -6}; //17
        System.out.println(maximumSum(arr));

        arr = new int[]{100, 30, 1, 987, 400, 200, 9};
        System.out.println(maximumSum(arr));
*/
        int[] arr = new int[]{1, -2, 0, 3};
        System.out.println(maximumSum(arr));

    }
}
