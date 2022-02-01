package backjoon;

import java.util.Scanner;

public class Q1780 {

    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    //모든 원소가 같은 숫자로 되어있는지 체크
    static boolean isSame(int[][] map, int x, int y, int size){

        int temp = map[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(temp != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    //분할정복하는 함수
    static void search(int[][]map, int x, int y, int size){

        //모든 원소가 다 같을 때 
        if(isSame(map, x, y, size)){
            if(map[x][y] == 0){
                zero++;
            }
            else if(map[x][y] == 1){
                plus++;
            }
            else if(map[x][y] == -1){
                minus++;
            }
            return ;
        }

        else{
            // 9등분으로 나누기
            size = size / 3;
            search(map, x, y, size);
            search(map, x, y+size, size);
            search(map, x, y+2*size, size);

            search(map, x+size, y, size);
            search(map, x+size, y+size, size);
            search(map, x+size, y+2*size, size);

            search(map, x+2*size, y, size);
            search(map, x+2*size, y+size, size);
            search(map, x+2*size, y+2*size, size);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        /*int[][] map = {
                {0, 0, 0, 1, 1, 1, -1, -1, -1},
                {0, 0, 0, 1, 1, 1, -1, -1, -1},
                {0, 0, 0, 1, 1, 1, -1, -1, -1},
                {1, 1, 1, 0, 0, 0, 0,   0,  0},
                {1, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, -1, 0, 1, -1, 0, 1, -1},
                {0, -1, 1, 0, 1, -1, 0, 1, -1},
                {0, 1, -1, 1, 0, -1, 0, 1, -1}
        };
*/
        // 입력값 셋팅
        int[][] map = new int[n][n];
        for(int i = 0; i < n ; i ++){
            String[] input = sc.nextLine().split(" ");
            for(int j = 0; j < n ; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        // 분할탐색 시작
        search(map, 0, 0, n);

        //결과값 출력
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
}
