package codility;


/** 1. 문제
 * test case 정답 후 제출
 * */


public class codingtest_Q1 {

    public static int sumNumber(int N) {
        String strN = Integer.toString(N);
        int sumN = 0;
        for (int i = 0; i < strN.length(); i++) {
            sumN = sumN + Integer.parseInt(strN.substring(i, i + 1));
        }

        return sumN;
    }

    public static int solution(int N) {
        // write your code in Java SE 8

        int sumN = sumNumber(N);

        int num = N + 1;
        int answer = 0;
        while (true) {

            int sum = sumNumber(num);
            if (sum == sumN) {
                answer = num;
                break;
            }
            num = num + 1;

        }

        return answer;

    }

    public static void main(String[] args) {

        int N = 50000;
        System.out.println(solution(N));

    }

}
