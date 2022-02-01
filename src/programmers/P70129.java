package programmers;

public class P70129 {

    public static int[] solution(String s) {
        int[] answer = new int[2];

        int cnt = 0; // 0을 제거한 카운트
        int idx = 0; // 이진변환한 회차
        while(true) {
            String transformBinary = "";

            //0의개수는 카운트하고 1만 추출함
            for (int i = 0; i < s.length(); i++) {
                if (s.substring(i, i + 1).equals("1")) {
                    transformBinary += "1";
                } else {
                    cnt++;
                }

            }
            // 이진변환 후 문자열 길이 확인 -> 문자열 길이로 binary로 나타냄
            int binaryLen = transformBinary.length();
            String strBinary = Integer.toBinaryString(binaryLen).toString();
            // 최종 문자열이 1이면 그만
            if (strBinary.equals("1")) {
                break;
            }
            s = strBinary;
            idx ++ ;
        }
        answer[0] = idx+1;
        answer[1] = cnt;
        return answer;
    }

    public static void main(String[] args) {
        String s = "0111010";
        System.out.println(solution(s));
    }
}
