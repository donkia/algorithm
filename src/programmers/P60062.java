package programmers;

public class P60062 {

    static int answer;
    public static void DFS(int n, int[] weak, int[] dist, int cnt, int[] map){

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += map[i];
        }

        if(sum == 0){
            if(answer > cnt)
                answer = cnt;
            return;
        }

        int distSum = 0;
        for(int i = 0; i < dist.length; i++){
            distSum += dist[i];
        }
        if(distSum == 0){
            return;
        }




    }


    public static int solution(int n, int[] weak, int[] dist) {
        answer = 0;

        int[] map = new int[n];

        for(int i = 0; i < weak.length; i ++){
            if(weak[i] != 0)
                map[i] = 1;
        }




        return answer;
    }


    public static void main(String[] args) {

        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};
        System.out.println(solution(n, weak, dist));

    }
}
