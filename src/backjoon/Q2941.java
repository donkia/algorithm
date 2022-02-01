package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2941 {
    public static void main(String[] args) throws IOException {
        //입력값 셋팅
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(bufferedReader.readLine());
        //StringBuilder input = new StringBuilder("dz=ak");

        while(true) {
            if (input.indexOf("c=") >= 0) {
                int temp = input.indexOf("c=");
                input.replace(temp, temp + 2, "a");
            } else if (input.indexOf("c-") >= 0) {
                int temp = input.indexOf("c-");
                input.replace(temp, temp + 2, "a");
            } else if (input.indexOf("dz=") >= 0) {
                int temp = input.indexOf("dz=");
                input.replace(temp, temp + 3, "a");
            } else if (input.indexOf("d-") >= 0) {
                int temp = input.indexOf("d-");
                input.replace(temp, temp + 2, "a");
            } else if (input.indexOf("lj") >= 0) {
                int temp = input.indexOf("lj");
                input.replace(temp, temp + 2, "a");
            } else if (input.indexOf("nj") >= 0) {
                int temp = input.indexOf("nj");
                input.replace(temp, temp + 2, "a");
            } else if (input.indexOf("s=") >= 0) {
                int temp = input.indexOf("s=");
                input.replace(temp, temp + 2, "a");
            } else if (input.indexOf("z=") >= 0) {
                int temp = input.indexOf("z=");
                input.replace(temp, temp + 2, "a");
            } else {
                break;
            }
        }
        System.out.println(input.length());
    }
}