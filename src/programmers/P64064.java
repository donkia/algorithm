package programmers;

import java.util.ArrayList;
import java.util.HashSet;

public class P64064 {
    static HashSet<ArrayList<String>> al = new HashSet<>();
    // 두 문자열이 매칭되는지 확인하는 메소드
    public static Boolean checkSame(String a, String b) {
        Boolean isSame = true;
        char[] char_a = a.toCharArray();
        char[] char_b = b.toCharArray();

        for (int i = 0; i < char_b.length; i++) {
            if (char_a[i] == char_b[i]) {

            } else if (char_a[i] == '*' || char_b[i] == '*') {

            } else {
                isSame = false;
                break;
            }
        }
        return isSame;
    }

    public static void DFS(String[] banned_id, int cnt, ArrayList<String> al_temp, int idx) {
        if (cnt == banned_id.length) {
            if (al.contains(al_temp)) {

            } else {
                al.add(al_temp);
            }
            return;
        } else if (cnt > banned_id.length) {
            return;
        }

        for (int i = 0; i < al_temp.size(); i++) {
            String s = al_temp.get(i).toString();
            if (s.equals("-")) {
                continue;
            } else {
                // 두 문자열이 길이가 같은지 확인
                if (s.length() != banned_id[idx].length()) {
                    continue;
                }
                // 두 문자열이 매칭되면 DFS 진입
                if (checkSame(s, banned_id[idx])) {
                    al_temp.set(i, "-");
                    DFS(banned_id, cnt + 1, al_temp, idx + 1);
                    al_temp.set(i, s);
                }
            }
        }
    }


    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        ArrayList<String> al_temp = new ArrayList<>();
        for (String s : user_id) {
            al_temp.add(s);
        }
        DFS(banned_id, 0, al_temp, 0);
        // DFS 후 hashSet의 크기를 리턴
        answer = al.size();

        return answer;
    }

    public static void main(String[] args) {
/*

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

*/
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};


        System.out.println(solution(user_id, banned_id));


    }


}
