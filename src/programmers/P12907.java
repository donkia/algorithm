package programmers;

import java.util.*;

public class P12907 {

    public static int solution(int n, int[] money) {
      //  int answer = 0;

       /* Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();

        Arrays.sort(money);
        for(int i = money.length-1; i >=0 ; i --){
            al.add(money[i]);
        }

        for(int i = 0; i < al.size(); i++){
            if(n >= al.get(i)){
                queue.add(new int[]{n-al.get(i), i, 0});
            }
        }

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int price = poll[0];
            int idx = poll[1];
            int cnt = poll[2];

            if(price == 0){
                answer = answer + 1;
                answer = answer % 1000000007;
                continue;
            }


            for(int i = idx; i < al.size() ;i++){
                if(price - al.get(i) >= 0){
                    queue.add(new int[]{price - al.get(i), i, cnt + 1});
                }
            }

        }*/
        int[] answer = new int[100001];
        answer[0] = 1;
        for(int i : money) {
            for(int j = i; j <= n; j++) {
                answer[j] += answer[j-i];
            }
        }
        return answer[n];

    }

    public static void main(String[] args) {

        int n = 5;
        int[] money = {1, 2, 5};

        System.out.println(solution(n, money));
    }
}


