package backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q15649 {

    static int n;
    static int m;
    static Queue<ArrayList<Integer>> queue = new LinkedList<>();

    public static void DFS(ArrayList<Integer> al, int[] arr) {

        if (al.size() == m) {
            ArrayList<Integer> bl = new ArrayList<>(al);
            queue.add(bl);
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (arr[i] == 0) {

                al.add(i);
                arr[i] = 1;
                DFS(al, arr);
                arr[i] = 0;
                al.remove(al.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] arr = new int[9];

        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(i);
            arr[i] = 1;
            DFS(al, arr);
            arr[i] = 0;
        }

        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = queue.poll();
            for (int i : temp) {
                System.out.print(i + " ");

            }
            System.out.println();
        }

    }
}
