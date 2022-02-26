package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 문제 : https://leetcode.com/problems/interval-list-intersections/
 * 레벨 : Medium
 * 결과 : 해결(runtime 33ms faster than 5.29%, memory 54.6MB less than 25.01%)
 */

public class IntervalListIntersections {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        ArrayList<int[]> answer = new ArrayList<>();
        for(int i = 0; i < secondList.length ; i++){
            int secondStart = secondList[i][0];
            int secondEnd = secondList[i][1];

            for(int j = 0; j < firstList.length; j++){

                int firstStart = firstList[j][0];
                int firstEnd = firstList[j][1];

                if(firstStart<= secondStart && secondStart <= firstEnd){

                    if(secondEnd >= firstEnd) {
                        answer.add(new int[]{secondStart, firstEnd});
                    }
                    else if(secondEnd <= firstEnd){
                        answer.add(new int[]{secondStart, secondEnd});
                    }

                }

                else if(firstStart<= secondEnd && secondEnd <= firstEnd){

                    if(secondEnd >= firstStart) {
                        answer.add(new int[]{firstStart, secondEnd});
                    }


                }

                else if(secondStart <= firstStart && firstEnd <= secondEnd){
                    answer.add(new int[]{firstStart, firstEnd});

                }
                else
                    continue;
            }


        }

        int[][] output = new int[answer.size()][2];
        int idx = 0;
        for(int[] arr : answer){
            output[idx][0] = arr[0];
            output[idx][1] = arr[1];
            idx++;
        }


        return output;


    }

    public static void main(String[] args) {

        /*int[][] firstList = {
                {0,2},{5,10},{13,23},{24,25}
        };

        int[][] secondList = {
                {1,5},{8,12},{15,24},{25,26}
        };*/

        int[][] firstList = {
                {4,6},{7,8},{10,17}
        };

        int[][] secondList = {
                {5, 10}
        };


        System.out.println(intervalIntersection(firstList, secondList));

    }


}
