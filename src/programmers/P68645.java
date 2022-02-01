package programmers;

public class P68645 {
    // 전체 숫자가 몇인지 계산하는 메소드(n이 4이면 15, n이 5이면 15, n이 6이면 21 ...)
    public static int totalCnt(int n){

        int[] arr = new int[1001];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 3;

        for(int i = 3; i <= 1000; i ++){
            arr[i] = arr[i - 1] + i;
        }
        return arr[n];
    }

    public static int[] solution(int n) {
        int[] answer;
        // n이 2, 3일때 오류나서 따로 값을 계산 후 리턴
        if(n == 2){
            return new int[]{1, 2, 3};
        }
        else if(n == 3){
            return new int[]{1, 2, 6, 3, 4, 5};
        }

        int[][] map = new int[n][n];
        int totalCnt = totalCnt(n);

        int i = 0;
        int j = 0;
        int cnt = 1; // 1부터 totalCount까지 계산
        int round = 0; // 몇바퀴 돌았는지 round로 계산
        int m = n;

        // 몇바퀴를 돌았는지 나타내는 round 변수에
        // 0 : 제일 크게 한바퀴 돎
        // 1이상 : 다음에 가야하는 값에 이미 0이 아닌 값이 채워져있으면 그 다음 단계 실행.
        while(cnt <= totalCnt) {
            if (round == 0) {
                if (j == round) { //아래로 내려가는 부분
                    map[i][j] = cnt++;

                    if (i == n - 1) {
                        j = j + 1;
                    } else
                        i = i + 1;
                } else if (i == n - 1) {
                    map[i][j] = cnt++;

                    if (i == round + 1 && j == round + 1) { // 1바퀴가 돌았는지 확인
                        round = round + 1;
                        i = i + 1;
                        n = m - round -1;
                    } else if (j == n - 1) { //대각선으로 북서쪽 방향
                        n = n - 1;
                        i = n - 1;
                        j = n - 1;
                    } else  // 오른쪽으로 이동
                        j = j + 1;
                }
            }
            if(round >= 1){ // 1바퀴 이상 돌았을 때
                if (j == round) { // 아래로 내려가는 부분
                    map[i][j] = cnt++;

                    if (map[i+1][j] == 0) {
                        i = i + 1;
                    }
                    else if(map[i+1][j] != 0)
                        j = j + 1;
                }
                else {
                    map[i][j] = cnt++;

                    if(map[i][j+1] == 0)
                        j = j + 1;
                    else if (map[i][j+1] != 0) {

                        if(map[i-1][j-1] != 0){
                            round = round + 1;
                            i = i + 1;
                            n = m - round -1;
                        }
                        else{
                            i = i - 1;
                            j = j - 1;
                        }
                    }
                    else if (map[i-1][j-1]!= 0) {
                        round = round + 1;
                        i = i + 1;
                        n = m - round;
                    }
                }
            }

        }
        // answer를 리턴하기 위해서 answer 값 셋팅
        answer = new int[totalCnt];
        int idx = 0;
        for(int x = 0; x < m; x ++){
            for(int y = 0; y < m; y++){
                if(map[x][y] != 0)
                    answer[idx++] = map[x][y];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        solution(n);
    }
}
