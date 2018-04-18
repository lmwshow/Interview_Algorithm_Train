package Top_Interview_Questions_2.again;

/**
 * 分析：
 *
 * 考虑用动态规划法解决问题，因为当前日期买卖股票的行为会受到之前日期买卖股票行为影响。
 *
 * 对一天的状态有：buy买入，sell卖出，cooldown冷却。
 *
 * 但是对于这一天是否持股只有两种状态：持股状态（buy），没有持股状态（sell，cooldown）。
 *
 * 对于当天持股状态时，至当天的为止的最大利润有两种可能：1、今天没有买入，跟昨天持股状态一样；2、今天买入，昨天是冷却期，利润是前天卖出股票时候得到的利润减去今天股票的价钱。 二者取最大值。
 *
 * 对于当天未持股状态，至当天为止的最大利润有两种可能：1、今天没有卖出，跟昨天未持股状态一样；2、昨天持有股票，今天卖出了，利润是昨天持有股票时候的利润加上今天股票的价钱。 二者取最大值。
 *
 * 直至最后一天的状态应该是卖出状态。最终利润为sell[n-1];
 *
 * 状态转移方程：
 *
 * sell[i] = max(sell[i-1], buy[i-1] + price[i]);
 *
 * buy[i] = max(buy[i-1], sell[i-2] - price[i]);
 *
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
 * 用状态图求解 很容易理解
 */
public class Question309_买卖股票带冷却期 {

    public static int maxProfit(int[] prices) {

        if (prices.length < 2)
            return 0;
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);

        for (int i = 2; i < n; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
        }

        return sell[n - 1];

    }
    
    public static void main(String[] args){
     
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
