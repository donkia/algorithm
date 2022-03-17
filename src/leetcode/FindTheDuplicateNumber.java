package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 문제 : https://leetcode.com/problems/find-the-duplicate-number/
 * 레벨 : Medium
 * 결과 : 해결(runtime 4ms faster than 94.81%, memory 77.4MB less than 16.13%)
 */

public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        /*HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return nums[i];
            } else
                hashMap.put(nums[i], 1);
        }

        return 0;*/

        int[] arr = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            if(arr[nums[i]] > 0){
                return nums[i];
            }
            else
                arr[nums[i]]++;

        }
        return 0;
    }

    public static void main(String[] args) {
        //int[] nums = {1,3,4,2,2};
        //int[] nums = {3,1,3,4,2};
        int[] nums = {2, 2, 2, 2, 2};

        System.out.println(findDuplicate(nums));

    }
}
