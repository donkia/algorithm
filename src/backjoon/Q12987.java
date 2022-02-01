package backjoon;

import java.util.Arrays;

public class Q12987 {

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int idx_a = 0;
        int idx_b = 0;

        while(true){
            if(idx_b == A.length){
                break;
            }
            if(A[idx_a] < B[idx_b]){
                answer = answer + 1;
                idx_a ++;
                idx_b ++;
            }
            else{
                idx_b++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        System.out.println(solution(A, B));
    }
}
