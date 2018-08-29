package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/25 09:25
 * @Description: 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 */
public class 目标和 {

    /*
        求方案数首先想到动态规划

        这道题的本质是找一个正数子集P和剩下的负数子集N  使得 sum(P) - sum(N) = target
        又有 sum(P) + sum(N) = sum  ----> 2*sum(P) = target + sum
     */

    public int best_findTargetSumWays(int[] nums, int s) {

        int sum = 0;
        for (int num : nums)
            sum += num;

        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);

    }

    /*
        因为我们已经将每个节点的状态变为只有+，所以可以用一维dp来求解
        dp[i]表示和为i的方案数，dp[i] += dp[i-num]
    */
    private int subsetSum(int[] nums, int s) {

        int[] dp = new int[s + 1];
        dp[0] = 1;

        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];

        return dp[s];

    }

    /*
        如果没有发现本质，就无法降维，那每个数字就会有两种选择，+或-。
        动态规划 dp[i][j] 表示到第i个数字时，target为j的组合数
                dp[i][j] = dp[i-1][j-num[i]] + dp[i-1][j+num[i]]

        因为可能是负数，所以需要加偏移量!
     */

    static int IMAX = 21;
    static int JMAX = 5005;
    static int off = 2003;

    public int findTargetSumWays(int[] nums, int s) {

        if (s > 1000)
            return 0;

        int[][] dp = new int[IMAX][JMAX];

        //如果最后dp[0] = 0,那么最终结果需要*2,因为有+0,-0两个状态
        dp[0][nums[0] + off] = dp[0][-nums[0] + off] = 1;

        for (int i = 1; i < nums.length; i++)
            for (int j = -1000; j <= s + 1000; j++)
                dp[i][j + off] = dp[i - 1][j + off - nums[i]] + dp[i - 1][j + off + nums[i]];

        return nums[0] != 0 ? dp[nums.length - 1][s + off] : dp[nums.length - 1][s + off] * 2;

    }

    static int ans;

    //深搜虽然AC,但是时间复杂度有点高
    public static  int DFSfindTargetSumWays(int[] nums, int S) {

        ans = 0;
        if (nums == null || nums.length == 0) {
            if (S != 0)
                return ans;
            else
                return 1;
        }

        dfs(nums,0,S);

        return ans;
    }

    private static void dfs(int[] nums, int index, int target) {

        if (index == nums.length)
        {
            if (target == 0)
                ans++;

            return;
        }

        dfs(nums,index +1, target - nums[index]);
        dfs(nums,index +1, target + nums[index]);
    }
}
