package programmers;

import java.util.ArrayList;

public class CodingTest_Q1_20220319 {
    static int[] arr;

    public static void DFS(int cnt, int[][] dice, ArrayList<Integer> arrayList, int[] visit) {

        for (Integer n : arrayList) {
            if (n == 0) continue;
            arr[n]++;
        }

        if (cnt == visit.length) {
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == 0) {
                ArrayList<Integer> temp = new ArrayList<>(arrayList);
                for (int j = 0; j < 6; j++) {

                    for (Integer n : arrayList) {
                        if(n == 0) continue;
                        int input = Integer.parseInt(Integer.toString(n) + Integer.toString(dice[i][j]));
                        temp.add(input);
                    }
                }
                visit[i] = 1;
                DFS(cnt + 1, dice, temp, visit);
                visit[i] = 0;
            }
        }


    }

    public static int solution(int[][] dice) {
        int answer = 0;
        arr = new int[10000];

        for (int i = 0; i < dice.length; i++) {
            ArrayList<Integer> input = new ArrayList<>();
            int[] visit = new int[dice.length];
            for (int j = 0; j < 6; j++) {
                input.add(dice[i][j]);
            }
            visit[i] = 1;
            DFS(0, dice, input, visit);

        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }


        return answer;
    }


    public static void main(String[] args) {
        int[][] dice = {
                /*  {1, 6, 2, 5, 3, 4},
                  {9, 9, 1, 0, 7, 8}*/

                /*{0, 1, 5, 3, 9, 2},
                {2, 1, 0, 4, 8, 7},
                {6, 3, 4, 7, 6, 5}*/

                {1,2,3,4,5,6},
                {7,8,9,0,1,2},
                {3,4,5,6,7,8},
                {9,0,1,2,3,4}
        };

        System.out.println(solution(dice));
    }
}
