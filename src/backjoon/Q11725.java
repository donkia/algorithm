package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Q11725 {

    static int[] visit;
    static int[] header;

    public static void DFS(ArrayList<Integer>[] al, int i) {

        ArrayList<Integer> num = al[i];

        for (int next : num) {

            if (next == 1) continue;

            if (visit[next] == 0) {

                header[next] = i;
                visit[next] = i;
                DFS(al, next);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //int n = 7;
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n + 1];

        visit = new int[n + 1];
        header = new int[n + 1];

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();

        ArrayList<Integer>[] al = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            al[x].add(y);
            al[y].add(x);
        }
/*

        al[1].add(6);
        al[6].add(1);

        al[6].add(3);
        al[3].add(6);

        al[3].add(5);
        al[5].add(3);

        al[4].add(1);
        al[1].add(4);

        al[2].add(4);
        al[4].add(2);

        al[4].add(7);
        al[7].add(4);
*/

        DFS(al, 1);

        /*int cnt = 0;
        for(ArrayList<Integer> al_temp : al) {
            System.out.println(cnt + ": " + al_temp);
            cnt ++;
        }*/

        for (int i = 2; i < header.length; i++)
            System.out.println(header[i]);
    }
}
