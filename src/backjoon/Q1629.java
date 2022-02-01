package backjoon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1629 {

    static int sum = 0;
    public static long search(long a, long b, long c){

        if(b == 1){
            return a % c;
        }
        long temp = search(a, b / 2, c);

        if(b % 2 != 0){
            return (temp * temp % c) * a % c;
        }

        return temp * temp % c;
    }

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);
        long c = Integer.parseInt(input[2]);

        long temp = search(a, b, c);

        System.out.println(temp);
    }
}
