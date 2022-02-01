package backjoon;

import javax.script.ScriptException;
import java.util.*;

public class Q2667 {
    static int[][] map;
    static int num = 1;

    public static void DFS(int x, int y) {
        if (map[x][y] == 1) {
            num = num + 1;
            map[x][y] = num;
        }

        if (x > 0)
            if (map[x - 1][y] == 1) {
                map[x - 1][y] = num;
                DFS(x - 1, y);
            }

        if (x < map.length - 1)
            if (map[x + 1][y] == 1) {
                map[x + 1][y] = num;

                DFS(x + 1, y);
            }
        if (y > 0)
            if (map[x][y - 1] == 1) {
                map[x][y - 1] = num;

                DFS(x, y - 1);
            }
        if (y < map.length - 1)
            if (map[x][y + 1] == 1) {
                map[x][y + 1] = num;
                DFS(x, y + 1);
            }


    }

    public static void main(String[] args) throws ScriptException {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        //int n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < temp.length(); j++) {
                String str = temp.substring(j, j + 1);
                map[i][j] = Integer.parseInt(str);
            }
        }
        /*map = new int[][]{
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0}
        };
        *//*System.out.println();
         */
  /*      System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
  */
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    DFS(i, j);
                }

            }

       /* for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
*/
        System.out.println(num - 1);
        int[] arr = new int[num - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = map[i][j];
                if (temp == 0) continue;
                arr[temp - 2]++;
            }
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
