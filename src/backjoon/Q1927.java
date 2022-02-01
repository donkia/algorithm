package backjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

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
