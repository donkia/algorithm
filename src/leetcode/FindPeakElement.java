package leetcode;

/**
 * 문제 : https://leetcode.com/problems/find-peak-element/
 * 레벨 : Medium
 * 결과 : 해결(runtime 0ms faster than 100%, memory 42.3MB less than 35.12%)
 */


public class FindPeakElement {

    public static int findPeakElement(int[] nums) {

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums));

    }
}
