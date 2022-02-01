package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1247 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //입력값 셋팅
        String s = bufferedReader.readLine();
        int[] arr = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            arr[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        // 배열 정렬
        Arrays.sort(arr);

        // 출력
        for(int i = arr.length-1; i>=0 ; i--){
            System.out.print(arr[i]);
        }
    }
}
