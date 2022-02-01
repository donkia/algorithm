package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q15973 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 왼쪽아래 (x1, y1)
        // 오른쪽 위 꼭지점(x2, y2)
        // x1, y1, x2, y2

        // 1, 2, 3, 5
        // 3, 5, 8, 11

        String[] pointA = bufferedReader.readLine().split(" ");
        String[] pointB = bufferedReader.readLine().split(" ");

        int x1 = Integer.parseInt(pointA[0]);
        int y1 = Integer.parseInt(pointA[1]);

        int x2 = Integer.parseInt(pointA[2]);
        int y2 = Integer.parseInt(pointA[3]);

        int x3 = Integer.parseInt(pointB[0]);
        int y3 = Integer.parseInt(pointB[1]);

        int x4 = Integer.parseInt(pointB[2]);
        int y4 = Integer.parseInt(pointB[3]);

        //int min = Math.min(y2, Math.min(x2, Math.min(x1, y1)));

        if(x1 < 0 || x2 < 0 || x3 < 0 || x4 < 0){
            int min = Math.min(x1, Math.min(x2, Math.min(x3, x4)));
            x1 += (min*-1);
            x2 += (min*-1);
            x3 += (min*-1);
            x4 += (min*-1);
        }

        if(y1 < 0 || y2 < 0 || y3 < 0 || y4 < 0){
            int min = Math.min(y1, Math.min(y2, Math.min(y3, y4)));
            y1 += (min*-1);
            y2 += (min*-1);
            y3 += (min*-1);
            y4 += (min*-1);
        }

        int max = Math.max(y4, Math.max(x4, Math.max(x3, y3)));
        long[][] map = new long[max+1][max+1];
        ArrayList<Integer> al[] = new ArrayList[max+1];
        for(int i = 0; i <= max; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            al[i] = temp;
        }


        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                map[i][j] ++;
            }
        }



        for(int i = x3; i <= x4; i++){
            for(int j = y3; j <= y4; j++){
                map[i][j] ++;
            }
        }

        int cnt = 0;

        for(int i = 1; i <= max; i++){
            for(int j = 1; j <= max; j++){
                //System.out.print(map[i][j]);
            }
            //System.out.println();
        }

        for(int i = 1; i <= max; i++){
            for(int j = 1; j <= max; j++){
                if(map[i][j] > 1) {
                    cnt = cnt + 1;

                    if(map[i-1][j] > 1 && map[i+1][j] > 1 && map[i][j-1] > 1 && map[i][j+1] > 1){
                        System.out.println("FACE");
                        return;
                    }
                }
                //System.out.print(map[i][j]);
            }
            //System.out.println();
        }

        if(cnt == 0){
            System.out.println("NULL");
        }
        else if(cnt == 1){
            System.out.println("POINT");
        }

        else{
            System.out.println("LINE");
        }


    }
}
