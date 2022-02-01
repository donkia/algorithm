package programmers;

import java.util.*;

public class P67258 {

    public static int[] solution1(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> hsGems = new HashSet();

        for (String s : gems) {
            hsGems.add(s);
        }

        int gemsSize = hsGems.size();
        HashMap<String, Integer> hs = new HashMap<>();
        int start = 0;
        int end = 0;

        int distance = Integer.MAX_VALUE;
        int right = 0;
        int left = 0;

        while (true) {
            String strStart;
            String strEnd;

            if (hs.size() == gemsSize) {

                strStart = gems[left];
                hs.put(strStart, hs.get(strStart) - 1);

                if (hs.get(strStart) == 0) {
                    hs.remove(strStart);
                }
                left = left + 1;

            } else if (right == gems.length) {
                break;
            } else {
                strEnd = gems[right];
                hs.put(strEnd, hs.getOrDefault(strEnd, 0) + 1);
                right = right + 1;

            }
            if (hs.size() == gemsSize) {
                System.out.println("start : " + start + ", end : " + end + ", left : " + left + ", right : " + right);
                if (right - left < distance) {
                    distance = end - start;
                    start = left + 1;
                    end = right;
                }
            }

        }

        answer[0] = start;
        answer[1] = end;

        return answer;
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        //진열대의 특정 범위의 보석을 구매
        //모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간
        //set으로 모든 보석 종류 구하기
        //시작 진열대 번호, 끝 진열대 번호 리턴
        //여러개라면 시작 진열대 번호가 제일 작은 구간
        HashSet<String> set = new HashSet<>();
        for (String s : gems) {
            set.add(s);
        }
        int n = gems.length;

        int distance = Integer.MAX_VALUE;
        //범위
        int left = 0;
        int right = 0;
        //정답
        int start = 0;
        int end = 0;

        HashMap<String, Integer> map = new HashMap<>();
        while (true) {

            if (set.size() == map.size()) {
                //크기 같은 경우 원하는 범위 좁히기
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            } else if (right == n) {
                break;
            } else {
                //right 오른쪽으로 이동
                //set에 해당하는 보석들을 다 찾아야함
                //해당 보석의 개수 +1
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (map.size() == set.size()) {
                if (right - left < distance) {
                    distance = right - left;
                    start = left + 1;
                    end = right;
                }
            }

        }//while

        answer[0] = start;
        answer[1] = end;

        return answer;
    }

    public static void main(String[] args) {

        // String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        //String[] gems = {"AA", "AB", "AC", "AA", "AC"};
        //String[] gems = {"XYZ", "XYZ", "XYZ"};
        String[] gems = {"BB", "AA", "AA", "CC", "DD", "AA", "BB"};
        //String[] gems = {"A", "A", "A", "B", "B"};
        //String[] gems = {"A","B","B","B","B","B","B","C","B","A"};
        //String[] gems = {"A", "A", "B"};
        System.out.println(solution(gems));

    }
}
