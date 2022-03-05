package leetcode;

/**
 * 문제 : https://leetcode.com/minimum-size-subarray-sum/
 * 레벨 : Medium
 * 결과 : 해결(runtime 2ms faster than 62.26%, memory 44.4MB less than 43.38%)
 */

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return 1;
            }
        }
        int min = Integer.MAX_VALUE;

        if (nums.length >= 2) {

            int start = 0;
            int end = start + 1;
            int sum = nums[start] + nums[end];
            while (end < nums.length) {

                if (start == end) {
                    end = end + 1;
                }

                if (sum < target) {

                    end = end + 1;
                    if (end < nums.length)
                        sum += nums[end];
                } else if (sum >= target) {
                    min = Math.min(min, end - start);
                    sum -= nums[start];
                    start = start + 1;
                }

            }
        }
        //System.out.println(min);
        if (min == Integer.MAX_VALUE)
            return 0;
        return min + 1;

    }


    public static void main(String[] args) {
/*
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
*/

        int target = 7;
        int[] nums = {5,3};

        System.out.println(minSubArrayLen(target, nums));
    }
}
