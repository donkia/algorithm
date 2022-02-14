package leetcode;


/** 문제 : https://leetcode.com/problems/maximum-product-subarray/
 *  레벨 : Medium
 *  결과 : 참고 후 해결(runtime 3ms faster than 39.60%, memory 45.1MB less than 8.97%)
 * */

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {

        int maxNum = nums[0];
        int minNum = nums[0];
        int answer = nums[0];
        for(int i = 1; i < nums.length; i++){

            int tempMin = minNum;
            int tempMax = maxNum;

            minNum = Math.min(Math.min(tempMin * nums[i], nums[i]), tempMax * nums[i]);
            maxNum = Math.max(Math.max(tempMax * nums[i], nums[i]), tempMin * nums[i]);

            answer = Math.max(answer, maxNum);

        }

        return answer;
    }

    public static void main(String[] args) {


        int[] nums = {2, 3, -2, 4};
       // int[] nums = {-2, 3, -4};
        //int[] nums = {-1, 2, -9, -6};



        System.out.println(maxProduct(nums));

    }
}
