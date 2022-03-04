package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 레벨 : Medium
 * 결과 : 해결(runtime 3ms faster than 50.49%, memory 40.9MB less than 50.32%)
 */

public class LetterCombinationsOfaPhoneNumber {

    public static List<String> answer;
    public static List<String> numToChar(int num){
        List<String> list = new ArrayList<>();
        if(num == 2){
            list.add("a");
            list.add("b");
            list.add("c");
        }
        else if(num == 3){
            list.add("d");
            list.add("e");
            list.add("f");
        }
        else if(num == 4){
            list.add("g");
            list.add("h");
            list.add("i");
        }
        else if(num == 5){
            list.add("j");
            list.add("k");
            list.add("l");
        }
        else if(num == 6){

            list.add("m");
            list.add("n");
            list.add("o");
        }
        else if(num == 7){
            list.add("p");
            list.add("q");
            list.add("r");
            list.add("s");
        }
        else if(num == 8){
            list.add("t");
            list.add("u");
            list.add("v");
        }
        else if(num == 9){
            list.add("w");
            list.add("x");
            list.add("y");
            list.add("z");
        }
        return list;
    }

    public static void DFS(List<String>[] alphabet, int idx, String word){

        if(word.length() == alphabet.length){
            System.out.println(word);
            answer.add(word);
            return;
        }

        for(int i = 0; i < alphabet[idx].size(); i++){
            DFS(alphabet, idx + 1, word + alphabet[idx].get(i));
        }
    }
    public static List<String> letterCombinations(String digits) {

        List<String>[] alphabet = new List[digits.length()];
        answer = new ArrayList<>();

        if(digits.equals("")){
            return answer;
        }

        for(int i = 0; i < digits.length(); i++){
            int digit = Integer.parseInt(digits.substring(i, i + 1));
            alphabet[i] = numToChar(digit);
        }

        for(int i = 0 ; i < alphabet[0].size(); i++){

            DFS(alphabet, 1, alphabet[0].get(i));

        }

        return answer;

    }


    public static void main(String[] args) {

        String digits = "32";
        System.out.println(letterCombinations(digits));

    }
}
