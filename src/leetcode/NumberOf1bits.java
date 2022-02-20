package leetcode;

/** 문제 : https://leetcode.com/problems/number-of-1-bits/
 *  레벨 : Easy
 *  결과 : 해결(runtime 1ms faster than 71.38%, memory 42MB less than 5.75%)
 * */

public class NumberOf1bits {

    public static int hammingWeight(int n) {

        return Integer.bitCount(n);



    }

    public static void main(String[] args) {
        int n = 1;
    }
}
