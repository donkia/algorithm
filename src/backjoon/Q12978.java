package backjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q12978 {

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        int[][] map = new int[N + 1][N + 1];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < road.length; i++) {
            int[] arr = road[i];

            if (map[arr[0]][arr[1]] != 0) {
                int min = Math.min(map[arr[0]][arr[1]], arr[2]);
                map[arr[0]][arr[1]] = min;
                map[arr[1]][arr[0]] = min;
            } else {
                map[arr[0]][arr[1]] = arr[2];
                map[arr[1]][arr[0]] = arr[2];
            }
        }
        //시작점이 1이므로 큐에 1을 넣는다.
        queue.add(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int x = next[0];
            int sum = next[1];

            for (int i = 1; i <= N; i++) {
                //if문 안에 visit을 비교하는게 아니라 최소값이면 큐에 넣는 방식으로 구현
                if (map[x][i] != 0) {
                    if (sum + map[x][i] < distance[i]) {

                        distance[i] = Math.min(distance[i], sum + map[x][i]);
                        queue.add(new int[]{i, sum + map[x][i]});
                    }
                }
            }

        }
        for (int i = 1; i <= N; i++) {
            System.out.print(distance[i] + " ");
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] road = {
                {1, 2, 10},
                {1, 3, 1},
                {3, 4, 1},
                {4, 5, 1},
                {5, 2, 1},

        };

        int n = 5;
        int k = 3;

        /*int[][] road = {
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 3},
                {3, 5, 2},
                {3, 5, 3},
                {5, 6, 1}
        };

        int n = 6;
        int k = 4;
        */
        System.out.println("answer : " + solution(n, road, k));

    }
}
