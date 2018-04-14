package offer;


//1.O(n^2)   2.O(nlgn)    3.O(n)

//3.动态规划   dp[i] 表示以i为结束的子序列最大和，dp[i]=dp[i-1]>0?(dp[i-1]+num[i]):num[i];
public class 题42_连续子数组的最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0)
            return 0;
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1 ; i < dp.length ; i++)
        {
            dp[i]=dp[i-1]>0?(dp[i-1]+array[i]):array[i];
            max = dp[i]>max?dp[i]:max;
        }

        return max;
    }
}
