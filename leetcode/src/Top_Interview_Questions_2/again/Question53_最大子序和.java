package Top_Interview_Questions_2.again;

public class Question53_最大子序和 {


    //动态规划，dp[i] 表示以i为结尾的子串的最大值
    //        dp[i] = max(dp[i-1]+nums[i],nums[i])
    public static int maxSubArray(int[] nums) {

        if (nums == null||nums.length == 0)
            return 0;

        int ans = 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        ans = dp[0];
        for (int i = 1; i < len; i++)
        {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);

            ans = Math.max(ans,dp[i]);
        }


        return ans;
    }


    public static void main(String[] args){

        int ans = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    
    }
}
