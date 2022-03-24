package leetcode;

/** 문제 : https://leetcode.com/problems/unique-paths-ii/
 *  레벨 : Medium
 *  결과 : 참고 후 해결(runtime 1ms faster than 55.92%, memory 41.6MB less than 70.03%)
 * */


public class UniquePaths2 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] map = new int[obstacleGrid.length][obstacleGrid[0].length];


        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){

                if(obstacleGrid[i][j] == 1){
                    map[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    map[i][j] = 1;
                }
                else if(i == 0){
                    map[i][j] = map[i][j - 1];
                }
                else if(j == 0){
                    map[i][j] = map[i-1][j];
                }
                else{
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }


        return map[map.length-1][map[0].length-1];


    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
               /* {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}*/
/*
                {0 ,0 ,0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
*/
/*
                {0, 0},
                {1, 1},
                {0, 0}
*/
                /*{0}*/
/*
                {1, 0}
*/
                {0, 0},
                {1, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
