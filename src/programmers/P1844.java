package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P1844 {
    public static int solution(int[][] maps) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        maps[0][0] = 1;

        int m = maps.length;    // y
        int n = maps[0].length; // x
        int[][] visit = new int[m][n];
        visit[0][0] = 1;

        // 0,0 큐에 넣음
        queue.add(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            int distance = xy[2];

            if (x > 0) {
                if (maps[x - 1][y] == 1 && visit[x - 1][y] == 0) {
                    queue.add(new int[]{x - 1, y, distance + 1});
                    maps[x - 1][y] = distance + 1;
                    visit[x - 1][y] = 1;
                }
            }
            if (x + 1 < m) {
                if (maps[x + 1][y] == 1 && visit[x + 1][y] == 0) {
                    queue.add(new int[]{x + 1, y, distance + 1});
                    maps[x + 1][y] = distance + 1;
                    visit[x + 1][y] = 1;
                }
            }
            if (y > 0) {
                if (maps[x][y - 1] == 1 && visit[x][y - 1] == 0) {
                    queue.add(new int[]{x, y - 1, distance + 1});
                    maps[x][y - 1] = distance + 1;
                    visit[x][y - 1] = 1;
                }
            }

            if (y + 1 < n) {
                if (maps[x][y + 1] == 1 && visit[x][y + 1] == 0) {
                    queue.add(new int[]{x, y + 1, distance + 1});
                    maps[x][y + 1] = distance + 1;
                    visit[x][y + 1] = 1;
                }
            }
        }

        answer = maps[m - 1][n - 1];
        if (answer == 1 || answer == 0)
            return -1;

        return answer;
    }


    public static void main(String[] args) {

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 0, 1},
//                {0, 0, 0, 0, 1}
        };

        System.out.println(solution(maps));
    }
}
