package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q11866 {
    public static void main(String[] args) throws IOException {
        //입력값 셋팅
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int order = -1;

        /*while (true) {

            int j = 0;
            while (j < k) {
                order = order + 1;
                if (order >= al.size()) {
                    // order 의 index가 사이즈를 초과화면 0부터 진행하도록 설정
                    order = order - al.size();
                }
                // K번째 값이 0인지 아닌지 체크
                if (al.get(order) == 0) {

                } else j++;
            }

            sb.append(al.get(order));
            al.set(order, 0);
            // al의 값이 전부 0이면 무한루프 탈출.
            int sum = 0;
            for (int i = 0; i < al.size(); i++) {
                if (al.get(i) != 0) {
                    sum++;
                    break;
                }

            }
            if (sum == 0) break;
            sb.append(", ");
        }
        */

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            queue.add(i);
        }

        while(queue.size() != 1){
            for(int i = 0; i < k-1; i++) {
                int temp = queue.peek();
                queue.poll();
                queue.add(temp);
            }
            sb.append(queue.poll() + ", ");
        }
        sb.append(queue.poll());
        sb.append(">");
        System.out.println(sb);
    }
}
