package programmers;

public class P1 {

    public static int solution(int[][] triangle) {
        int answer = 0;
        int row = triangle.length;
        int col = triangle[row-1].length;

        int[][]sum = new int[row][col];

        sum[0][0] = triangle[0][0];


        for(int i = 0; i < row-1; i ++){

            for(int  j = 0; j <= i; j++){
                //sum[i][j] = Math.max();
                //sum[i][j] = sum[i-1][j] + triangle[i][j];
                sum[i + 1][j] = Math.max(sum[i + 1][j], sum[i][j] + triangle[i+1][j]);
                sum[i + 1][j+1] = Math.max(sum[i + 1][j+1], sum[i][j] + triangle[i+1][j+1]);
            }
        }

        for(int i = 0 ; i < col; i++){
            answer = Math.max(answer, sum[row - 1][i]);
        }



        return answer;
    }


    public static void main(String[] args) {

        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}

        };
        System.out.println(solution(triangle));

    }




}
