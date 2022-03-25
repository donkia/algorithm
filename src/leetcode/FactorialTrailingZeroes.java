package leetcode;

/** 문제 : https://leetcode.com/problems/factorial-trailing-zeroes/
 *  레벨 : Medium
 *  결과 : 참고 후 해결(runtime 1ms faster than 84.53%, memory 40.8MB less than 69.56%)
 * */

public class FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {

       if(n == 0) return 0;

        return n / 5 + trailingZeroes(n / 5);

    }

    public static void main(String[] args) {
        int n = 10000;
        System.out.println(trailingZeroes(n));
    }

}
