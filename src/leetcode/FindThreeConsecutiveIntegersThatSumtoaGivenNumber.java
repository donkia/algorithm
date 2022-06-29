package leetcode;

/**
 * 문제 : https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/
 * 레벨 : Medium
 * 결과 : 해결(runtime 0ms faster than 100.0%, memory 40.6MB less than 85.13%)
 */
public class FindThreeConsecutiveIntegersThatSumtoaGivenNumber {

    public static long[] sumOfThree(long num) {

        long[] answer = new long[3];

        if(num % 3 == 0){
            answer[0] = num / 3 - 1;
            answer[1] = num / 3;
            answer[2] = num / 3 + 1;

            return answer;
        }
        else{
            long[] emptyArray ={};
            return emptyArray;
        }


    }

    public static void main(String[] args) {
        long num = 4;
        System.out.println(sumOfThree(num));
    }
}
