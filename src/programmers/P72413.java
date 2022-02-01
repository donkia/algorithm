package programmers;

public class P72413 {
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < fares.length; i++) {
            int[] temp = fares[i];
            int x = temp[0];
            int y = temp[1];
            int d = temp[2];

            map[x][y] = d;
            map[y][x] = d;
        }

        int[][] floydMap = new int[n+1][n+1];
        for(int i = 1; i<= n; i++){
            for(int j = 1; j <=n; j++){
                if(i==j) floydMap[i][j] = 0;
                else if(map[i][j] != 0){
                    floydMap[i][j] = map[i][j];
                    floydMap[j][i] = map[i][j];
                }
                else{
                    floydMap[i][j] = 10000000;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <=n; k++){
                    floydMap[j][k] = Math.min(floydMap[j][k], floydMap[j][i] + floydMap[i][k]);
                }
            }
        }

        int min = 10000000;
        for(int i = 1; i <= n; i ++){
            min = Math.min(floydMap[s][i] + floydMap[i][a] + floydMap[i][b], min);
        }

        return min;
    }


    public static void main(String[] args) {

        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;

        int[][] fares = {
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        };

        System.out.println(solution(n, s, a, b, fares));


    }
}
