package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Codingtest_Q2_20220224 {

    public static int[] solution(int N, int[][] relation) {
        int[] answer = new int[N];
        int[][] map = new int[N+1][N+1];
        boolean[][] visit = new boolean[N + 1][N + 1];

        for(int i = 0; i < relation.length; i++){

            int[] temp = relation[i];
            map[temp[0]][temp[1]] = 1;
            map[temp[1]][temp[0]] = 1;
        }


        for(int i = 1; i <= N; i++){
            Queue<int[]> queue = new LinkedList<>();
            for(int j = 1; j <= N; j++){

                if(map[i][j] == 1) {
                    queue.add(new int[]{i, j, 1});
                    visit[i][j] = true;
                }
            }
            int num = 0;
            while(!queue.isEmpty()){
                num = num + 1;
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                int cnt = poll[2];

                if(cnt >= 2){
                    continue;
                }

                for(int k = 1; k <= N; k++){

                    if(map[y][k] == 1 && i != k && visit[i][k] == false) {
                        queue.add(new int[]{y, k, cnt + 1});
                        visit[i][k] = true;
                    }
                }
            }
            answer[i - 1] = num;
        }
        //System.out.println(Arrays.toString(answer));

        return answer;

    }

/*

        for(int i = 1; i <= N; i++){

            for(int j = 1; j <= N; j++){

                if(i == j) continue;

                if(map[i][j] == 1 && visit[i][j] == false){
                    answer[i-1]++;
                    visit[i][j] = true;



                    for(int k = 1; k <= N; k++){

                        if(i == k) continue;
                        if(map[j][k] == 1 && visit[i][k] == false){
                            answer[i-1]++;
                            visit[i][k] = true;
                        }
                    }

                }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
*/

    public static void main(String[] args) {

        /*int[][] relation = {
                {1, 2},
                {4, 2},
                {3, 1},
                {4, 5}
        };

        int N = 5;*/

        /*int[][] relation = {
                {1, 2},
                {4, 2},
                {3, 1},
                {4, 5},
                {6, 7}
        };

        int N = 7;*/

        /*int[][] relation = {
                {1, 2},
                {4, 2},
                {3, 1},
                {4, 5},
                {6, 7},
                {2, 6},
                {5, 7}
        };

        int N = 7;*/

        int[][] relation = {

                {1, 5},
                {1, 2},{3, 2},{2, 4},{1, 4}
                ,{2, 5},{3, 1}, {3, 6}, {4, 6}

        };

        int N = 6;

        System.out.println(solution(N, relation));


    }

}
