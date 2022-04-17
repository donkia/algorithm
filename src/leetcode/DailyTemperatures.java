package leetcode;

/**
 * 문제 : https://leetcode.com/problems/daily-temperatures/
 * 레벨 : Medium
 * 결과 : 해결(runtime 1130ms faster than 10.31%, memory 52.0MB less than 97.12%)
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] answer = new int[temperatures.length];
        answer[temperatures.length-1] = 0;

        for(int i = 0; i < temperatures.length-1; i++){
            for(int j = i+1; j < temperatures.length; j++){

                if(temperatures[i] < temperatures[j]){
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 79, 72, 76, 73};
        System.out.println(dailyTemperatures(temperatures));

    }


}
