import java.io.IOException;

public class Weekly11 {
    static int[][] map = new int[51][51];

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int answer = 0;

        for(int m = 0; m < rectangle.length; m++){

            int[] temp = rectangle[m];
            int a_x = temp[0];
            int b_x = temp[2];

            int a_y = temp[1];
            int b_y = temp[3];

            for(int i = a_x; i<= b_x; i++){
                map[i][a_x] = m+1;
                map[i][b_y] = m+1;
            }
            for(int i = a_y; i<= b_y; i++){
                map[a_y][i] = m+1;
                map[b_x][i] = m+1;
            }




        }













        return answer;
    }



    public static void main(String[] args) throws IOException {

        int[][] rectangle = {
                {1,1,7,4},
                {3,2,5,5},
                {4,3,6,9},
                {2,6,8,8}
        };

        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;


        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));



/*

        int[] arr = {1, 1, 7, 4};
        int[][]map = new int[51][51];

        int a_x = 1;
        int b_x = 7;

        int a_y = 1;
        int b_y = 4;

        for(int i = a_x; i<= b_x; i++){
            map[i][a_x] = 1;
            map[i][b_y] = 1;
        }
        for(int i = a_y; i<= b_y; i++){
            map[a_y][i] = 1;
            map[b_x][i] = 1;
        }

*/

        /*for(int i = a_x; i <=b_x; i++){

            for(int j = a_y; j <= b_y; j++){
                map[i][j] = 1;
            }
        }
*/

        for(int i = 0; i <10; i++){

            for(int j = 0; j < 10; j++){

                    System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }
}
