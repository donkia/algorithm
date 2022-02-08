package leetcode;
/** 문제 : https://leetcode.com/problems/binary-search/
 *  레벨 : easy
 *  결과 : 해결(runtime faster than 100%, memory less than 61.33%)
 * */
public class binarySearch {

    public static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(nums[mid] == target){
                return mid;
            }

            else if(nums[mid] > target){
                end = mid-1;

            }
            else if(nums[mid] < target){
                start = mid+1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
      /*  int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;*/

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;

        System.out.println(search(nums, target));
    }

}
