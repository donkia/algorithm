package leetcode;

import java.util.Arrays;

/** 문제 : https://leetcode.com/problems/house-robber/
 *  레벨 : Medium
 *  결과 : 해결(runtime 3ms faster than 18.74%, memory 41.7MB less than 8.91%)
 * */

public class HouseRobber {

    public static int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        else if(nums.length == 3){
            return Math.max(nums[0] + nums[2], nums[1]);
        }


        int[] visit = new int[nums.length];

        visit[0] = nums[0];
        visit[1] = nums[1];
        visit[2] = nums[0] + nums[2];

        int max = 0;
        for(int i = 3; i < nums.length; i++){
            visit[i] = Math.max(visit[i - 3] + nums[i], visit[i - 2] + nums[i]);
        }

        for(int i = 0; i < visit.length; i++){
            if(max < visit[i])
                max = visit[i];
        }
        System.out.println(Arrays.toString(visit));

        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 9, 3, 1};
        //int[] nums = {2, 7, 3, 4, 9};
        int[] nums = {1,2,3,1};


        System.out.println(rob(nums));

    }

}
