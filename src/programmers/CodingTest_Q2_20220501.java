package programmers;


// 50점?

public class CodingTest_Q2_20220501 {

    static int[][] map;

    public static void DFS(int[] start, int[] end, int x, int y, int[][] board, int sum, int m, int n, int c) {

        if (x == end[0] && y == end[1]) {
            map[end[0]][end[1]] = Math.min(sum, map[end[0]][end[1]]);
            return;
        }

        if (x > 0) {
            if (board[x - 1][y] == 1) {
                if(map[x-1][y] > sum + c){
                    map[x - 1][y] = Math.min(map[x - 1][y], sum + c+1);
                    DFS(start, end, x - 1, y, board, map[x - 1][y], m, n, c);
                }

            } else if (board[x - 1][y] == 0 || board[x - 1][y] == 3) {
                if(map[x-1][y] > sum + 1){
                    map[x - 1][y] = Math.min(map[x - 1][y], sum + 1);
                    DFS(start, end, x - 1, y, board, map[x - 1][y], m, n, c);
                }
            }
        }
        if (x < m - 1) {
            if (board[x + 1][y] == 1) {
                if(map[x+1][y] > sum + c) {
                    map[x + 1][y] = Math.min(map[x + 1][y], sum + c+1);
                    DFS(start, end, x + 1, y, board, map[x + 1][y], m, n, c);
                }
            } else if (board[x + 1][y] == 0  || board[x + 1][y] == 3) {
                if(map[x+1][y] > sum + 1) {
                    map[x + 1][y] = Math.min(map[x + 1][y], sum + 1);
                    DFS(start, end, x + 1, y, board, map[x + 1][y], m, n, c);
                }
            }
        }
        if (y > 0) {
            if (board[x][y - 1] == 1) {
                if(map[x][y-1] > sum + c) {
                    map[x][y - 1] = Math.min(map[x][y - 1], sum + c+1);
                    DFS(start, end, x, y - 1, board, map[x][y - 1], m, n, c);

                }
            } else if (board[x][y - 1] == 0  || board[x ][y-1] == 3) {
                if(map[x][y-1] > sum + 1) {
                    map[x][y - 1] = Math.min(map[x][y - 1], sum + 1);
                    DFS(start, end, x, y - 1, board, map[x][y - 1], m, n, c);
                }
            }
        }
        if (y < n - 1) {
            if (board[x][y + 1] == 1) {
                if(map[x][y+1] > sum + c) {
                    map[x][y + 1] = Math.min(map[x][y + 1], sum + c+1);
                    DFS(start, end, x, y + 1, board, map[x][y + 1], m, n, c);
                }
            } else if (board[x][y + 1] == 0 || board[x ][y+1] == 3) {
                if(map[x][y+1] > sum + 1 || board[x][y+1] == 3) {
                    map[x][y + 1] = Math.min(map[x][y + 1], sum + 1);
                    DFS(start, end, x, y + 1, board, map[x][y + 1], m, n, c);
                }
            }
        }

    }


    public static int solution(int[][] board, int c) {
        int answer = 0;

        map = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                map[i][j] = 1000;
            }
        }


        int[] start = new int[2];
        int[] end = new int[2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
                if (board[i][j] == 3) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        map[start[0]][start[1]] = 0;

        DFS(start, end, start[0], start[1], board, 0, map.length, map[0].length, c);
        return map[end[0]][end[1]];
    }

}
