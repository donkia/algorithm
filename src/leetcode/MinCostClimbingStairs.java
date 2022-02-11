package leetcode;

/** 문제 : https://leetcode.com/problems/min-cost-climbing-stairs/
 *  레벨 : Easy
 *  결과 : 해결(runtime faster than 17.55%, memory less than 21.01%)
 * */
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {

        int[][] map = new int[3][cost.length];

        map[0][0] = cost[0];
        map[1][0] = cost[0];
        map[2][0] = 0;

        for(int i = 1; i < cost.length; i++){
            map[0][i] = map[2][i-1] + cost[i];
            map[1][i] = map[0][i - 1] + cost[i];
            map[2][i] = Math.min(map[0][i - 1], map[1][i - 1]);
        }

        return Math.min(map[2][cost.length - 1], Math.min(map[0][cost.length - 1], map[1][cost.length - 1]));

    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
//        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        System.out.println(minCostClimbingStairs(cost));
    }
}
