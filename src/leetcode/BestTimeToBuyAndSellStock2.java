package leetcode;

/**
 * 문제 : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iiv/
 * 레벨 : Medium
 * 결과 : 해결(runtime 1ms faster than 84.92%, memory 44MB less than 27.79%)
 */


public class BestTimeToBuyAndSellStock2 {


    public static int maxProfit(int[] prices) {

        // 오름차순인지 확인
        boolean isAcs = true;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] >= prices[i]) {
                isAcs = false;
                break;
            }
        }

        if (isAcs == true) {
            return prices[prices.length - 1] - prices[0];
        }

        // 내림차순인지 확인
        boolean isDesc = true;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] <= prices[i]) {
                isDesc = false;
                break;
            }
        }

        if (isDesc == true) {
            return 0;
        }

        // 그렇지않으면
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                sum = sum + prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        //int[] prices = {7, 1, 5, 3, 6, 4};
        //int[] prices = {1,2,3,4,5};
        //int[] prices = {7, 6, 4, 3,1};
        int[] prices = {7};


        System.out.println(maxProfit(prices));
    }
}
