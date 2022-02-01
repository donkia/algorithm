package backjoon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q15650 {

    static int m;
    static int n;
    static Queue<ArrayList<Integer>> queue = new LinkedList<>();

    static public void DFS(ArrayList<Integer> al, int[] arr) {

        if (al.size() == m) {
            ArrayList<Integer> cp = new ArrayList<>(al);
            queue.add(cp);
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (arr[i] == 0 && al.get(al.size() - 1) < i) {
                arr[i] = 1;
                al.add(i);
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

        ArrayList<Integer> al = new ArrayList<>();
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = 1;
            al.add(i);
            DFS(al, arr);
            al.remove(0);
            arr[i] = 0;
        }

        for (ArrayList<Integer> temp : queue) {
            for (int t : temp) {
                System.out.print(t + " ");
            }
            System.out.println();
        }


    }
}