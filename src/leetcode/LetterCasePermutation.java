package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/** 문제 : https://leetcode.com/problems/letter-case-permutation/
 *  레벨 : Medium
 *  결과 : 해결(runtime 585ms faster than 5.02%, memory 159.9MB less than 5.46%)
 * */

public class LetterCasePermutation {
    /**
     * DFS로 하면 시간 초과 발생으로 이중for문으로 변경
     * 문자열을 순서대로 탐색하면서 소문자, 대문자로 변경해줌
     */
    public static List<String> letterCasePermutation(String s){

        HashSet<StringBuilder> hashSet = new HashSet<>();
        List<String> list = new ArrayList<>();
        hashSet.add(new StringBuilder(s));
        String number = "0123456789";

        for(int i = 0; i < s.length(); i++){
            // 숫자인지 아닌지 판단
            if (number.contains(s.substring(i, i + 1))) {
                continue;
            }

            List<StringBuilder> tempList = new ArrayList<>();
            for(StringBuilder temp : hashSet){

                //소문자로 변경
                StringBuilder lowercaseTemp = new StringBuilder(temp);
                lowercaseTemp.replace(i, i + 1, temp.substring(i, i + 1).toLowerCase());
                tempList.add(lowercaseTemp);

                //대문자로 변경
                StringBuilder uppercaseTemp = new StringBuilder(temp);
                uppercaseTemp.replace(i, i + 1, temp.substring(i, i + 1).toUpperCase());
                tempList.add(uppercaseTemp);

            }

            for(StringBuilder temp : tempList){
                hashSet.add(temp);
            }
        }

        HashSet<String> hs = new HashSet<>();

        for(StringBuilder temp : hashSet){
            hs.add(temp.toString());
        }

        for(String temp : hs){
            list.add(temp);
        }


        return list;
    }

    public static void main(String[] args) {

        //String s = "a1b2";
        String s = "12345";
        //String s = "L2tcnhpZK";

        System.out.println(letterCasePermutation(s));

    }
}
