package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/** 문제 : https://leetcode.com/problems/set-matrix-zeroes/
 *  레벨 : Medium
 *  결과 : 해결(runtime 2ms faster than 47.32%, memory 54MB less than 55.25%)
 * */

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i< matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){

            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for(int i = 0; i < matrix.length; i++){
                matrix[i][y] = 0;
            }
            for(int i = 0; i < matrix[0].length; i++){
                matrix[x][i] = 0;
            }

        }
        System.out.println(Arrays.toString(matrix));
    }

    public static void main(String[] args) {
        int[][] matrix = {
                /*{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}*/
                {0 ,1, 2, 0},
                {3 ,4, 5, 2},
                {1 ,3, 1, 5},

        };
        setZeroes(matrix);
    }
}
