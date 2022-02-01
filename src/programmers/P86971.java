package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P86971 {
    public static int solution(int n, int[][] wires) {
        int answer = -1;
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < wires.length; j++) {
            // 하나씩 끊어진 송전탑 만들기
            int[] temp_wires = wires[j];
            int x = temp_wires[0];
            int y = temp_wires[1];
            wires[j][0] = 0;
            wires[j][1] = 0;
            // 트리의 꼭대기가 어딘지 정의하는 header 배열 선언
            int[] header = new int[n + 1];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            header[1] = 1;

            while (!queue.isEmpty()) {
                int poll = queue.poll(); // 큐에 있는값 하나씩 꺼냄

                for (int i = 0; i < wires.length; i++) {
                    int[] temp = wires[i];

                    int present = temp[0];
                    int next = temp[1];
                    // 다음 차례인 정점을 구함.
                    if (poll == present && header[next] == 0) {
                        header[next] = header[poll];
                        queue.add(next);

                    }
                    // 만약 next가 2이면 wires 배열에 (2,3)으로 저장되어있어 else 구문 추가
                    else if (poll == next && header[present] == 0) {
                        header[present] = header[poll];
                        queue.add(present);
                    }
                }
            }
            // header 배열에 1끼리 연결, 0끼리 연결이라 각 0,1 갯수 세기
            int cntone = 0;
            for (int i = 1; i <= n; i++) {
                if (header[i] == 1) {
                    cntone++;
                }
            }
            if (min > Math.abs(cntone - (n - cntone))) {
                min = Math.abs(cntone - (n - cntone));
            }
            // 끊어진 송전탑 복구
            wires[j][0] = x;
            wires[j][1] = y;
        }
        answer = min;
        return answer;
    }


    public static void main(String[] args) {

        int n = 9;
        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };
        System.out.println(solution(n, wires));

    }

}
