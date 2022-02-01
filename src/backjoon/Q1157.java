package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Q1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine().toLowerCase(Locale.ROOT);

        int[] arr = new int[26];
        // 어떤 알파벳인지 arr 배열에 +1 씩 하기
        for(int i = 0; i < input.length(); i++){
            int temp = input.charAt(i);
            arr[temp-97] ++;
        }

        int max = Integer.MIN_VALUE; // max 값 구하기
        int cnt = 0; // max 값이 여러개일수도 있어서 카운트
        int idx = 0; // max 값이 한개일 경우 index 값 구함
        for(int i = 0; i < 26; i++) {

            if(arr[i] > max){
                max = arr[i];
                cnt = 0;
                idx  = i;
            }
            else if(arr[i] == max){
                cnt = cnt + 1;
            }
        }
        // max값이 한개일 경우
        if(cnt == 0){
            char c_temp = (char)(idx + 97);
            System.out.println(Character.toUpperCase(c_temp));
        }
        // max값이 여러개일 경우
        else
            System.out.println("?");
    }
}
