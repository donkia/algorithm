package leetcode;

/** 문제 : https://leetcode.com/problems/jump-game-ii/
 *  레벨 : Medium
 *  결과 : 해결(runtime 64ms faster than 30.91%, memory 49.5MB less than 13.28%)
 * */

public class JumpGame2 {

    public static int jump(int[] nums) {

        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){

            if(arr[i] == 0 && i != 0){
                continue;
            }

            for(int j = i+1; j <= i + nums[i]; j++){

                if(j > nums.length-1){
                    continue;
                }

                if(arr[j] == 0){
                    arr[j] = arr[i] + 1;
                }
                else{
                    arr[j] = Math.min(arr[j], arr[i] + 1);
                }
            }
        }


        return arr[nums.length-1];
    }

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
        int[] nums = {2,3,0,1,4};

        System.out.println(jump(nums));
    }

}

