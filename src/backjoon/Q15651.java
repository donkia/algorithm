package backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q15651 {

    static int m;
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        Queue<ArrayList<Integer>> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int j = 1; j <= n; j++) {

            Queue<ArrayList<Integer>> queue = new LinkedList<>();
            ArrayList<Integer> al = new ArrayList<>();
            al.add(j);
            queue.add(al);

            while (!queue.isEmpty()) {

                ArrayList<Integer> temp = queue.peek();
                queue.poll();
                if (temp.size() == m) {

                    result.add(temp);
                    continue;
                }

                for (int i = 1; i <= n; i++) {
                    ArrayList<Integer> t = new ArrayList<>(temp);
                    t.add(i);
                    queue.add(t);
                }
            }
        }

        for (ArrayList<Integer> answer : result) {
            for (int k : answer) {
                sb.append(k + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}