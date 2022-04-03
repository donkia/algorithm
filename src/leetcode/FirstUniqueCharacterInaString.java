package leetcode;

/**
 * 문제 : https://leetcode.com/problems/first-unique-character-in-a-string/
 * 레벨 : Easy
 * 결과 : 해결(runtime 9ms faster than 82.38%, memory 48.5MB less than 69.30%)
 */

public class FirstUniqueCharacterInaString {

    public static int firstUniqChar(String s) {
        // s 배열에 담긴 알파벳 개수 카운트
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++){
            alphabet[s.charAt(i) - 'a']++;
        }

        // 알파벳이 1번만 나오면 반복되지 않으므로 i값 return
        for(int i = 0; i < s.length(); i++){
            if(alphabet[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        // 아무런 값이 return이 안됐으면 반복되는 알파벳이 없으므로 -1 return
        return -1;
    }

    /** 두번째 풀이 
     * 해결(runtime 2ms faster than 99.46%, memory 48.5MB less than 65.87%)
     * */
    public static int firstUniqChar2(String s){
        int idx = Integer.MAX_VALUE;
        for(char i = 'a' ; i <= 'z' ; i++){
            if(s.indexOf(i) != -1 && s.indexOf(i) == s.lastIndexOf(i)){
                idx = Math.min(idx, s.indexOf(i));
            }
        }
        if(idx == Integer.MAX_VALUE)
            return -1;
        return idx;
    }

    public static void main(String[] args) {

        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
}
