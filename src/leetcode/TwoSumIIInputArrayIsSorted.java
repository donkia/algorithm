package leetcode;

import java.util.Arrays;

/** 문제 : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *  레벨 : Medium
 *  결과 : 해결(runtime faster than 22.64%, memory less than 5.02%)
 * */
public class TwoSumIIInputArrayIsSorted {

    public static int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length-1;

        while(start <= end){

            if(numbers[start] + numbers[end] > target){
                end = end - 1;

            }
            else if(numbers[start] + numbers[end] < target){
                start = start + 1;

            }
            else if(numbers[start] + numbers[end] == target) {
                return new int[]{start+1, end+1};
            }
        }
        return new int[]{start+1, end+1};
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,5,6,8};
        int target = 11;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }



}
