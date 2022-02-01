package programmers;
import java.util.Arrays;
/** 프로그래머스 행렬 테두리 회전하기(level 2)
 * https://programmers.co.kr/learn/courses/30/lessons/77485
 * 문제 해결 완료(+1점)
 * */
public class P77485 {

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1]; // 행렬을 나타낼 n*n 행렬
        int[][] tempMap = new int[rows + 1][columns + 1]; // map을 copy한 임시 n*n 행렬

        int cnt = 1;
        // 행렬 map 과 tempMap에 초기값 셋팅
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = cnt;
                tempMap[i][j] = cnt;
                cnt = cnt + 1;
            }
        }

        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int x1 = query[0];
            int y1 = query[1];

            int x2 = query[2];
            int y2 = query[3];

            // (x1,y1) -> (x2, y2) 까지 돌면서 회전시킴
            int minNum = Integer.MAX_VALUE;
            for(int j = x1; j <= x2; j++){
                for(int k = y1; k <= y2; k++){

                    if(map[j][k] != tempMap[j][k]){
                        if(minNum > map[j][k]){
                            minNum = map[j][k];
                        }
                        continue;
                    }

                    if(j == x1){
                        // 첫번째 꼭지점에 도달(x1, y1)
                        if(k == y1){
                            map[j][k] = tempMap[j + 1][k];

                        }
                        // 두번째 꼭지점에 도달(x1, y2)
                        else if(k == y2){
                            map[j][k] = tempMap[j][k - 1];
                            map[j + 1][k] = tempMap[j][k];
                        }
                        // 테두리의 맨 위를 지날 때
                        else{
                            map[j][k] = tempMap[j][k - 1];
                        }
                    }
                    else if(j == x2){
                        // 세번째 꼭지점에 도달(x2,y1)
                        if(k == y1){
                            map[j][k] = tempMap[j][k+1];
                        }
                        // 네번째 꼭지점에 도달(x2,y2)
                        else if(k == y2){
                            map[j][k] = tempMap[j - 1][k];
                        }
                        // 테두리의 맨 아래를 지날 때
                        else{
                            map[j][k] = tempMap[j][k + 1];
                        }
                    }
                    else{
                        // 테두리의 왼쪽, 오른쪽 변을 지날 때
                        if(k == y1 || k == y2){
                            if(k == y1)
                                map[j][k] = tempMap[j + 1][k];
                            else
                                map[j][k] = tempMap[j - 1][k];
                        }
                        // 그 외 나머지. 회전이 일어나지 않는다.
                        else{
                            continue;
                        }
                    }
                    // 회전하는 값 중 최소값을 구함
                    if(minNum > map[j][k]){
                        minNum = map[j][k];
                    }
                }
            }
            // 회전이 끝나면 최소값 대입
            answer[i] = minNum;
            // 회전이 끝나고 tempMap 값을 셋팅
            for (int j = 1; j <= rows; j++) {
                for (int k = 1; k <= columns; k++) {
                    tempMap[j][k] = map[j][k];
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
/*

        int rows = 6;
        int columns = 6;
        int[][] queries = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        };
*/

        int rows = 3;
        int columns = 3;
        int[][] queries = {
                {1, 1, 2, 2},
                {1, 2, 2, 3},
                {2, 1, 3, 2},
                {2, 2, 3, 3}
        };

        System.out.println(solution(rows, columns, queries));

    }

}
