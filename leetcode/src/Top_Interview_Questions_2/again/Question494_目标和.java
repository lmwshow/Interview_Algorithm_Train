package Top_Interview_Questions_2.again;

/**
 * @Auther: minGW
 * @Date: 2018/4/28 08:58
 * @Description: https://leetcode-cn.com/problems/target-sum/description/
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

   返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 */
public class Question494_目标和 {



    //最快方法
    //https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C++-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
    // 本质问题是找一个正数子集P和剩下的负数子集N 使得 sum(P)-sum(N) = target
    // sum(P)+sum(N) + sum(P)-sum(N) = sum +target = 2*sum(P)
    public int Best_findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    static int ans;
    //对于需要加偏移量的dp！！！
    //动态规划 dp[i][j] 表示到第i个数字时，target为j的组合数
    //        dp[i][j] = dp[i-1][j-num[i]]+dp[i-1][j+num[i]]

    static int IMAX = 21;
    static int JMAX = 5005;
    static int off = 2003;
    public static  int findTargetSumWays(int[] nums, int S) {



        if(S > 1000)
            return 0;

        int[][] dp = new int[IMAX][JMAX];


        dp[0][nums[0]+off] = dp[0][-nums[0] + off] = 1;
        for (int i = 1; i < nums.length ; i++)
            for (int j = -1000 ; j <= S+1000;j++)
                dp[i][j+off] = dp[i-1][j+off-nums[i]] + dp[i-1][j+off+nums[i]];


        return nums[0]!=0?dp[nums.length-1][S+off]:dp[nums.length-1][S+off]*2;

    }



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

    public static void main(String[] args){
        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
}
