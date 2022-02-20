package leetcode;

/** 문제 : https://leetcode.com/problems/power-of-two/
 *  레벨 : Easy
 *  결과 : 해결(runtime 1ms faster than 98.24%, memory 39.4MB less than 24.16%)
 * */

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {

        if(n<=0)
            return false;

        if(n==1)
            return  true;

        if(n % 2 != 0)
            return false;

        int[] twoArray = new int[32];
        twoArray[0] = 1;
        for(int i = 1; i < 32; i++){
            twoArray[i] = twoArray[i - 1] * 2;
        }

        for(int i = 0; i < 32; i++){
            if(twoArray[i] == n){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(isPowerOfTwo(n));
    }


}
