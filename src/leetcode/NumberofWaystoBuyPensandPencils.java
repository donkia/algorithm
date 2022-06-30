package leetcode;

/**
 * 문제 : https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/
 * 레벨 : Medium
 * 결과 : 해결(runtime 105ms faster than 5.05%, memory 41.1MB less than 48.48%)
 */
public class NumberofWaystoBuyPensandPencils {

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {

        long cnt = 0;
        long answer = 0;

        while(cnt * cost1 <= total){

            long remain = total - cnt * cost1;
            answer = answer + remain / cost2 + 1;
            cnt = cnt + 1;
        }
        return answer;
    }


    public static void main(String[] args) {
        int total = 20;
        int cost1 = 10;
        int cost2 = 5;
      /*  int total = 1000000;
        int cost1 = 1;
        int cost2 = 1;*/

        System.out.println(waysToBuyPensPencils(total, cost1, cost2));
    }
}
