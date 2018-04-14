package dp;

/**
 * Created by Gracecoder on 2017/2/8.
 */
public class leetcode494_BestTimetoBuyandSellStock {

    final static int ofs = 2003;       //偏移量
    final static int maxn = 25;
    final static int maxm = 5005;
    static int[][] dp = new int[maxn][maxm];

    //0-1 背包 http://blog.csdn.net/lzedo/article/details/54710142
    // dp[i][j] : 表示选过第i个数后，和为j的方案数
    // 状态转移方程： dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]       即放完第i-1的东西后， 加上 或者 减掉 第i个数 能够达到目标j的方案数

    public static int solotion(int[] nums,int s)
    {
        if (s > 1000) return 0;

        dp[0][nums[0] + ofs] = dp[0][-nums[0] + ofs] = 1;
        for (int i = 1 ; i < nums.length ; i ++)
        {
            for (int j = -1000 ; j <= s + 1000; j ++)
                dp[i][j + ofs] = dp[i-1][j-nums[i] + ofs] + dp[i-1][j+nums[i] + ofs];
        }

        return nums[0]!=0? dp[nums.length - 1][s + ofs]:dp[nums.length - 1][s + ofs]*2;
    }

    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    //https://leetcode.com/problems/target-sum/?tab=Solutions

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }


    public static void main(String[] args){

        int[] nums = new int[]{0,0,0,0,0,0,0,1000};
        System.out.println(solotion(nums,-1000));

    }
}
