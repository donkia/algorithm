package leetcode;

/** 문제 : https://leetcode.com/problems/permutation-in-string/
 *  레벨 : Medium
 *  결과 : 참고 후 해결(runtime 254ms faster than 14.36%, memory 72.8MB less than 6.72%)
 * */

public class PermutationInString {

    public static boolean checkAlphabet(char[] s1, char[] s2){

        for(int i = 0; i < 26; i++){
            if(s1[i] != s2[i])
                return false;
        }
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {

        char[] char_s1 = new char[26];

        for(int i = 0; i < s1.length(); i++){
            char_s1[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i <= s2.length() - s1.length(); i++){

            String temp = s2.substring(i, i + s1.length());
            char[] char_s2 = new char[26];
            for(int j = 0; j < temp.length(); j++){
                char_s2[temp.charAt(j) - 'a']++;
            }
            if (checkAlphabet(char_s1, char_s2)) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
       /* String s1 = "ab";
        String s2 = "eidboaoo";*/
/*
        String s1 = "abc";
        String s2 = "bbbca";
*/
        String s1 = "adc";
        String s2 = "dcda";

        System.out.println(checkInclusion(s1, s2));

       /* "ab"
        "eidbaooo"
        "ab"
        "eidboaoo"*/
    }
}
