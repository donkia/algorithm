package programmers;
import java.util.LinkedList;
import java.util.Queue;
/** 프로그래머스 '카카오 프렌즈 컬리링북' 문제(level2) [https://programmers.co.kr/learn/courses/30/lessons/1829]
 *  해결
 * */
public class P1829 {
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        // picture 배열을 copy해서 map이란 배열 사용
        int[][] map = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = picture[i][j];
            }
        }

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){

                if(map[i][j] == 0)
                    continue;
                // map의 특정 인덱스 값이 0이 아니면 큐에 넣고, 그 주위에 있는 데이터 확인
                else if(map[i][j] != 0) {
                    queue.add(new int[]{i, j, map[i][j]});
                    map[i][j] = 0;
                    numberOfArea ++;
                    maxSizeOfOneArea = 0;
                }
                // map[i][j]의 데이터와 일치한 인덱스를 찾기위해 queue 사용
                while(!queue.isEmpty()){
                    // map[i][j]와 같은 데이터가 몇개 있는지 확인
                    maxSizeOfOneArea = maxSizeOfOneArea + 1;
                    int[] poll = queue.poll();
                    int x = poll[0];
                    int y = poll[1];
                    int num = poll[2];

                    // 위, 아래, 왼쪽, 오른쪽 데이터 확인 후 map[i][j]와 데이터가 같으면 queue에 삽입
                    if(x > 0 && map[x-1][y] == num) {
                        queue.add(new int[]{x-1, y, num});
                        map[x-1][y] = 0;
                    }
                    if(x < map.length-1 && map[x+1][y] == num){
                        queue.add(new int[]{x+1, y, num});
                        map[x+1][y] = 0;
                    }
                    if(y > 0 && map[x][y-1] == num){
                        queue.add(new int[]{x, y-1, num});
                        map[x][y-1] = 0;
                    }
                    if(y < map[i].length-1 && map[x][y+1] == num){
                        queue.add(new int[]{x, y+1, num});
                        map[x][y+1] = 0;
                    }
                }
                if(max < maxSizeOfOneArea){
                    max = maxSizeOfOneArea;
                }
            }
        }
        int[] answer = new int[2];
        if(max == Integer.MIN_VALUE) max = 0;
        answer[0] = numberOfArea;
        answer[1] = max;
        //System.out.println(Arrays.toString(answer));
        return answer;
    }


    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        /*int[][] picture = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0 ,0 ,0, 1}
        };*/

        /*int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0 ,0 ,0, 3}
        };*/
        int[][] picture = {
                {1, 2 },
                {3, 4}
        };
        System.out.println(solution(m, n, picture));
    }
}
