package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/** 문제 : https://leetcode.com/problems/rotting-oranges/
 *  레벨 : Medium
 *  결과 : 해결(runtime 4ms faster than 53.23%, memory 43.7MB less than 5.33%)
 * */

public class RottingOranges {

    public static int getMaxNum(int[][] grid){

        int max = 0;
        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j <grid[0].length; j++){

                if(grid[i][j] == 10000)
                    continue;

                if (max < grid[i][j]) {
                    max = grid[i][j];
                }
            }
        }

        return max;
    }

    public static boolean isClean(int[][] grid){
        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j <grid[0].length; j++){

                if(grid[i][j] >=1)
                    return  false;
            }
        }
        return true;
    }

    public static int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] map = new int[m][n];


        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){

                map[i][j] = 10000;

                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j , 0});
                    grid[i][j] = -1;
                    map[i][j] = 0;
                }
            }
        }

        while(!queue.isEmpty()){

            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int num = poll[2];
            grid[x][y] = -1;

            if(x < m-1){
                if(grid[x+1][y] == 1 || grid[x+1][y] == -1) {

                    if(map[x+1][y] > num+1) {
                        queue.add(new int[]{x + 1, y, num + 1});
                        map[x + 1][y] = num + 1;
                    }
                }
            }

            if(y < n-1){
                if(grid[x][y+1] == 1 || grid[x][y+1] == -1) {

                    if(map[x][y+1] > num+1) {
                        queue.add(new int[]{x, y+1, num + 1});
                        map[x][y+1] = num + 1;
                    }
                }
            }

            if(x > 0){
                if(grid[x-1][y] == 1 || grid[x-1][y] == -1) {

                    if(map[x-1][y] > num+1) {
                        queue.add(new int[]{x-1, y, num + 1});
                        map[x-1][y] = num + 1;
                    }
                }
            }

            if(y > 0){
                if(grid[x][y-1] == 1|| grid[x][y-1] == -1) {

                    if(map[x][y-1] > num+1) {
                        queue.add(new int[]{x, y-1, num + 1});
                        map[x][y-1] = num + 1;
                    }
                }
            }
        }

        return isClean(grid)?getMaxNum(map):-1;
    }

    public static void main(String[] args) {

        int[][] grid = {
                /*{2,1,1},
                {1,1,0},
                {0,1,1}*/
                {1,2}
        };
        System.out.println(orangesRotting(grid));
    }
}
