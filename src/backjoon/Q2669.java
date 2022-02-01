package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Q2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[4][4];
        for(int i = 0; i < 4; i++){
            String[] input = bufferedReader.readLine().split(" ");
            for(int j = 0; j < 4; j ++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        int sum = 0;
        int[][] arr = new int[101][101];
        for(int i = 0; i < 4; i ++){
            int x1 = map[i][0];
            int x2 = map[i][2];

            int y1 = map[i][1];
            int y2 = map[i][3];

            int minX = Math.min(x1, x2);
            int maxX = Math.max(x1, x2);
            int minY = Math.min(y1, y2);
            int maxY = Math.max(y1, y2);
            sum = sum + (x2 - x1) * (y2 - y1);
            for(int j = minX ; j < maxX; j++){
                for(int k = minY; k < maxY; k++){
                    arr[j][k]++;
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i <=8; i++){
            for(int j = 0; j<= 8; j++){
                if(arr[i][j] != 0)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}