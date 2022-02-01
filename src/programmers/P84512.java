package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P84512 {
    static int totalCnt = 0;
    static ArrayList<String> al = new ArrayList<>();

    static void DFS(String s, int cnt, String word){

        if(s.equals(word)){
            System.out.println(cnt);
            return;
        }
        if(s.length() == 5)
            return;

        totalCnt++;
        DFS(s + "A", cnt + 1, word);
        totalCnt++;
        DFS(s + "E", cnt + 1, word);

        totalCnt++;
        DFS(s + "I", cnt + 1, word);

        totalCnt++;
        DFS(s + "O", cnt + 1, word);

        totalCnt++;
        DFS(s + "U", cnt + 1, word);

    }

    public static int solution(String word) {
        int answer = 0;


        DFS("", 0, word);

        return answer;
    }


    public static void main(String[] args) {

        String word = "AAAE";
        System.out.println(solution(word));
        System.out.println("totalCnt : " + totalCnt);

    }
}
