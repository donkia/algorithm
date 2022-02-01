package backjoon;

import java.util.Scanner;
public class Q1992 {
    static StringBuilder answer = new StringBuilder();
    // 전부다 0인지 1인지 체크
    static int check(int x, int y, int size, int[][] map){

        int cnt = 0;

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                cnt += map[i][j];
            }
        }
        return cnt;
    }

    static void search(int x, int y, int size, int[][] map, int last){
        int cnt = check(x, y, size, map);
        if(cnt == 0){
            answer.append("0");
        }
        else if(cnt == size * size){
            answer.append("1");
        }
        else{
            answer.append("(");
            size = size / 2;
            //1사분면, 2사분면, 3사분면, 4사분면 차례대로 재귀
            search(x, y, size, map, 0);
            search(x, y+size, size, map, 0);
            search(x+size, y, size, map, 0);
            search(x+size, y+size, size, map, 1);
            
            answer.append(")");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //입력값 셋팅
        int n = Integer.parseInt(sc.nextLine());
        int[][] map = new int[n][n];

        for(int i = 0; i < n ; i++){
            String input = sc.nextLine();
            for(int j = 0; j < n; j ++){
                map[i][j] = Integer.parseInt(input.substring(j, j +1));
            }
        }
        /*int[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
        };/
        /*int[][] map = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 1}

        };*/
        
        //분할정복 시작
        search(0, 0, n, map, 0);
        System.out.println(answer);




    }
}
