package programmers;

public class P64062 {
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int cnt = 0;

        /*
        int sum = 0;
        boolean breakYN = false;
        while(true) {
            for (int i = 0; i < stones.length; i++) {

                if (stones[i] > 0) {
                    stones[i] = stones[i] - 1;
                    sum = 0;
                }

                else if (stones[i] == 0) {
                    sum = sum + 1;
                    if (sum >= k) {
                        breakYN = true;
                        break;
                    }
                }
            }
            if (breakYN == true) {
                break;
            } else {
                cnt = cnt + 1;
            }
            sum = 0;
        }
        answer= cnt;
        */

        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;

        while(low < high) {
            int mid = (low + high + 1) / 2;
            if (isOk(stones, mid, k)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean isOk(int[] stones, int n, int k){
        int sum = 0;
        for(Integer num : stones){
            if(num - n < 0){
                sum = sum + 1;
            }
            else {
                sum = 0;
            }
            if(sum == k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }

}
