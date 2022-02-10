package leetcode;

/** 문제 : https://leetcode.com/problems/move-zeroes/
 *  레벨 : easy
 *  결과 : 해결(runtime faster than 68.27%, memory less than 8.95%)
 * */

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                arr[idx++] = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = arr[i];
        }
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

    }



}
