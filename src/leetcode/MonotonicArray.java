package leetcode;

/**
 * 문제 : https://leetcode.com/problems/monotonic-array/
 * 레벨 : Easy
 * 결과 : 해결(runtime 2ms faster than 86.48%, memory 52.7MB less than 87.30%)
 */
public class MonotonicArray {

    public static boolean isMonotonic(int[] nums) {

        if(nums.length == 1){
            return true;
        }
        else if(nums.length == 2){
            return true;
        }

        Boolean isIncreasing = null;
        for(int i = 0; i < nums.length-2; i++){
            if(nums[i] == nums[i+1] && nums[i+1] == nums[i+2]){

            }

            else if(nums[i] <= nums[i+1] && nums[i+1] <= nums[i+2]){
                if(isIncreasing == null){
                    isIncreasing = true;
                }
                else if(isIncreasing == false){
                    return false;
                }
            }
            else if(nums[i] >= nums[i+1] && nums[i+1] >= nums[i+2]){
                if(isIncreasing == null){
                    isIncreasing = false;
                }
                else if(isIncreasing == true){
                    return false;
                }

            }
            else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //int[] nums = {11, 11, 9 ,4, 3, 3, 3, 1, -1, -1,3, 3, 3, 5, 5, 5};
        int[] nums = {2, 1, 1, 1, 1};

        System.out.println(isMonotonic(nums));
    }
}
