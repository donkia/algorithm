package backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q15652 {
    static int m;
    static int n;
    static StringBuilder sb = new StringBuilder();

    static public void DFS(ArrayList<Integer> al, int[] arr) {

        if (al.size() == m) {

            for (int temp : al) {
                sb.append(temp + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (al.get(al.size() - 1) <= i) {
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

        System.out.print(sb);

    }
}
