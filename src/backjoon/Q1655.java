package backjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1655 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {

            int input = Integer.parseInt(sc.nextLine());
            pq.add(input);

            ArrayList<Integer> al = new ArrayList<>();

            if (i > 0) {
                int idx = pq.size();

                for (int j = 0; j < idx; j++) {
                    int temp = pq.poll();
                    al.add(temp);
                }
                /*for(int j = 0; j < al.size(); j++){
                    pq.add(al.get(j));
                }*/
            }
            else if (i == 0) {
                sb.append(pq.peek());
                sb.append('\n');
                continue;
            }

            if (al.size() % 2 == 0 && al.size() > 0) {
                int temp1 = al.get(al.size() / 2);
                int temp2 = al.get((al.size() / 2) - 1);
                sb.append(Math.min(temp1, temp2));
            } else
                sb.append(al.get(al.size() / 2));
            sb.append('\n');
            pq = new PriorityQueue<>(al);

        }
        System.out.println(sb);
    }

}
