package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/** 문제 : https://leetcode.com/problems/delete-and-earn/
 *  레벨 : Medium
 *  결과 : 해결(runtime 1ms faster than 100.00%, memory 41.8MB less than 56.86%)
 * */
public class DeleteAndEarn {


    public static int deleteAndEarn(int[] nums) {

        int[] arr = new int[10001];

        int maxIdx = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]]+= nums[i];

            if (nums[i] > maxIdx) {
                maxIdx = nums[i];
            }
        }
        // int max = Math.max(visit[i-2] + arr[i], visit[i-1] + arr[i])
        int[] dp = new int[10001];
        dp[1] = arr[1];

        int max = arr[1];
        for(int i = 2; i <= maxIdx; i++){

            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
            if(max < dp[i])
                max = dp[i];
        }
        return max;


    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(deleteAndEarn(nums));


    }
}
