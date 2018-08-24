package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/23 13:43
 * @Description:
 */
public class 买卖股票带冷却期 {

    //动态规划: 可以使用状态图，一共就三个action:买，卖，冷却。三个状态s0,s1,s2
    /*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
        到达s0的路径有：s2- rest ->s0, s0- rest ->s0
        到达s1的路径有： s0- buy ->s1,s1- rest ->s1
        到达s2的路径有： s1- sell ->s2
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];

        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length ; i++)
        {
            s0[i] = Math.max(s0[i-1],s2[i-1]);
            s1[i] = Math.max(s1[i-1],s0[i-1] - prices[i]);
            s2[i] = s1[i-1] + prices[i];

        }

        return Math.max(s2[prices.length - 1],s0[prices.length-1]);

    }
}
