package programmers;

public class CodingTest_Q3_20220319 {

    public static int solution(int num, int[] cards) {
        int answer = Integer.MAX_VALUE;

        for (int i = cards.length - 1; i >= 0; i--) {
            int n = num;
            int cnt = 0;
            int idx = i;

            while (n != 0) {
                if (cnt > answer) {
                    break;
                }

                if (n >= cards[idx]) {
                    cnt = cnt + (n / cards[idx]);
                    n = n % cards[idx];
                } else {

                    if (idx > 0) {
                        idx--;
                    } else {
                        break;
                    }

                }
            }
            if (n == 0)
                answer = Math.min(answer, cnt);

        }
        if(answer == Integer.MAX_VALUE )
            return -1;

        return answer;
    }


    public static void main(String[] args) {
        int[] cards = {4, 6, 8};
        int num = 15;
        System.out.println(solution(num, cards));
    }
}
