package leetcode;

import java.util.Arrays;
/** 문제 : https://leetcode.com/problems/squares-of-a-sorted-array/
 *  레벨 : easy
 *  결과 : 해결(runtime faster than 14.64%, memory less than 9.47%)
 * */
public class SquaresOfaSortedArray {


    public int[] sortedSquares(int[] nums) {

        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);

        return nums;

    }


}
