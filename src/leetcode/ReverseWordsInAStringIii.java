package leetcode;

/** 문제 : https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *  레벨 : Easy
 *  결과 : 해결(runtime faster than 56.12%, memory less than 19.46%)
 * */

public class ReverseWordsInAStringIii {

    public static String reverseWords(String s) {

        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < split.length; i++){
            StringBuilder temp = new StringBuilder(split[i]);
            temp.reverse();

            if(i == split.length-1){
                sb.append(temp);
            }
            else {
                sb.append(temp + " ");
            }
        }

        return sb.toString();



    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }


}
