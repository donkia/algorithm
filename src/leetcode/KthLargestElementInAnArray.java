package leetcode;

import java.util.Arrays;

/**
 * 문제 : https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 레벨 : Medium
 * 결과 : 해결(runtime 5ms faster than 66.16%, memory 44.8MB less than 35.99%)
 */

public class KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        System.out.println(nums[len - k]);
        return nums[len - k];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2 ,1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));

    }
}
