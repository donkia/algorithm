package leetcode;

import java.util.Arrays;

/** 문제 : https://leetcode.com/problems/maximum-subarray/
 *  레벨 : Easy
 *  결과 : 해결(runtime 3ms faster than 27.29%, memory 73.7MB less than 57.73%)
 * */

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {


        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = dp[0];
        for(int i = 1; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
       // int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = {5,4,-1,7,8};
        int[] nums = {1};


        System.out.println(maxSubArray(nums));
    }
}
