package Top_Interview_Questions_2.dp;

public class Question121_买卖股票的最佳时机 {

    //只能买卖一次，遍历一遍，维护两个变量，当前买入最低价，以及当前卖出的最高价，一直更新maxP
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        if (prices == null || prices.length == 0)
            return maxProfit;

        int minPrice = prices[0];

        for (int i = 1 ; i < prices.length ;i++)
        {
            maxProfit = Math.max(maxProfit,prices[i] - minPrice);
            if (prices[i] < minPrice)
                minPrice = prices[i];
        }

        return maxProfit;

    }
}
