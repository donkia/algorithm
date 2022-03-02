package leetcode;
/**
 * 문제 : https://leetcode.com/problems/palindrome-number/
 * 레벨 : Easy
 * 결과 : 해결(runtime 46ms faster than 6.35%, memory 51.8MB less than 5.07%)
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        String temp = Integer.toString(x);
        String reverse = "";
        for(int i = temp.length()-1; i >=0 ; i--) {
            reverse = reverse + temp.charAt(i);
        }
        //int nReverse = Integer.parseInt(reverse);
        //System.out.println(nReverse);

        if(temp.equals(reverse))
            return true;
        else
            return false;
    }
}
