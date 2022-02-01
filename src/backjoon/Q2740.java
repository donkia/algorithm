package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //행렬A 값 셋팅
        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        //행렬B 값 셋팅
        input = bufferedReader.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[][] arr_b = new int[m][k];

        for (int i = 0; i < m; i++) {
            String[] temp = bufferedReader.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                arr_b[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int[][] result = new int[n][k];
        //행렬의 곱셈 구하기
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {

                for (int l = 0; l < arr_b[0].length; l++) {
                    int a = arr[i][j];
                    int b = arr_b[j][l];

                    result[i][l] += a * b;
                }
            }
        }

        //결과값 출력
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}