package leetcode;

import java.util.Arrays;

/**
 * 문제 : https://leetcode.com/problems/longest-consecutive-sequence/
 * 레벨 : Medium
 * 결과 : 해결(runtime 39ms faster than 59.26%, memory 61.5MB less than 51.05%)
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;
        // nums를 sort 하고 distinct한 값 제거
        int[] arr = Arrays.stream(nums).sorted().distinct().toArray();
        int cnt = 1;
        int maxCnt = cnt;

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] + 1 == arr[i + 1]) {
                cnt++;
            } else {
                maxCnt = Math.max(maxCnt, cnt);
                cnt = 1;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);
        return maxCnt;
    }

    public static void main(String[] args) {

        //int[] nums = {100, 4, 200, 1, 3, 2};
        //int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        //int[] nums = {0, 3, 1, 6, 7, 8, 9, 10};
        int[] nums = {1, 2, 0, 1};


        System.out.println(longestConsecutive(nums));

    }


}
