package dp.dfs_backtracking查找;

/**
 * Created by Gracecoder on 2017/4/17.
 * dp: dp[i]表示sum为i 的组合数个数
 */
public class leetcode377组合数之和4 {

    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target +1];
        dp[0] = 1;

        for (int i = 1; i <= target ; i++)
            for( int j = 0 ; j < nums.length ; j++)
                if (i - nums[j]>=0)
                    dp[i] += dp[i-nums[j]];
        return dp[target];
    }
}
