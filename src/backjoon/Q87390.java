package backjoon;

import java.util.ArrayList;
import java.util.Collections;

public class Q87390 {

    public static int[] solution(int n, long left, long right) {

        int[] answer = new int[(int)(right - left + 1)];
        // 처음에는 모든 값을 구해서 배열에 넣고 left ~ right 값을 구하려니 시간초과 또는 메모리 초과 발생(n 제곱이 10^7이라..)
        // (1, 2) 중에 Max인 값이 arr[1][2] 의 값임....
        // left ~ right 값을 좌표로 나타낸 뒤 Max 값을 구해서 []answer에 인서트
        int answerIdx = 0;
        long num = left;
        while(num <= right){

            long x = num / n + 1;
            long y = num % n + 1;

            answer[answerIdx++] = (int) Math.max(x, y);

            num ++;

        }

      /*  for(Integer i : answer)
            System.out.print(i + " ");
*/
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int left = 2;
        int right = 5;

        solution(n, left, right);

    }
}
