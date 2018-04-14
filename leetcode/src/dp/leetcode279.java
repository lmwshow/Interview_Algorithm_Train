package dp;

/**
 * Created by Gracecoder on 2017/3/28.
 * 如果我们能够记录已经找到的最少组合，那么稍大一些数只需要在此基础上添加若干个完全平方数即可，这里面就包含了动态规划的思想。
 * 定义一个dp数组，每个元素初始化为MAX_VALUE
 * dp[i]表示和为i的最少组合数
 * j在i的基础上，依次加每个整数的平方，直到超过n
 * 动态转移方程： dp[i+j*j] = min(dp[i+j*j],dp[i]+1)
 */
public class leetcode279 {

    public int numSquares(int n) {

        int[] dp = new int[n+1];
        for (int i = 0 ; i <= n ; i++)
            dp[i] = Integer.MAX_VALUE;

        dp[0] = 0;
        for (int i = 0 ; i <= n ; i++)
            for (int j = 1; i + j*j <= n ;j++)
                dp[i+j*j] = Math.min(dp[i+j*j],dp[i]+1);

        return dp[n];
    }

}
