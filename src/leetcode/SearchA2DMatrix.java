package leetcode;

import java.util.ArrayList;

/** 문제 : https://leetcode.com/problems/search-a-2d-matrix/
 *  레벨 : Medium
 *  결과 : 해결(runtime 1ms faster than 33.76%, memory 43.3MB less than 6.52%)
 * */

public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                arrayList.add(matrix[i][j]);
            }
        }
        return arrayList.contains(target) ? true : false;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        };

        int target = 3;

        System.out.println(searchMatrix(matrix, target));

    }
}
