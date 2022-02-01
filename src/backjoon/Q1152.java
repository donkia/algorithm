package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        String[] input = str.split(" ");

        if(str.substring(0, 1).equals(" ")) {
            if(str.length() <= 1)
                System.out.println("0");
            else
                System.out.println(input.length - 1);
        }
        else
            System.out.println(input.length);
    }
}
