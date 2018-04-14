package dp;

/**
 * Created by Gracecoder on 2017/3/3.
 */
public class leetcode70 {

    //easy
    public int climbStairs(int n) {

        switch (n)
        {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3 ; i <= n ; i ++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }
}
