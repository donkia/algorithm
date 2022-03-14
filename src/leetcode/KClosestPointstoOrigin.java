package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 문제 : https://leetcode.com/problems/k-closest-points-to-origin/
 * 레벨 : Medium
 * 결과 : 해결(runtime 59ms faster than 38.96%, memory 116.1MB less than 45.57%)
 */


public class KClosestPointstoOrigin {

    public static int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double doubleO1 = Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]);
                double doubleO2 = Math.sqrt(o2[0] * o2[0] + o2[1] * o2[1]);

                if(doubleO1 >= doubleO2){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });




        for(int i = 0; i < k; i++){
            answer[i] = points[i];
        }

        System.out.println(answer.toString());
        return answer;
    }

    public static void main(String[] args) {
        int[][] point = {
               /* {1, 3},
                {-2, 2}*/
                {3,3},
               /* {5,-1},
                {-2,4},
                {-3,-3}*/
        };
        int k = 1;

        System.out.println(kClosest(point, k).toString());
    }
}
