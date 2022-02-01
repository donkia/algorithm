package backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14889 {

    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //초기값 셋팅
        String strn = sc.nextLine();
        n = Integer.parseInt(strn);
        int[] visit = new int[n];
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] arrLine = line.split(" ");

            for (int j = 0; j < arrLine.length; j++) {
                arr[i][j] = Integer.parseInt(arrLine[j]);
            }

        }

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            al.add(i);
            visit[i] = 1;
            //DFS(arr, al, visit, n);
            visit[i] = 0;
            al.remove(al.size() - 1);
        }

        //BFS를 통해 팀을 두개로 나눔
        //n = 8 일때 [1,2,3,4] , [5,6,7,8] / [1,2,3,5], [4,6,7,8] 등등
        Queue<ArrayList<Integer>> queue = new LinkedList<>();

        for (int i = 0; i < n / 2; i++) {
            ArrayList<Integer> alTemp = new ArrayList<>();
            alTemp.add(i);
            queue.add(alTemp);
        }
        while (!queue.isEmpty()) {

            ArrayList<Integer> team = queue.poll();
            int[] vis = new int[n];

            if (team.size() == n / 2) {

                ArrayList<Integer> oppteam = new ArrayList<>();

                for (int t : team) {
                    vis[t] = 1;
                }

                for (int i = 0; i < vis.length; i++) {
                    if (vis[i] == 0)
                        oppteam.add(i);
                }
                // 팀을 두개로 나눈 뒤 각 팀별로 점수 계산
                // ex) [1, 2, 3, 4] vs [5, 6, 7, 8]
                int teamScore = sumScore(team, arr, n / 2);
                int oppteamScore = sumScore(oppteam, arr, n / 2);

                if (min > Math.abs(teamScore - oppteamScore))
                    min = Math.abs(teamScore - oppteamScore);

                continue;
            }

            for (int v : team) {
                vis[v] = 1;
            }
            int lastNum = team.get(team.size() - 1);
            for (int i = lastNum + 1; i < n; i++) {

                if (vis[i] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>(team);
                    temp.add(i);
                    queue.add(temp);
                }

            }
        }
        System.out.println(min);
    }


    //팀별로 점수를 계산하는 부분. BFS로 구현
    static int sumScore(ArrayList<Integer> teamNum, int[][] arr, int m) {

        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        int sum = 0;

        for (int i = 0; i < m - 1; i++) {
            ArrayList<Integer> alTemp = new ArrayList<>();
            alTemp.add(teamNum.get(i));
            queue.add(alTemp);
        }

        //ex) [1, 2, 3, 4] vs [5, 6, 7, 8] 두팀이 대결할때
        //[1, 2, 3, 4] => [1, 2] , [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]로 나눠서 각각 합을 구함
        while (!queue.isEmpty()) {

            ArrayList<Integer> team = queue.poll();
            int[] vis = new int[m];

            // 두개로 됐을때 합을 구함
            if (team.size() == 2) {

                int x = team.get(0);
                int y = team.get(1);
                sum = sum + arr[x][y] + arr[y][x];
                continue;
            }

            int idx = 0;
            for (int v : team) {
                for (int i = 0; i < m; i++) {
                    if (v == teamNum.get(i)) {
                        vis[i] = 1;
                        idx = i;
                    }

                }
            }

            for (int i = idx + 1; i < m; i++) {

                if (vis[i] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>(team);
                    temp.add(teamNum.get(i));
                    queue.add(temp);
                }
            }
        }

        return sum;
    }
}
