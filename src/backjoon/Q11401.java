package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11401 {

    static final int DIV = 1000000007;
    public static long divide_and_conquer(long n) {

        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum = (sum * i) % DIV;
        }
        return sum;
    }

    static long pow(long a, long b) {

        if (b == 1) return a % DIV;

        long temp = pow(a, b / 2);

        if (b % 2 != 0) {
            return (temp * temp % DIV) * a % DIV;
        }
        return temp * temp % DIV;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");

        long n = Long.parseLong(input[0]);
        long k = Long.parseLong(input[1]);

        long up = divide_and_conquer(n); //분자
        long down = divide_and_conquer(k) * divide_and_conquer(n - k) % DIV; //분모
        System.out.println(up * pow(down, DIV - 2) % DIV);
    }
}
