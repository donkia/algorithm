package leetcode;

/**
 * 문제 : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 레벨 : Medium
 * 결과 : 해결(runtime 16ms faster than 7.28%, memory 48.1MB less than 6.59%)
 */
public class FindFirstandLastPositionofElementinSortedArray {

    public static int[] searchRange(int[] nums, int target) {

        int start = -1;
        int end = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                    end = i;
                } else if (start != -1) {
                    end = i;
                }
                if (end == -1) {
                    end = i;
                }
            } else if (nums[i] > target) {
                break;
            }
        }

        System.out.println(start +", " + end);
        return new int[]{start, end};
    }


    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(searchRange(nums, target));

    }
}
