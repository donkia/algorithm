package codingTest;

import java.util.Arrays;

public class Q2_20220320 {

    public static int[] solution(int[] black_caps) {
        int[] answer = new int[black_caps.length];

        // 맨 처음 사람 확인
        if(black_caps[0] == 0){
            answer[1] = 2;
        }
        else if(black_caps[0] == 1){
            answer[1] = 1;
        }

        // 맨 마지막 사람 확인
        if(black_caps[black_caps.length-1] == 0){
            answer[black_caps.length-2] = 2;
        }
        else if(black_caps[black_caps.length-1] == 1){
            answer[black_caps.length-2] = 1;
        }

        for(int k = 0; k < 7000; k++) {
            for (int i = 1; i < black_caps.length - 1; i++) {

                if (black_caps[i] == 0) {
                    answer[i - 1] = 2;
                    answer[i + 1] = 2;
                } else if (black_caps[i] == 1) {
                    if (answer[i - 1] == 2) {
                        answer[i + 1] = 1;
                    } else if (answer[i - 1] == 1) {
                        answer[i + 1] = 2;
                    }  else if (answer[i - 1] == 0) {

                        if (answer[i + 1] == 0) {
                        } else if (answer[i + 1] == 1) {
                            answer[i - 1] = 2;
                        } else if (answer[i + 1] == 2) {
                            answer[i - 1] = 1;
                        }
                    }
                } else if (black_caps[i] == 2) {
                    answer[i - 1] = 1;
                    answer[i + 1] = 1;
                }
            }
            System.out.println(Arrays.toString(answer));
        }


        return answer;
    }


    public static void main(String[] args) {
        //int[] black_caps = {1, 1, 2, 0};
        //int[] black_caps = {1, 1, 1};
        //int[] black_caps = {0, 1, 1, 1, 1};
        //int[] black_caps = {0, 1, 0, 1};
        //int[] black_caps = {1, 0, 2, 0, 1, 0 ,1 ,0};
        //int[] black_caps = {0,1,1,1,1,0};
        int[] black_caps = {1,1,1};



        System.out.println(solution(black_caps));

    }

}
