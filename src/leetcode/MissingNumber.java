package leetcode;

/**
 * 문제 : https://leetcode.com/problems/missing-number/
 * 레벨 : Easy
 * 결과 : 해결(runtime 7ms faster than 22.87%, memory 51.3MB less than 35.78%)
 */

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(i != nums[i]){
                return i;
            }
        }

        return nums[nums.length-1]+1;

    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};
        System.out.println(missingNumber(nums));

    }
}
