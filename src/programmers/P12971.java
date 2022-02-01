package programmers;

import java.util.Arrays;
public class P12971 {

    public static int solution(int sticker[]) {
        int answer = 0;

        int lastIdx = sticker.length - 1;
        int[] map1 = Arrays.copyOf(sticker, sticker.length); //맨 처음 인덱스를 선택
        int[] map2 = Arrays.copyOf(sticker, sticker.length); //맨 처음 인덱스 선택X

        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        map1[lastIdx] = 0; // 맨 마지막 인덱스 0으로 셋팅
        map2[0] = 0;       // 맨 처음 인덱스 0으로 셋팅


        dp1[0] = map1[0];
        dp2[0] = 0;

        if(sticker.length ==1 ){
            return sticker[0];
        }
        else if(sticker.length == 2){
            return Math.max(sticker[0], sticker[1]);
        }
        dp1[1] = map1[1];
        dp2[1] = map2[1];

        dp1[2] = dp1[0] + sticker[2];
        dp2[2] = dp2[0] + sticker[2];

        for(int i = 3; i < sticker.length; i++){
            dp1[i] = Math.max(dp1[i - 2], dp1[i - 3]) + map1[i];
            dp2[i] = Math.max(dp2[i - 2], dp2[i - 3]) + map2[i];

        }
        answer = Math.max(Math.max(dp1[lastIdx], dp2[lastIdx]), dp1[lastIdx-1]);

        return answer;
    }

    public static void main(String[] args) {

        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        //int[] sticker = {9,1, 1, 9, 1};


        System.out.println(solution(sticker));
    }

}
