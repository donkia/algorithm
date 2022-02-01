package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        String input = bufferedReader.readLine();

        int sum = 0;
        for(int i = 0 ; i < n; i ++){
            sum += Integer.parseInt(input.substring(i, i + 1));
        }
        System.out.println(sum);


    }
}
