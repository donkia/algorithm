package leetcode;

import java.util.Arrays;

/** 문제 : https://leetcode.com/problems/reverse-string/
 *  레벨 : Easy
 *  결과 : 해결(runtime faster than 93.55%, memory less than 8.99%)
 * */

public class ReverseString {

    public static void reverseString(char[] s) {

        char[] temp = new char[s.length];
        for(int i = 0; i < s.length; i++){
            temp[i] = s[i];
        }
        for(int i = s.length-1; i >=0; i--){
            s[s.length-1-i] = temp[i];
        }

        System.out.println(Arrays.toString(s));

    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);

    }

}
