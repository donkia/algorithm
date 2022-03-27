package programmers;

//100점
public class CodingTest_Q2_20220327 {

    static int[][] answer;
    public static void DFS(int start, int idx, int[][] signs, int n){
        for(int i = 0; i < n; i++){
            if(signs[idx][i] == 1 && answer[start][i] == 0){
                answer[start][i] = 1;
                DFS(start, i, signs, n);
            }
        }
    }


    public static int[][] solution(int n, int[][] signs){
        answer = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(signs[i][j] == 1 && answer[i][j] == 0 ){
                    answer[i][j] = 1;
                    DFS(i, j, signs, n);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*int n = 3;
        int[][] signs = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };*/

        /*int n = 3;
        int[][] signs = {
                {0, 0, 1},
                {0, 0, 1},
                {0, 1, 0}
        };*/
        int n = 3;
        int[][] signs = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        System.out.println(solution(n, signs));
    }

}
