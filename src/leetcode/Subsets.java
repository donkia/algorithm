package leetcode;

import java.util.*;

/**
 * 문제 : https://leetcode.com/problems/subsets/
 * 레벨 : Medium
 * 결과 : 해결(runtime 1ms faster than 82.25%, memory 42.9MB less than 49.59%)
 */

public class Subsets {

    static List<List<Integer>> answer;

    public static void DFS(int idx, List<Integer> list, int[] nums) {

        for (int i = idx + 1; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[i]);

            answer.add(temp);
            DFS(i, temp, nums);
        }

    }

    public static List<List<Integer>> subsets(int[] nums) {

        answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        answer.add(temp);

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            answer.add(list);

            DFS(i, list, nums);
        }

        return answer;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
        //int[] nums = {-1, 1, 2};


        System.out.println(subsets(nums));

    }
}
