package backjoon;

import java.util.Scanner;

public class Q2630 {
    static int white;
    static int blue;

    static int colorCheck(int x, int y, int n, int[][]arr){
        int cnt = 0;

        for(int i = x; i < x +n; i ++){
            for(int j = y; j < y+ n; j++){
                cnt += arr[i][j];
            }
        }
        return cnt;
    }

    static public void search(int x, int y, int n, int[][]arr){

        int cnt = colorCheck(x, y, n, arr);
        if(cnt == 0){
            white ++;
            return ;
        }
        else if(cnt == n*n){
            blue++;
            return ;
        }
        else{
            n = n / 2;
            search(x, y, n, arr);
            search(x+n, y, n, arr);
            search(x, y+n, n, arr);
            search(x+n, y+n, n, arr);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] input = sc.nextLine().split(" ");
            for(int j = 0; j < n ; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        /*int[][] arr = {
                {1, 1, 0 ,0 ,0 ,0 , 1, 1},
                {1, 1, 0 ,0 ,0 ,0 , 1, 1},
                {0, 0, 0 ,0 ,1 ,1 , 0, 0},
                {0, 0, 0 ,0 ,1 ,1 , 0, 0},
                {1, 0, 0 ,0, 1 ,1 , 1, 1},
                {0, 1, 0 ,0, 1 ,1 , 1, 1},
                {0, 0, 1 ,1, 1 ,1 , 1, 1},
                {0, 0, 1 ,1, 1 ,1 , 1, 1}
        };
*/
        white = 0;
        blue = 0;
        search(0, 0, n, arr);

        System.out.println(white);
        System.out.println(blue);

    }


}
