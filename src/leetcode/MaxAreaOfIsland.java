package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/** 문제 : https://leetcode.com/problems/max-area-of-island/
 *  레벨 : Medium
 *  결과 : 해결(runtime 6ms faster than 26.45%, memory 50.6MB less than 5.07%)
 * */

public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){

                Queue<int[]> queue = new LinkedList<>();
                if(grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = 0;
                }
                int cnt = 0;
                while(!queue.isEmpty()){
                    cnt = cnt + 1;
                    int[] poll = queue.poll();
                    int x = poll[0];
                    int y = poll[1];

                    if(y < n-1){
                        if(grid[x][y+1] == 1) {
                            queue.add(new int[]{x, y+1});
                            grid[x][y+1] = 0;
                        }
                    }
                    if(y > 0){
                        if(grid[x][y-1] == 1) {
                            queue.add(new int[]{x, y-1});
                            grid[x][y-1] = 0;
                        }
                    }
                    if(x > 0){
                        if(grid[x-1][y] == 1) {
                            queue.add(new int[]{x-1, y});
                            grid[x-1][y] = 0;
                        }
                    }
                    if(x < m-1){
                        if(grid[x+1][y] == 1) {
                            queue.add(new int[]{x+1, y});
                            grid[x+1][y] = 0;
                        }
                    }
                }

                max = Math.max(max, cnt);
            }
        }

        return max;
    }


    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid));

    }


}
