package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 문제 : https://leetcode.com/problems/happy-number/
 * 레벨 : Easy
 * 결과 : 해결(runtime 3ms faster than 38.16%, memory 41.8MB less than 22.47%)
 */

public class HappyNumber {

    public static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while(!set.contains(n)) {
            set.add(n);

            int temp = n;
            n = 0;

            while(temp != 0) {
                n += (temp % 10) * (temp % 10);
                temp /= 10;
            }

            if(n == 1)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int n = 1111111;
        System.out.println(isHappy(n));
    }

}
