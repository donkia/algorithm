package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[10000001];

        for(int i = 0; i < n; i++){
            int nInput = Integer.parseInt(bufferedReader.readLine());
            arr[nInput] ++ ;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i< arr.length; i++){
            int cnt = arr[i];
            for(int j = 0; j < cnt; j++){
                sb.append(i);
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }

}
