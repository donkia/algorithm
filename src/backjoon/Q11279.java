package backjoon;

import java.util.*;

public class Q11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(sc.nextLine());
            if (temp == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(priorityQueue.poll());
                }
            } else {
                priorityQueue.add(temp);
            }
        }
    }
}
