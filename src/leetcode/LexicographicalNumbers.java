package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 문제 : https://leetcode.com/problems/lexicographical-numbers/
 * 레벨 : Medium
 * 결과 : 해결(RUNTIME 22MS FASTER THAN 16.76%, MEMORY 48.9MB LESS THAN 73.32%)
 */

public class LexicographicalNumbers {

    public static List<Integer> lexicalOrder(int n) {


        List<Integer> answer = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        // 숫자를 String 으로 변환
        for(int i = 1; i <= n; i++){
            stringList.add(Integer.toString(i));
        }
        //String 배열 sort
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else{
                    if(o1.charAt(0) == o2.charAt(0)){
                        return o1.compareTo(o2);
                    }
                    else{
                        return o1.substring(0,1).compareTo(o2.substring(0, 1));
                    }
                }
            }
        });

        for(String s : stringList){
            answer.add(Integer.parseInt(s));
        }
        //System.out.println(stringList);
        return answer;
    }


    public static void main(String[] args) {

        int n = 5*10*10*10*10;
        System.out.println(lexicalOrder(n));

    }
}
