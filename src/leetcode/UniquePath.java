package leetcode;

/** 문제 : https://leetcode.com/problems/unique-paths/
 *  레벨 : Medium
 *  결과 : 참고 후 해결(runtime 1ms faster than 46.46%, memory 40.1MB less than 71.93%)
 * */

public class UniquePath {
    public static int uniquePaths(int m, int n) {

        int[][] map = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0)
                    map[i][j] = 1;
                else{
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }
        return map[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }
}
