package backjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else if (Math.abs(o1) < Math.abs(o2)) {
                    return -1;
                } else {
                    if (o1 > o2) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        for (int i = 0; i < n; i++) {

            int temp = Integer.parseInt(sc.nextLine());
            if (temp == 0) {
                if (pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(temp);
            }
        }
    }
}
