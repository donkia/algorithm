package backjoon;

import javax.script.ScriptException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697 {

    public static void main(String[] args) throws ScriptException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] map = new int[1000001];

        if (n >= k) {
            System.out.println(n - k);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 1});
        map[n] = 1;

        while (!queue.isEmpty()) {

            int num = queue.peek()[0];
            int cnt = queue.peek()[1];
            queue.poll();

            if (num == k) {
                break;
            }

            if (num - 1 >= 0 && map[num - 1] == 0) {
                map[num - 1] = cnt + 1;
                queue.add(new int[]{num - 1, cnt + 1});
            }

            if (num + 1 < 1000001 && map[num + 1] == 0) {
                map[num + 1] = cnt + 1;
                queue.add(new int[]{num + 1, cnt + 1});
            }

            if (num * 2 <= 1000000 && map[num * 2] == 0) {
                map[num * 2] = cnt + 1;
                queue.add(new int[]{num * 2, cnt + 1});

            }

        }

        System.out.println(map[k] - 1);

    }
}
