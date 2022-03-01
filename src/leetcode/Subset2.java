package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문제 : https://leetcode.com/problems/subsets-ii/
 * 레벨 : Medium
 * 결과 : 해결(runtime 17ms faster than 5.22%, memory 44.6MB less than 7.77%)
 */

public class Subset2 {

    public static boolean isDuplicate(List<Integer> list){

        for(int i = 0; i < answer.size(); i++){

            List<Integer> temp = answer.get(i);
            Boolean isSame = true;
            if(temp.size() == list.size()){

                for(int j = 0; j < temp.size(); j++){
                    if (temp.get(j) != list.get(j)) {
                        isSame = false;
                        continue;
                    }
                }
                if(isSame == true)
                    return true;
            }
            else
                continue;
        }


        return false;
    }

    static List<List<Integer>> answer;

    public static void DFS(int idx, List<Integer> list, int[] nums) {

        for (int i = idx + 1; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[i]);

            if (!isDuplicate(temp)) {
                answer.add(temp);
                DFS(i, temp, nums);
            }

        }

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        answer = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        answer.add(temp);

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            if (!isDuplicate(list)) {
                answer.add(list);
                DFS(i, list, nums);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
