package dp;

/**
 * Created by Gracecoder on 2017/2/24.
 */
public class leetcode123 {

    //只能交易两次，且必须在卖出之后才能购买
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1)
            return 0;

        int minP = prices[0];
        int maxP = prices[length-1];
        int[] profits = new int[length];
        //profits[i]用来表示遍历到第i天时的最大利润
        int profit = prices[1] - prices[0];
        //第一次正向遍历
        for (int i = 2 ; i < length ; i ++)
        {
            minP = Math.min(prices[i - 1], minP);
            profits[i] = Math.max(profit,prices[i] - minP);
            profit = profits[i];
        }
        int profit2;

        //反向遍历
        for (int i = length - 2; i>=0 ; i--)
        {
            maxP = Math.max(prices[i + 1],maxP);
            profit2 = maxP - prices[i];

            if (profit2 > 0)
            {
                profits[i] = profits[i] + profit2;
                profit = Math.max(profit,profits[i]);

            }
        }

        return profit>0? profit:0;

    }
}
