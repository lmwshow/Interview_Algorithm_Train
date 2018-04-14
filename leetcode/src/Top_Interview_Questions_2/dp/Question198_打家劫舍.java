package Top_Interview_Questions_2.dp;

public class Question198_打家劫舍 {

    //动态规划，划分子问题 dp[i]表示 抢(1...i个房子)时的最大收益
    //dp[i] = max(num[i-1]+dp[i-2],dp[i-1])
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int dp[] = new int[nums.length+1];
        dp[1] = nums[0];

        for (int i = 2;i <= nums.length;i++)
            dp[i] = Math.max(nums[i-1]+dp[i-2],dp[i-1]);

        return dp[nums.length];

    }
}
