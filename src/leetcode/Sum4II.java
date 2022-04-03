package leetcode;

import java.util.HashMap;

/**
 * 문제 : https://leetcode.com/problems/4sum-ii/
 * 레벨 : Medium
 * 결과 : 참고 후 해결(runtime 221ms faster than 39.32%, memory 58.1MB less than 36.88%)
 */

public class Sum4II {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int n1 : nums1){
            for(int n2 : nums2){
                int sum = n1 + n2;
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
        }

        for(int n3 : nums3){
            for(int n4 : nums4){
                int sum = (n3 + n4) * -1;
                cnt += hashMap.getOrDefault(sum, 0);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};


        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
