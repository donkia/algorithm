package backjoon;

import javax.script.ScriptException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2206 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 6;
        int m = 4;

        int[][] arr = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 0}
        };

        int[][] map = new int[n][m];


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        map[0][0] = 1;
        arr[0][0] = -1;


        while (!queue.isEmpty()) {

            int x = queue.peek()[0];
            int y = queue.peek()[1];

            queue.poll();

            if (x > 0 && arr[x - 1][y] == 0) {
                map[x - 1][y] = map[x][y] + 1;
                queue.add(new int[]{x - 1, y});
                arr[x - 1][y] = -1;
            }

            // 벽일때
            if (x > 0 && arr[x - 1][y] == 1) {
                map[x - 1][y] = map[x][y] + 1;
                queue.add(new int[]{x - 1, y});
                arr[x - 1][y] = -1;
            }

            if (x < n - 1 && arr[x + 1][y] == 0) {
                map[x + 1][y] = map[x][y] + 1;
                queue.add(new int[]{x + 1, y});
                arr[x + 1][y] = -1;

            }

            if (y > 0 && arr[x][y - 1] == 0) {
                map[x][y - 1] = map[x][y] + 1;
                queue.add(new int[]{x, y - 1});
                arr[x][y-1] = -1;

            }

            if (y < m - 1 && arr[x][y + 1] == 0) {
                map[x][y + 1] = map[x][y] + 1;
                queue.add(new int[]{x, y + 1});
                arr[x][y+1] = -1;

            }

        }

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m ; j++){
                System.out.print(map[i][j] + "  ");

            }
            System.out.println( );

        }



    }
}
