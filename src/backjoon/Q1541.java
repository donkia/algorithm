package backjoon;

import javax.script.ScriptException;
import java.util.Scanner;

public class Q1541 {

    public static void main(String[] args) throws ScriptException {

        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();

        StringBuilder input = new StringBuilder("01+55-50-30+40+20-20+30");
        //StringBuilder input = new StringBuilder(sc.nextLine());

        String[] arr = input.toString().split("-");
        int sum = sum(arr[0].toString().split("[+]"));

        for(int i = 1; i < arr.length; i++){
            sum -= sum(arr[i].toString().split("[+]"));
        }
        System.out.println(sum);
    }

    static int sum(String[] brr){
        int temp = 0;
        for(int i = 0; i < brr.length; i++){
            temp += Integer.parseInt(brr[i]);
        }
        return temp;
    }


}
