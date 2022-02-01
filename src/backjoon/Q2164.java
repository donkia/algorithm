package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2164 {
    public static void main(String[] args) throws IOException {
        //입력값 셋팅
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                System.out.println(queue.peek());
                break;
            }

            if (index % 2 == 0) {
                queue.poll();
            } else {
                int num = queue.peek();
                queue.poll();
                queue.add(num);
            }
            index++;
        }

    }
}
