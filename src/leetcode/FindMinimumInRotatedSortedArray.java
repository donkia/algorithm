package leetcode;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * 문제 : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 레벨 : Medium
 * 결과 : 해결(runtime 5ms faster than 36.41%, memory 42.7MB less than 24.06%)
 */

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {

        OptionalInt intStream = IntStream.of(nums).sorted().findFirst();
        return intStream.getAsInt();
    }


    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }
}
