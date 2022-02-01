package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class Q15970 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        // 입력값 받고 HashMap 구성
        for(int i = 0; i < n ; i++){
            String[] input = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int color = Integer.parseInt(input[1]);

            if(hm.containsKey(color)){
                ArrayList<Integer> al = hm.get(color);
                al.add(x);
                hm.put(color, al);
            }
            else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(x);
                hm.put(color, al);
            }
        }
        // map 안에 있는 숫자들 정렬
        for(int m : hm.keySet()){
            ArrayList<Integer> temp = hm.get(m);
            Collections.sort(temp);
            hm.put(m, temp);
        }

        int sum = 0;
        // map에 있는 인자들 덧셈하기
        for(int m : hm.keySet()){
            ArrayList<Integer> temp = hm.get(m);
            for(int i = 0; i < temp.size(); i++){
                //키의 첫번째 value이면 get(1)- get(0) 구하기
                if(i == 0){
                    sum += temp.get(1) - temp.get(0);
                }
                //키의 마지막 value이면 get(마지막) - get(마지막-1 인덱스) 구하기
                else if(i == temp.size()-1){
                    sum += temp.get(i) - temp.get(i - 1);
                }
                else{
                    sum += Math.min(temp.get(i) - temp.get(i - 1), temp.get(i + 1) - temp.get(i));
                }
            }
        }
        System.out.println(sum);
    }
}
