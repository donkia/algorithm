package programmers;

import java.lang.reflect.Array;
import java.util.*;

public class P12936 {


    public static long factorial(int n){
        long sum = 1;
        while(n >= 1){
            sum = sum * n;
            n = n -1;
        }

        return sum;
    }



    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        int num = n;
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> permutation = new ArrayList<>();

        for(int i = 1; i <= n ; i++){
            al.add(i);
        }
        k = k -1;
       // int factorial = factorial(n);
        while(permutation.size() < num) {
            long first = factorial(n-1);
            long mod = (k / first);
            int remainder = (int) (k % first);


            k = remainder;

            permutation.add(al.get((int) mod));
            al.remove(mod);
            n = n - 1;
        }
        //System.out.println(permutation);

        for(int i = 0; i < num; i++){
            answer[i] = permutation.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        long k = 5;
        System.out.println(solution(n, k));

    }
}
