package backjoon;

import java.util.ArrayList;

public class Q14002 {

    public static void main(String[] args) {

        int n = 7;
        int[] arr ;
        //arr = new int[]{10, 20, 10, 40, 20, 50};
        arr = new int[]{10, 5, 11, 7, 10, 8, 40};


        /*
        int[][] temp = new int[3][n];


        ArrayList[][] map = new ArrayList[3][n];
        for(int i = 0; i < n; i++){
            map[0][i] = new ArrayList();
            map[1][i] = new ArrayList();
            map[2][i] = new ArrayList();
        }

        temp[0][0] = arr[0];
        temp[1][0] = 0;
        temp[2][0] = arr[0];

        map[0][0].add(arr[0]);
        map[1][0].add(0);
        map[2][0].add(arr[0]);


        for(int i = 1; i < n; i ++){

            int num = arr[i];

            temp[0][i] = arr[i];
            map[0][i].add(arr[i]);


            temp[1][i] = Math.max(Math.max(temp[0][i - 1], temp[1][i - 1]), temp[2][i - 1]);


            if(num > arr[i-1]){
                temp[2][i] = temp[1][i] + num;

            }
            else {
                temp[2][i] = temp[1][i];
            }

        }

        System.out.println();
        */

        ArrayList[][] su = new ArrayList[n][];

        for(int i = 0; i < n; i++){

            int num = 0;

            for(int j = i+1; j < n; j++){



            }




        }
    }
}
