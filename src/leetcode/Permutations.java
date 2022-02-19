package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 문제 : https://leetcode.com/problems/permutations/
 *  레벨 : Medium
 *  결과 : 해결(runtime 2ms faster than 72.16%, memory 45.1MB less than 8.80%)
 * */

public class Permutations {

    static List<List<Integer>> answer;

    public static void DFS(List<Integer> list, int[] check, int[] nums){

        if(list.size() == nums.length){
            answer.add(list);
            return ;
        }

        for(int i = 0; i < check.length; i++){
            if(check[i] == 0){
                check[i] = 1;
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[i]);

                DFS(temp, check, nums);
                check[i] = 0;
            }
        }

    }


    public static List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> list = new ArrayList<>();
            int[] check = new int[nums.length];
            check[i] = 1;
            list.add(nums[i]);
            DFS(list, check, nums);

        }

        //System.out.println(answer);

        return answer;

    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 3};
        int[] nums = {1};



        System.out.println(permute(nums));
    }
}
