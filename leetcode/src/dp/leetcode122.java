package dp;

/**
 * Created by Gracecoder on 2017/2/28.
 */
public class leetcode122 {
    public int maxProfit(int[] prices) {

        if (prices.length <= 1 )
            return 0;
        int finalProfit = 0 ;
        int minP = prices[0];
        for (int i = 1 ; i < prices.length ; i++)
        {
            if (prices[i] > minP)
                finalProfit += prices[i] - minP;

            minP = prices[i];

        }

        return finalProfit;
    }
}
