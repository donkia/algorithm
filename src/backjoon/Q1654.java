package backjoon;

import java.util.Scanner;

public class Q1654 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 초기값 셋팅
        String inputNum = sc.nextLine();
        String[] inputArr = inputNum.split(" ");
        int k = Integer.parseInt(inputArr[0]);   // 4
        int n = Integer.parseInt(inputArr[1]);   // 11

        //int[] arr = new int[]{802, 743, 457, 539};
        int[] arr = new int[k];
        long min = 0;
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());

            if(arr[i] > max) max = arr[i];
        }
        max ++;
        while(min < max) {

            long mid = (min + max) / 2;
       int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i] / mid;
            }

            if (sum < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min-1);




    }
}
