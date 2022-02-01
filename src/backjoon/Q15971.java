package backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q15971 {

    public static void main(String[] args) {

        int n = 9;
        int start = 1;
        int end = 9;

        int[][] map = new int[n + 1][n + 1];

        map[1][2] = 8;
        map[2][1] = 8;

        map[2][3] = 6;
        map[3][2] = 6;

        map[2][4] = 5;
        map[4][2] = 5;

        map[2][5] = 10;
        map[5][2] = 10;

        map[9][5] = 6;
        map[5][9] = 6;

        map[6][5] = 14;
        map[5][6] = 14;

        map[6][7] = 7;
        map[7][6] = 7;

        map[8][6] = 7;
        map[6][8] = 7;

       // map[1][8] = 13;
        //map[8][1] = 13;


        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        int[] visit = new int[n + 1];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (map[start][i] != 0) {
                //queue.add(new int[]{i, map[start][i]});
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(map[start][i]);
                queue.add(temp);
                visit[i] = map[start][i];
                map[start][i] = 0;
                map[i][start] = 0;

            }
        }

        while (!queue.isEmpty()) {

            //int[] poll = queue.poll();
            ArrayList<Integer> poll = queue.poll();
            int destination = poll.get(0);
            int weight = poll.get(1);

            for (int i = 1; i <= n; i++) {
                if (map[destination][i] != 0) {

                    if (visit[i] != 0) {
                        visit[i] = Math.min(visit[destination] + weight + map[destination][i], visit[i]);
                        al.add(destination, poll);
                    } else
                        visit[i] = weight + map[destination][i];

                    poll.set(0, i);
                    poll.set(1, weight + map[destination][i]);
                    poll.add(i);
                    queue.add(poll);
                    map[destination][i] = 0;
                    map[i][destination] = 0;
                    poll.remove(poll.size() - 1);

                }
            }

        }

        System.out.println();


    }
}
