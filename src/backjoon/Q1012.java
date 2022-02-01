package backjoon;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q1012 {
    static int[][] map;
    static int num;

    public static void DFS(int i, int j, int m, int n) {

        if (map[i][j] == 1) {
            num++;
            map[i][j] = num;
        }
        if (i > 0) {
            if (map[i - 1][j] == 1) {
                map[i - 1][j] = map[i][j];
                DFS(i - 1, j, m, n);
            }
        }
        if (i < n - 1) {
            if (map[i + 1][j] == 1) {
                map[i + 1][j] = map[i][j];
                DFS(i + 1, j, m, n);
            }
        }
        if (j > 0) {
            if (map[i][j - 1] == 1) {
                map[i][j - 1] = map[i][j];
                DFS(i, j - 1, m, n);
            }
        }
        if (j < m - 1) {
            if (map[i][j + 1] == 1) {
                map[i][j + 1] = map[i][j];
                DFS(i, j + 1, m, n);
            }
        }
    }

    public static void main(String[] args) throws ScriptException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int l = 0; l < t; l++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            map = new int[n][m];
            for (int a = 0; a < k; a++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;

            }
            num = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        continue;
                    } else {
                        DFS(i, j, m, n);
                    }
                }

            }
            al.add(num - 1);

        }
        for (int a : al) {
            System.out.println(a);
        }
    }
}
