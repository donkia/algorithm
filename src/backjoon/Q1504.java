package backjoon;

import java.util.*;


public class Q1504 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 4;
        int e = 6;

        int[][]map = new int[n+1][n+1];
        int[] distacne = new int[n + 1];
        Arrays.fill(distacne, 2000);

        map[1][2] = 3;
        map[2][1] = 3;

        map[2][3] = 3;
        map[3][2] = 3;

        map[3][4] = 1;
        map[4][3] = 1;

        map[1][3] = 5;
        map[3][1] = 5;

        map[2][4] = 5;
        map[4][2] = 5;

        map[1][4] = 4;
        map[4][1] = 4;

        map[2][3] = -2000;
        map[3][2] = -2000;

        Queue<ArrayList<Integer>> queue = new LinkedList<>();

        //queue.add(new int[]{1, 0});
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(0);

        queue.add(temp);
        int[] visit = new int[n + 1];

        while(!queue.isEmpty()){

            ArrayList<Integer> arr = queue.poll();
            int next = arr.get(0);
            int sum = arr.get(1);

            //if(distacne[next] < 0) visit[next] = 1;

            for(int i = 2; i <= n; i++){

                if(map[next][i] != 0 && distacne[i] > sum+map[next][i]  ){

                    distacne[i] = Math.min(sum + map[next][i], distacne[i]);
                    ArrayList<Integer> al = new ArrayList<>();


                    // queue.add(new int[]{i, sum + map[next][i]});
                }
            }

        }
        /*for(int temp : distacne)
            System.out.print(temp + " ");
*/

    }


}