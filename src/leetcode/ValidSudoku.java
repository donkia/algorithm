package leetcode;

import java.util.ArrayList;

/** 문제 : https://leetcode.com/problems/valid-sudoku/
 *  레벨 : Medium
 *  결과 : 해결(runtime 3ms faster than 77.86%, memory 46.4MB less than 23.79%)
 * */

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {

        // 가로를 탐색하면서 중복된 숫자 확인
        for (int i = 0; i < 9; i++) {
            ArrayList<Character> arrayList = new ArrayList<>();
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.')
                    continue;

                if (arrayList.contains(board[i][j])) {
                    return false;
                } else
                    arrayList.add(board[i][j]);
            }
        }

        // 세로를 탐색하면서 중복된 숫자 확인
        for (int i = 0; i < 9; i++) {
            ArrayList<Character> arrayList = new ArrayList<>();
            for (int j = 0; j < 9; j++) {

                if (board[j][i] == '.')
                    continue;

                if (arrayList.contains(board[j][i])) {
                    return false;
                } else
                    arrayList.add(board[j][i]);
            }
        }

        // 3x3 정사각형에서 중복된 숫자 확인
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {

                ArrayList<Character> arrayList = new ArrayList<>();
                for (int k = i; k < i + 3; k++) {

                    for (int m = j; m < j + 3; m++) {
                        if (board[k][m] == '.')
                            continue;
                        if (arrayList.contains(board[k][m])) {
                            return false;
                        } else
                            arrayList.add(board[k][m]);
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
                /*{'5', '3', '.', '.', '7', '.', '.', '.', '.' }
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.' }
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.' }
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3' }
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1' }
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6' }
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.' }
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5' }
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9' }*/


                  {'8', '3', '.', '.', '7', '.', '.', '.', '.' }
                  , {'6', '.', '.', '1', '9', '5', '.', '.', '.' }
                  , {'.', '9', '8', '.', '.', '.', '.', '6', '.' }
                  , {'8', '.', '.', '.', '6', '.', '.', '.', '3' }
                  , {'4', '.', '.', '8', '.', '3', '.', '.', '1' }
                  , {'7', '.', '.', '.', '2', '.', '.', '.', '6' }
                  , {'.', '6', '.', '.', '.', '.', '2', '8', '.' }
                  , {'.', '.', '.', '4', '1', '9', '.', '.', '5' }
                  , {'.', '.', '.', '.', '8', '.', '.', '7', '9' }

        };
        System.out.println(isValidSudoku(board));
    }
}
