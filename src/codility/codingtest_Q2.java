package codility;

import java.util.HashSet;

/** 2. 문제 -> 틀린 부분 수정문제. 최대 2줄 고치기
 * test case 정답 후 제출
 * */

public class codingtest_Q2 {

    public static boolean solution1(int[] A, int K) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            hs.add(A[i]);
        }
        return true;
    }

    public static boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1])
                return false;
        }
        // 추가한 부분
        if(A[n-1] < K)
            return false;
        if (A[0] != 1 && A[n - 1] != K)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 3};
        int K = 4;
        System.out.println(solution(A, K));

        
    }

}
