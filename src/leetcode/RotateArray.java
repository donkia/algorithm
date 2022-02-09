package leetcode;
/** 문제 : https://leetcode.com/problems/rotate-array/
 *  레벨 : medium
 *  결과 : 해결(runtime faster than 45.17%, memory less than 20.06%)
 * */
public class RotateArray {

    public static void rotate(int[] nums, int k) {

        int[] arr = new int[nums.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = nums[i];
        }
        for(int i = 0; i < arr.length; i++){

            if(i + k >= arr.length){
                nums[(i + k) % arr.length] = arr[i];
            }
            else{
                nums[i + k] = arr[i];
            }
        }


    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5,6, 7};
        int k = 3;
        //System.out.println(rotate(nums, k));
        rotate(nums, k);

    }


}
