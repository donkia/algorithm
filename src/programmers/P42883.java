package programmers;

public class P42883 {

    public static String solution(String number, int k) {
        String answer = "";
        int totalLength = number.length() - k;
        StringBuilder sb = new StringBuilder("");
        StringBuilder sbNumber = new StringBuilder(number);
        int j = 0;
        int last = k;

        while(sb.length() != totalLength) {
            int maxNum = Integer.MIN_VALUE;
            int maxIdx = 0;
            for (int i = j; i <= j+last; i++) {

                if (maxNum < sbNumber.charAt(i) - '0') {
                    maxNum = sbNumber.charAt(i) - '0';
                    maxIdx = i;
                    if (maxNum == 9) {
                        break;
                    }
                }
            }
            // k 범위 줄이기
            last = k - (maxIdx - sb.length());
            sb.append(sbNumber.charAt(maxIdx));
            j = maxIdx + 1;
        }
        answer = sb.toString();
        return answer;

    }

    public static void main(String[] args) {
/*

        String number = "4177252841";
        int k = 4;
*/

/*
        String number = "444444444444444";
        int k = 10;
*/

        String number = "4177252841";
        int k = 4;


        System.out.println(solution(number, k));
/*

        String number = "9";
        StringBuilder sb = new StringBuilder();
        sb.append("9");
        for(int i = 1; i < 1000000; i++){
            //number = number + 3;
            sb.append("9");
        }
        int k = 999999;
        System.out.println(solution(sb.toString(), k));
*/


    }
}
