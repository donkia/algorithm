package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < k; i++){
            int nTemp = Integer.parseInt(bufferedReader.readLine());
            if(nTemp != 0){
                stack.push(nTemp);
            }
            else if(nTemp == 0){
                stack.pop();
            }

        }

        long sum = 0;
        for(Integer n : stack){
            sum += n;
        }

        System.out.println(sum);

    }

}
