package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //입력값 셋팅
        int n = Integer.parseInt(bufferedReader.readLine());
        HashSet<String> hs = new HashSet<>();

        ArrayList<StringBuilder> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hs.add(bufferedReader.readLine()); // 중복을 제거해야해서 HashSet에 add
        }
        for (String temp : hs) { // HashSet에 있는 값을 ArrayList로 넣기
            StringBuilder sb_temp = new StringBuilder(temp);
            al.add(sb_temp);
        }
        //정렬
        Collections.sort(al, new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder o1, StringBuilder o2) {

                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                return o1.compareTo(o2);

            }
        });

        for (StringBuilder sb : al) {
            System.out.println(sb);

        }
    }
}
