package programmers;

public class P87946 {

    static int max = 0;

    public static void DFS(int k, int[][] dungeons, int cnt){

        if(max < cnt){
            max = cnt;
        }
        for(int i = 0; i < dungeons.length; i++){

            if(dungeons[i][0] == 0) continue;

            int minTired = dungeons[i][0];
            int useTired = dungeons[i][1];

            if(k >= minTired){
                dungeons[i][0] = 0;
                dungeons[i][1] = 0;
                DFS(k-useTired, dungeons, cnt + 1);
                dungeons[i][0] = minTired;
                dungeons[i][1] = useTired;
            }
        }
    }

    public static int solution(int k, int[][] dungeons){
        int answer = -1;

        for(int i = 0; i < dungeons.length; i++){

            if(dungeons[i][0] == 0) continue;

            int minTired = dungeons[i][0];
            int useTired = dungeons[i][1];

            if(k >= minTired){
                dungeons[i][0] = 0;
                dungeons[i][1] = 0;
                DFS(k-useTired, dungeons, 1);
                dungeons[i][0] = minTired;
                dungeons[i][1] = useTired;

            }

        }
        answer = max;
        return answer;
    }


    public static void main(String[] args) {

        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };

        System.out.println(solution(k, dungeons));
    }
}
