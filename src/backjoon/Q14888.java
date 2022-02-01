package backjoon;

import java.util.Scanner;

public class Q14888 {

    static long max = Integer.MIN_VALUE;
    static long min = Integer.MAX_VALUE;

    static void DFS(int[] cal, int[] arr, int idx, long sum){

        if(idx == arr.length-1){
            if(max < sum){
                max = sum;
            }
            if(min > sum){
                min = sum;
            }
            return ;
        }

        long a = sum;
        int b = arr[idx+1];

        for(int i = 0; i < cal.length; i++){

            if(cal[i] != 0){
                long c = 0;
                if(i == 0){
                    c = a + b;
                }
                else if(i == 1){
                    c = a - b;
                }
                else if(i == 2){
                    c = a * b;
                }
                else if(i == 3){
                    if(a < 0) {
                        a = a * -1;
                        c = a / b;
                        c = c * -1;
                    }
                    else
                        c = a  / b;
                }
                cal[i] = cal[i] - 1;
                DFS(cal, arr, idx + 1, c);
                cal[i] = cal[i] + 1;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int n = Integer.parseInt(num);
        int[] arr = new int[n];
        int[] cal = new int[4];

        num = sc.nextLine();
        String[] arrNum = num.split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(arrNum[i]);
        }

        String CAL = sc.nextLine();
        arrNum = CAL.split(" ");
        for(int i = 0; i < 4; i++){
            cal[i] = Integer.parseInt(arrNum[i]);
        }
        DFS(cal, arr, 0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}
