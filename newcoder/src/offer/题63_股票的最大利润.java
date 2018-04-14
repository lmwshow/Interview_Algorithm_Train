package offer;

public class 题63_股票的最大利润 {

    public int MaxProfit(int[] nums)
    {
        if (nums == null || nums.length < 2)
            return 0;

        int curMin = nums[0];
        int maxProfit = 0;

        for (int i = 1; i < nums.length ; i++)
        {
            if (nums[i] - curMin > maxProfit)
                maxProfit = nums[i] - curMin;

            if (nums[i] < curMin)
                curMin = nums[i];
        }


        return maxProfit;
    }
}
