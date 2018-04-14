package dp;

/**
 * Created by Gracecoder on 2017/2/9.
 */
public class leetcode121 {

    /*
    暴力：双循环，超时
     */
    public static int max(int[] prices)
    {
        int max = 0;
        for (int i = 0 ; i < prices.length ; i ++)
            for (int j = i + 1; j < prices.length ; j ++)
                max = (prices[j] - prices[i]) > max ? (prices[j] - prices[i]) : max;
        return max;
    }

    /*
    数组下标表示价格，数值表示是否存在
     */
    public static int myFunc(int[] prices)
    {
        int max = 0;
        for (int i = 0 ; i < prices.length; i++)
            max = (prices[i] > max)? prices[i]:max;

        int[] nums = new int[max + 1];
        for (int i = 0 ; i < prices.length ; i++)
            nums[prices[i]] ++;                         //nums 下标表示价格，数值n表示有n天存在该价格，

        max = 0;
        for (int i = prices.length - 1 ; i >= 0 ; i--) {
            for (int j = 0; j < prices[i] - max; j++)       //i倒着遍历，因为需要先买入，j从0遍历到prices[i] - max, 再上去就取不到Max
                if (nums[j] > 0) {
                    max = prices[i] - j;
                    nums[prices[i]] --;
                    break;
                }

            nums[prices[i]] --;
        }
        return max;
    }

    /*
     只需要遍历一次数组，通过一个变量记录当前最低价格，同时算出此次交易利润，并与当前最大值比较即可
     */

    public static int maxProfit(int[] prices)
    {
        if (prices.length <= 1)
            return 0;

        int minP = prices[0];
        int profit = prices[1] - prices[0];
        for (int i = 2 ; i < prices.length ; i ++)
        {
            minP = Math.min(prices[i-1],minP);
            profit = Math.max(prices[i] - minP , profit);
        }

        if (profit < 0)
            return 0;

        return profit;
    }

    public static void main(String[] args){

        int[] prices = {2,2,5};
        int max = max(prices);
        System.out.println(max);
        

    }
}
