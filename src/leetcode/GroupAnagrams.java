package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 문제 : https://leetcode.com/problems/group-anagrams/
 * 레벨 : Medium
 * 결과 : 해결(runtime 25ms faster than 26.38%, memory 45.9MB less than 82.84%)
 */

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> answer = new ArrayList<>();

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String s : strs){

            String[] temp = s.split("");
            Arrays.sort(temp);

            StringBuilder stringBuilder = new StringBuilder();
            for(String str : temp){
                stringBuilder.append(str);
            }

            if(hashMap.containsKey(stringBuilder.toString())){
                hashMap.get(stringBuilder.toString()).add(s);
            }
            else{
                List<String> insertList = new ArrayList<>();
                insertList.add(s);
                hashMap.put(stringBuilder.toString(),insertList);
            }
        }
        for(String s : hashMap.keySet()){
            answer.add(hashMap.get(s));
        }

        return answer;

    }

    public static void main(String[] args) {
        //String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = {"a"};


        System.out.println(groupAnagrams(strs));
    }
}
