package dp;

/**
 * Created by Gracecoder on 2017/2/10.
 *
 * 根据他的解法，此题需要维护三个一维数组buy, sell，和rest。其中：

 buy[i]表示在第i天之前最后一个操作是买，此时的最大收益。 即第i天为买

 sell[i]表示在第i天之前最后一个操作是卖，此时的最大收益。

 rest[i]表示在第i天之前最后一个操作是冷冻期，此时的最大收益。

 我们写出递推式为：

 buy[i]  = max(rest[i-1] - price, buy[i-1])
 sell[i] = max(buy[i-1] + price, sell[i-1])
 rest[i] = max(sell[i-1], buy[i-1], rest[i-1])

 上述递推式很好的表示了在买之前有冷冻期，买之前要卖掉之前的股票。
 一个小技巧是如何保证[buy, rest, buy]的情况不会出现，这是由于buy[i] <= rest[i]， 即rest[i] = max(sell[i-1], rest[i-1])，
 即冷冻期前面只可能是冷冻期或者卖，绝对不会出现买！这保证了[buy, rest, buy]不会出现。

 另外，由于冷冻期的存在，我们可以得出rest[i] = sell[i-1]，这样，我们可以将上面三个递推式精简到两个：

 buy[i]  = max(sell[i-2] - price, buy[i-1])
 sell[i] = max(buy[i-1] + price, sell[i-1])

 */
public class leetcode309 {

    //优化下方O(n) 辅助空间为1
    public static int maxProfit(int[] prices)
    {
        int sell = 0, prev_sell = 0 , buy = Integer.MIN_VALUE , prev_buy;
        for (int price : prices)
        {
            prev_buy = buy;
            buy = Math.max(prev_buy , prev_sell - price);
            prev_sell = sell;
            sell = Math.max(prev_sell , prev_buy + price);

        }

        return sell;
    }

    public static int maxProfitON(int[] prices)
    {
        int size = prices.length;
        int[] buy = new int[size];
        int[] sell = new int[size];
        if (size < 2)
            return 0;

        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0],-prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(sell[0],buy[0]+prices[1]);

        //buy[i]  = max(rest[i-1]-price, buy[i-1])
        //sell[i] = max(buy[i-1]+price, sell[i-1])
        //根据最初始的状态转移方程，先写出来初始化

        for (int i = 2 ; i < prices.length ; i ++)
        {
            buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1],buy[i-1] + prices[i]);
        }

        return sell[size-1];

    }

    public static void main(String[] args){

        int[] prices = {1, 2, 3, 0, 2};
        int profit = maxProfitON(prices);
        System.out.println(profit);


    }
}
