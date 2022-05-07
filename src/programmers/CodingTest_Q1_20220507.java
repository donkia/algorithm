package programmers;

import java.util.Arrays;
import java.util.HashMap;

// 100점
public class CodingTest_Q1_20220507 {


    public static int solution(String[] scores) {
        int answer = 0;

        for (int i = 0; i < scores.length; i++) {

            HashMap<String, Integer> hashMap = new HashMap<>();
            // 점수(A,B,C,D,E)의 갯수를 파악해서 map에 저장
            for (int j = 0; j < scores[i].length(); j++) {
                String score = scores[i].substring(j, j + 1);
                hashMap.put(score, hashMap.getOrDefault(score, 0) + 1);
            }
            // F를 2명 이상 심사위원에게 받았을 때 -> 탈락
            if (hashMap.containsKey("F") && hashMap.get("F") >= 2) {
                continue;
            }
            // A를 2명 이상 심사위원에게 받았을 때 -> 합격
            if (hashMap.containsKey("A") && hashMap.get("A") >= 2) {
                answer = answer + 1;
                continue;
            }
            // 최고점, 최저점 하나씩 계산 후 평균이 3점 이상인지 확인
            String[] sortScore = scores[i].split("");
            // 점수를 정렬 -> 0번째, 마지막 index를 제거한 뒤 점수를 구함
            Arrays.sort(sortScore);
            int sum = 0;
            for (int j = 1; j < sortScore.length - 1; j++) {
                int point = 70 - sortScore[j].charAt(0);
                sum += point;
            }
            //평균점수가 3점 이상 -> 합격
            if (sum / (sortScore.length - 2) >= 3) {
                answer = answer + 1;
                continue;
            }
        }
        return answer;
    }

    public static void main(String[] args) {


        String[] scores = {"AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC"};
        System.out.println(solution(scores));

        scores = new String[]{"BCD", "ABB", "FEE"};
        System.out.println(solution(scores));

    }

}
