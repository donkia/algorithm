package backjoon;

import java.util.Scanner;

public class Q2231 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = 0;
            String strN = Integer.toString(i);
            int[] arr = new int[strN.length()];

            for (int j = 0; j < strN.length(); j++) {
                arr[j] = Integer.parseInt(strN.substring(j, j + 1));
                sum += arr[j];

            }
            sum += i;
            if (sum == n) {
                if (min > i) {
                    min = i;
                }
            }
        }
        if (min != Integer.MAX_VALUE)
            System.out.println(min);
        else
            System.out.println("0");
    }
}
