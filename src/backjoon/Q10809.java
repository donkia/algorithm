package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for(int i = 0; i < input.length(); i++){
            int temp = input.charAt(i);
            if(arr[temp-97] == -1)
                arr[temp-97] = i;
        }

        for(Integer temp : arr)
            System.out.print(temp + " ");

        // a: 97 / z : 122

    }
}
