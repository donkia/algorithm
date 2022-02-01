package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q18258 {
    public static void main(String[] args) throws IOException {
        //입력값 셋팅
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        int lastNumber = 0;

        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();

            if (input.equals("pop")) {
                if (q.isEmpty()) sb.append("-1").append('\n');
                else sb.append(q.poll()).append('\n');
            } else if (input.equals("front")) {
                if (q.isEmpty()) sb.append("-1").append('\n');
                else sb.append(q.peek()).append('\n');
            } else if (input.equals("back")) {
                if (q.isEmpty()) sb.append("-1").append('\n');
                else sb.append(lastNumber).append('\n');
            } else if (input.equals("size")) {
                sb.append(q.size()).append('\n');
           } else if (input.equals("empty")) {
                if (q.isEmpty()) sb.append("1").append('\n');
                else sb.append("0").append('\n');
            } else if (input.substring(0, 4).equals("push")) {
                String[] str = input.split(" ");
                int number = Integer.parseInt(str[1]);
                q.add(number);
                lastNumber = number;
            }
        }
        System.out.println(sb);
    }
}