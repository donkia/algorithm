package backjoon;

import java.util.*;

public class Q1260 {
    static ArrayList<Integer> al_dfs;
    static ArrayList<Integer> al_bfs;

    public static void DFS(int[][] arr, int start){
        ArrayList<Integer> sort = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {

            if (arr[i][0] == -1 || arr[i][1] == -1)
                continue;

            if (arr[i][0] == start) {
                sort.add(arr[i][1]);
                arr[i][0] = -1;
                arr[i][1] = -1;

            } else if (arr[i][1] == start) {
                sort.add(arr[i][0]);
                arr[i][0] = -1;
                arr[i][1] = -1;
            }
        }
        if(sort.size()>0){
            Collections.sort(sort);

            for(int i = 0; i < sort.size(); i++) {

                if (!al_dfs.contains(sort.get(i)))
                    al_dfs.add(sort.get(i));
                DFS(arr, sort.get(i));

            }
        }

    }

    public static void BFS(int[][] arr, int start){
        ArrayList<Integer> queue = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {

            if (arr[i][0] == -1 || arr[i][1] == -1)
                continue;

            if(arr[i][0] == start) {
                queue.add(arr[i][1]);
                arr[i][0] = -1;
                arr[i][1] = -1;
            }
            else if(arr[i][1] == start){
                queue.add(arr[i][0]);
                arr[i][0] = -1;
                arr[i][1] = -1;
            }
        }

        if(queue.size() > 0){
            Collections.sort(queue);

            for(int i = 0; i < queue.size(); i++) {

                if (!al_bfs.contains(queue.get(i)))
                    al_bfs.add(queue.get(i));
            }
            for(int i = 0; i < queue.size(); i++) {
                BFS(arr, queue.get(i));
            }

        }


        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        int[][] arr = new int[m][2];
        int[][] brr = new int[m][2];

        for(int i = 0 ; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[i][0] = x;
            arr[i][1] = y;
            brr[i][0] = x;
            brr[i][1] = y;

        }


        al_dfs = new ArrayList<>();
        al_bfs = new ArrayList<>();

        al_dfs.add(v);
        al_bfs.add(v);

        DFS(arr, v);
        for(int i = 0; i < al_dfs.size(); i++){
            System.out.print(al_dfs.get(i)+" ");
        }
        BFS(brr, v);
        System.out.println();

        for(int i = 0; i < al_bfs.size(); i++){
            System.out.print(al_bfs.get(i)+" ");
        }
    }
}
