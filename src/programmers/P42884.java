package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class P42884 {

    public static int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 0;
        int min = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (min < route[0]) {
                min = route[1];
                cnt++;
            }
        }
        answer = cnt;
        return answer;
    }

    public static void main(String[] args) {

        int[][] routes = {
                {-20, -15},
                {-14, -5},
                {-18, -13},
                {-5, -3}

                /* {-5, -3},
                 {-3, 4},
                 {-20, -15},
                 {-15, -5},*/
        };
        System.out.println(solution(routes));
    }
}