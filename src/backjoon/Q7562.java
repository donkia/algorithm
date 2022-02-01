package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7562 {

    static int min;
    static int[] end;
    static int[] start;
    static int l;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String strT1 = sc.nextLine();
        int t = Integer.parseInt(strT1);
        //int t = sc.nextInt();
        int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};


        for (int k = 0; k < t; k++) {
            String strT2 = sc.nextLine();
            l = Integer.parseInt(strT2);

            String strT3 = sc.nextLine();
            String[] arrStr = strT3.split(" ");
            start = new int[]{Integer.parseInt(arrStr[0]), Integer.parseInt(arrStr[1])};

            String strT4 = sc.nextLine();
            arrStr = strT4.split(" ");
            end = new int[]{Integer.parseInt(arrStr[0]), Integer.parseInt(arrStr[1])};


            int[][] map = new int[l][l];

            min = l;
            int[][] visit = new int[l][l];
            //DFS(visit, map, 0, start[0], start[1]);


            Queue<int[]> queue = new LinkedList<>();

            int[] point = new int[]{0, start[0], start[1]};
            queue.add(point);
            visit[start[0]][start[1]] = 1;

            while (!queue.isEmpty()) {

                int[] temp = queue.poll();

                int cnt = temp[0];
                int i = temp[1];
                int j = temp[2];

                int x = end[0];
                int y = end[1];


                if (min < cnt)
                    continue;
                if (i == x && j == y) {
                    if (min > cnt)
                        min = cnt;
                    //System.out.println(cnt);
                    continue;
                }

                //System.out.println("(" + i + ", " + j + ") : " + cnt);

                for(int m = 0; m < 8; m ++){
                    int rc = i + dr[m];
                    int nc = j + dc[m];

                    if(rc<0 || rc>=l || nc < 0 || nc >= l || visit[rc][nc] == 1)
                        continue;

                    visit[rc][nc] = 1;
                    queue.add(new int[]{cnt + 1, rc, nc});

                }



            }

            System.out.println(min);


        }
    }


}
