package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 문제 : https://leetcode.com/problems/permutations-ii/
 * 레벨 : Medium
 * 결과 : 해결(runtime 236ms faster than 7.41%, memory 118.1MB less than 5.01%)
 */

public class Permutations2 {

    public static HashSet<String> hashSet;

    public static void makePermutation(ArrayList<Integer> arrayList, int[]nums, int[] visit){

        if(arrayList.size() == nums.length){
            StringBuilder stringBuilder = new StringBuilder();
            for(Integer integer : arrayList){
                stringBuilder.append(Integer.toString(integer)+".");
            }
            hashSet.add(stringBuilder.toString());
            //System.out.println(stringBuilder);
            return;
        }

        for(int i = 0; i < visit.length; i++){
            if(visit[i] == 0){
                ArrayList<Integer> integerArrayList = new ArrayList<>(arrayList);
                integerArrayList.add(nums[i]);
                visit[i] = 1;
                makePermutation(integerArrayList, nums, visit);
                visit[i] = 0;
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        hashSet = new HashSet<>();
        List<List<Integer>> answer = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int[] visit = new int[nums.length];
            visit[i] = 1;
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(nums[i]);
            makePermutation(arrayList, nums, visit);
        }

        System.out.println(hashSet);

        for(String s : hashSet){
            List<Integer> list = new ArrayList<>();
            String[] split = s.split("\\.");
            //System.out.println(split);
            for(String str : split)
                list.add(Integer.parseInt(str));

            answer.add(list);
        }
        return answer;

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //int[] nums = {1,1,0,0,1,-1,-1,1};
        System.out.println(permuteUnique(nums));
    }
}
