package leetcode;

/**
 * 문제 : https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 레벨 : Medium
 * 결과 : 해결(runtime 0ms faster than 100%, memory 42.7MB less than 21.86%)
 */

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0 , 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }


}
