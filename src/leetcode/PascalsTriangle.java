package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 : https://leetcode.com/problems/pascals-triangle/
 * 레벨 : Easy
 * 결과 : 해결(runtime 0ms faster than 100%, memory 39.9MB less than 59.50%)
 */

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);

        answer.add(firstList);

        for(int i = 2; i <= numRows; i++){
            List<Integer> insertList = new ArrayList<>();

            for(int j = 0; j < i; j++){
                if(j == 0 || j == i - 1){
                    insertList.add(1);
                }
                else{
                    int sum = answer.get(i - 2).get(j - 1) + answer.get(i - 2).get(j);
                    insertList.add(sum);
                }
            }
            answer.add(insertList);
        }

        return answer;
    }


    public static void main(String[] args) {
        int numRows = 30;
        System.out.println(generate(numRows
        ));
    }
}
