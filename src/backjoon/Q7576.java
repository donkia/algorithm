package backjoon;

import javax.script.ScriptException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {

    public static void main(String[] args) throws ScriptException {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {

            int x = queue.peek()[0];
            int y = queue.peek()[1];

            if (cnt < map[x][y]) {
                cnt = map[x][y];
            }
            queue.poll();

            if (x > 0 && map[x - 1][y] == 0) {
                map[x - 1][y] = map[x][y] + 1;
                queue.add(new int[]{x - 1, y});

            }
            if (x < n - 1 && map[x + 1][y] == 0) {
                map[x + 1][y] = map[x][y] + 1;
                queue.add(new int[]{x + 1, y});

            }
            if (y > 0 && map[x][y - 1] == 0) {
                map[x][y - 1] = map[x][y] + 1;
                queue.add(new int[]{x, y - 1});

            }
            if (y < m - 1 && map[x][y + 1] == 0) {
                map[x][y + 1] = map[x][y] + 1;
                queue.add(new int[]{x, y + 1});
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    cnt = -1;
                    System.out.println(cnt);
                    return;
                }
            }
        }
        System.out.println((cnt - 1));
    }
}
