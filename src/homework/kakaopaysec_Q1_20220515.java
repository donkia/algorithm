package homework;

import java.util.ArrayList;

public class kakaopaysec_Q1_20220515 {


    public static ArrayList<Integer> solution(int row, int col, int[][] map) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int x = 0;  // x 좌표
        int y = 0;  // y 좌표

        int lastRow = row - 1;      //마지막 x 좌표
        int lastCol = col - 1;      //마지막 y 좌표
        Boolean isDown = true; //대각선 방향으로 내려오는 경우면 true, 대각선 방향으로 올라가는 경우이면 false

        while (!(x == lastRow && y == lastCol)) {
            arrayList.add(map[x][y]);
            //맨 첫번째 행일 경우
            if (x == 0) {

                if (y == 0) {
                    y = y + 1;
                    isDown = true;
                }
                // ↗ 로 이동
                else if (x - 1 > 0 && y + 1 <= lastCol) {
                    x = x - 1;
                    y = y + 1;
                    isDown = false;
                }
                // → 로 이동
                else if (y + 1 <= lastCol && isDown == false) {
                    y = y + 1;
                    isDown = true;
                }
                // ↓ 로 이동
                else if (x + 1 <= lastRow && isDown == false) {
                    x = x + 1;
                    isDown = true;
                }
                // ↙ 로 이동
                else {
                    x = x + 1;
                    y = y - 1;
                    isDown = true;
                }
            }
            // 마지막 행일 경우
            else if (x == lastRow) {
                // ↙ 로 이동
                if (x + 1 <= lastRow && y - 1 > 0) {
                    x = x + 1;
                    y = y - 1;
                    isDown = true;
                }
                // ↓ 로 이동
                else if (x + 1 <= lastRow) {
                    x = x + 1;
                    isDown = false;
                }

                // → 로 이동
                else if (y + 1 <= lastCol && isDown == true) {
                    y = y + 1;
                    isDown = false;
                }
                // ↗ 로 이동
                else {
                    x = x - 1;
                    y = y + 1;
                    isDown = false;
                }
            } 
            // 첫번째 열(col)일 경우
            else if (y == 0) {
                if (isDown == true) {
                    x = x + 1;
                    isDown = false;
                } else if (isDown == false) {
                    x = x - 1;
                    y = y + 1;
                }
            } 
            // 마지막 열일 경우
            else if (y == lastCol) {
                if (isDown == false) {
                    x = x + 1;
                    isDown = true;
                } else if (isDown == true) {
                    x = x + 1;
                    y = y - 1;
                }
            } 
            // 그 외 나머지일 경우
            else {
                if (isDown == true) {
                    x = x + 1;
                    y = y - 1;
                } else if (isDown == false) {
                    x = x - 1;
                    y = y + 1;
                }
            }

        }
        arrayList.add(map[lastRow][lastCol]);

        return arrayList;
    }


    public static void main(String[] args) {
        String input = "1,2,3,4,5,6,7,8,9"; //배열 데이터
        int row = 3;   //가로열
        int col = 3; // 세로열
        int[][] map = new int[row][col];

        int cnt = 0;
        String[] split = input.split(",");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                map[i][j] = Integer.parseInt(split[cnt++]);
            }
        }
        System.out.println(solution(row, col, map)); //정답 출력
    }

}
