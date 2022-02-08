package leetcode;
/** 문제 : https://leetcode.com/problems/search-insert-position/
 *  레벨 : easy
 *  결과 : 해결(runtime faster than 100%, memory less than 7.08%)
 * */
import java.util.Arrays;

public class SearchInsertPosition {


    public static int searchInsert(int[] nums, int target) {

        int result = Arrays.binarySearch(nums, target);

        if(result >= 0){
            return result;
        }
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] < target){
                start = mid + 1;
            }
            else
                end = mid -1;
        }

        return start;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));


    }
}
