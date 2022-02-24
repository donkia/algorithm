package programmers;

public class Codingtest_Q1_20220224 {

    public static String solution(String sentence) {

        int[] alphabet = new int[26];
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < sentence.length(); i++){
            String temp = sentence.substring(i, i + 1).toLowerCase();
            if(temp.charAt(0) -'a' >= 0 && temp.charAt(0) - 'a' <= 25){
                alphabet[temp.charAt(0) - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++) {

            if(alphabet[i] == 0){
                answer.append((char) (i + 'a'));
            }
        }

        if(answer.toString().equals("")){
            return "perfect";
        }
        else
            return answer.toString();
    }

    public static void main(String[] args) {

        //String sentence = "His comments came after Pyongyang announced it had a plan to fire four missiles near the US territory of Guam.";
        String sentence = "Jackdaws love my big sphinx of quartz";

        /* String s = "az";
        System.out.println(s.charAt(0) -'a');
        System.out.println(s.charAt(1) - 'a');
        System.out.println((int)'a');
        System.out.println((int)'z');*/
        //System.out.println(((char) ('a' + 1)));

       System.out.println(solution(sentence));


    }
}
