package backjoon;

import javax.script.ScriptException;
import java.util.Scanner;

public class Q13305 {

    public static void main(String[] args) throws ScriptException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long[] distance = new long[(int) (n-1)];
        long[] price = new long[(int) n];

        for(int i = 0; i < n-1; i++){
            distance[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            price[i] = sc.nextInt();
        }

        long sum = 0;
        long prevPrice = price[0];
        for(int i = 0; i < n-1; i++){

            if(prevPrice > price[i]){
                prevPrice = price[i];
            }
            sum += distance[i] * prevPrice;
        }
        System.out.println(sum);
    }
}
