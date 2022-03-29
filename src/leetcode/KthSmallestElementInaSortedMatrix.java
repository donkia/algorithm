package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * 문제 : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 레벨 : Medium
 * 결과 : 해결(runtime 17ms faster than 59.47%, memory 47.3MB less than 92.72%)
 */


public class KthSmallestElementInaSortedMatrix {


    public static int kthSmallest(int[][] matrix, int k) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                arrayList.add(matrix[i][j]);
            }
        }
        Collections.sort(arrayList);
        return arrayList.get(k - 1);

    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        for (int i = 1; i <= matrix.length * matrix.length; i++)
            System.out.println(i + " : " + kthSmallest(matrix, i));
    }
}
