package leetcode;


/**
 * 문제 : https://leetcode.com/problems/word-search/
 * 레벨 : Medium
 * 결과 : 해결(runtime 590ms faster than 8.57%, memory 118.5MB less than 9.34%)
 */
public class WordSearch {

    static boolean answer;

    public static void DFS(int i , int j , char[][]board, String word, String s, int [][] visit, int idx){

        if(idx > word.length()){
            return;
        }

        if(s.equals(word)){
            System.out.println("true");
            answer = true;
            return;
        }

        int m = board.length;
        int n = board[0].length;

        if( i > 0 && visit[i-1][j] == 0){
            if(board[i-1][j] == word.charAt(idx)){
                visit[i-1][j] = 1;
                DFS(i - 1, j, board, word, s + board[i - 1][j], visit, idx+1);
                visit[i-1][j] = 0;
            }
        }

        if( i < m-1 && visit[i+1][j] == 0){
            if(board[i+1][j] == word.charAt(idx)){
                visit[i+1][j] = 1;
                DFS(i + 1, j, board, word, s + board[i + 1][j], visit, idx+1);
                visit[i+1][j] = 0;

            }
        }

        if( j > 0 && visit[i][j-1] == 0){
            if(board[i][j-1] == word.charAt(idx)){
                visit[i][j-1] = 1;
                DFS(i , j-1, board, word, s + board[i][j-1], visit, idx+1);
                visit[i][j-1] = 0;

            }
        }
        if( j < n-1 && visit[i][j+1] == 0){
            if(board[i][j+1] == word.charAt(idx)){
                visit[i][j+1] = 1;
                DFS(i , j+1, board, word, s + board[i][j+1], visit, idx+1);
                visit[i][j+1] = 0;

            }
        }


    }



    public static boolean exist(char[][] board, String word) {
        answer = false;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(board[i][j] == word.charAt(0)){
                    int[][] visit = new int[board.length][board[0].length];
                    visit[i][j] = 1;
                    DFS(i, j, board, word, ""+board[i][j], visit, 1);
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESCFS";
        System.out.println(exist(board, word));

    }
}
