package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2908 {
    public static void main(String[] args) throws IOException {
        //입력값 셋팅
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
    
        String a = input[0].toString();
        String b = input[1].toString();

        StringBuilder reverse_a = new StringBuilder();
        StringBuilder reverse_b = new StringBuilder();
        // 역수 구하기
        for(int i = a.length()-1; i >=0 ; i--){
            reverse_a.append(a.substring(i, i+1));
        }

        for(int i = a.length()-1; i >=0 ; i--){
            reverse_b.append(b.substring(i, i+1));
        }
        // int로  형 변환
        int int_a = Integer.parseInt(reverse_a.toString());
        int int_b = Integer.parseInt(reverse_b.toString());
        // 출력
        System.out.println(Math.max(int_a, int_b));

    }
}
