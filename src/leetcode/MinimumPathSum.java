package leetcode;

/**
 * 문제 : https://leetcode.com/problems/minimum-path-sum/
 * 레벨 : Medium
 * 결과 : 해결(runtime 2ms faster than 87.84%, memory 45.4MB less than 76.60%)
 */

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] map = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){


                if(i == 0 && j == 0){
                    map[i][j] = grid[i][j];
                }

                else if(i == 0){
                    map[i][j] = map[i][j-1] + grid[i][j];
                }

                else if(j == 0){
                    map[i][j] = map[i-1][j] + grid[i][j];
                }
                else{
                    map[i][j] = Math.min(map[i - 1][j], map[i][j - 1]) + grid[i][j];
                }
            }
        }
        return map[m-1][n-1];
    }


    public static void main(String[] args) {
        int[][] grid = {
               /* {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}*/
                {1, 2,3},
                {4, 5, 6}
        };
        System.out.println(minPathSum(grid));
    }


}
