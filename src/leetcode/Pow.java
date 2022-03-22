package leetcode;

/** 문제 : https://leetcode.com/problems/powx-n/
 *  레벨 : Medium
 *  결과 : 해결(runtime 0ms faster than 100.00%, memory 41.6MB less than 74.83%)
 * */

public class Pow {

    public static double myPow(double x, int n) {

        return Math.pow(x, n);

    }

    public static void main(String[] args) {

        double x = 2.00000;
        int n = -2;
        System.out.println(myPow(x, n));

    }
}
