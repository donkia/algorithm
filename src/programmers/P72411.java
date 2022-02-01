package programmers;

import java.util.*;

public class P72411 {
    static HashMap<String, Integer>[] hs;
    static int[] max;
    // 알파벳에 대한 조합 만들기(ABCD : AB, AC, AD, BC, ... , ABC ... ABCD)
    public static void DFS(char[] order, String s, int idx, int course_max) {
        if (s.length() >= 2) {
            if (s.length() > course_max) {
                return;
            }
            // String s의 정렬을 위한 char[] 생성
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String input = "";
            for (char c : temp) {
                input += c;
            }
            s = input;

            // Map에 s가 있는지없는지. 없으면 insert 있으면 update
            if (hs[s.length()].containsKey(s)) {
                int num = hs[s.length()].get(s);
                if (max[s.length()] < num + 1) {
                    max[s.length()] = num + 1;
                }
                hs[s.length()].put(s, num + 1);
            } else {
                hs[s.length()].put(input, 1);
            }
        }
        // DFS를 통한 알파벳 조합 만들기
        for (int i = idx + 1; i < order.length; i++) {
            if (order[i] != '-') {
                char temp = order[i];
                order[i] = '-';
                DFS(order, s + temp, i, course_max);
                order[i] = temp;
            }
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer;
        int n = 11;
        hs = new HashMap[n];
        max = new int[n];
        int course_max = course[course.length - 1];

        for (int i = 0; i < n; i++) {
            hs[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            max[i] = Integer.MIN_VALUE;
        }
        // DFS 시작
        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();

            for (int j = 0; j < order.length; j++) {
                char temp = order[j];
                order[j] = '-';
                DFS(order, "" + temp, j, course_max);
                order[j] = temp;
            }
        }
        ArrayList<String> al = new ArrayList<>();
        // hs에 들어간 2글자, 3글자, 4글자... 등등에 대해서 글자수 별 max 값을 al에 넣음
        for (int i = 0; i < course.length; i++) {
            HashMap<String, Integer> hs_temp = hs[course[i]];
            for (String s : hs_temp.keySet()) {
                if (max[course[i]] == hs_temp.get(s)) {
                    if (max[course[i]] > 1)
                        al.add(s);
                }
            }
        }
        // al에서 알파벳 순으로 정렬
        Collections.sort(al, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        answer = new String[al.size()];
        for (int j = 0; j < al.size(); j++) {
            answer[j] = al.get(j).toString();
        }
        System.out.println(al);
        return answer;
    }

    public static void main(String[] args) {

       /* String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
       */
        String[] orders = {"ABCD", "BACD", "DABC"};
        int[] course = {2, 3};
        System.out.println(solution(orders, course));

    }
}
