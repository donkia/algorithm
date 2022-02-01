package backjoon;

import javax.script.ScriptException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {
    public static int cnt = 0;
    public static void DFS(int i, int j, int num, int n, int m, int[][] arr) {

        if (num > cnt) {
            return;
        }
        if (i == n - 1 && j == m - 1) {
            // System.out.println(num);
            if (num < cnt) {
                cnt = num;
            }
            return;
        }

        if ((i > 0) && (arr[i - 1][j] == 1)) {
            arr[i][j] = 0;
            DFS(i - 1, j, num + 1, n, m, arr);
            arr[i][j] = 1;
        }
        if ((i < n - 1) && (arr[i + 1][j] == 1)) {
            arr[i][j] = 0;
            DFS(i + 1, j, num + 1, n, m, arr);
            arr[i][j] = 1;
        }

        if ((j > 0) && (arr[i][j - 1] == 1)) {
            arr[i][j] = 0;
            DFS(i, j - 1, num + 1, n, m, arr);
            arr[i][j] = 1;
        }

        if ((j < m - 1) && (arr[i][j + 1] == 1)) {
            arr[i][j] = 0;
            DFS(i, j + 1, num + 1, n, m, arr);
            arr[i][j] = 1;
        }


    }

    public static void main(String[] args) throws ScriptException {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] s = str1.split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        // sc.nextLine();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }

        }
        //DFS(0, 0, 1, n, m, arr);


        int[][] visit = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int sum = 1;
        visit[0][0] = 1;
        while (!q.isEmpty()) {

            int i = q.peek()[0];
            int j = q.peek()[1];
            q.poll();


            if ((i > 0) && (arr[i - 1][j] == 1)) {
                q.offer(new int[]{i - 1, j});
                visit[i-1][j] = visit[i][j] + 1;
                arr[i-1][j] = 0;
            }
            if ((i < n - 1) && (arr[i + 1][j] == 1)) {
                q.offer(new int[]{i + 1, j});
                visit[i+1][j] = visit[i][j] + 1;
                arr[i+1][j] = 0;

            }

            if ((j > 0) && (arr[i][j - 1] == 1)) {
                q.offer(new int[]{i, j - 1});
                visit[i][j-1] = visit[i][j] + 1;
                arr[i][j-1] = 0;

            }

            if ((j < m - 1) && (arr[i][j + 1] == 1)) {
                q.offer(new int[]{i, j + 1});
                visit[i][j+1] = visit[i][j] + 1;
                arr[i][j+1] = 0;

            }


        }

       System.out.println(visit[n - 1][m - 1]);


    }


}
