/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions
 *
 * as you like (ie, buy one and sell one share of the stock multiple times) with the
 *
 * following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the
 * stock before you buy again).
 *
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 * */

package dynamic_programming.best_time_to_buy_and_sell_stock_with_cooldown_309;

public class Solution {
    public int maxProfitSellAndBuy(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] sell = new int[n];
        int[] buy = new int[n];
        sell[0] = 0;
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++){
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            buy[i] = Math.max(buy[i-1], (i > 1? sell[i-2]:0) - prices[i]);
        }
        return sell[n-1];
    }


    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] cooldown = new int[n];
        int[] hold = new int[n];
        int[] sold = new int[n];
        cooldown[0] = 0;
        sold[0] = 0;
        // 这个初始状态很重要。如果这个初始状态不对的话，会影响最终的结果。
        hold[0] = -prices[0];
        for ( int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i -1], cooldown[i-1] - prices[i]);
            sold[i] = hold[i-1] + prices[i];
            cooldown[i] = Math.max(cooldown[i-1], sold[i-1]);
            System.out.println("" + hold[i]);
        }
        return Math.max(cooldown[n-1], sold[n-1]);
    }


    public static void main(String[] arguments) {
        Solution solution = new Solution();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.printf("" + solution.maxProfit(prices));
    }
}
