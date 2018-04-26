package Top_Interview_Questions_2.again;

import java.util.Arrays;

/**
 * @Auther: minGW
 * @Date: 2018/4/26 08:34
 * @Description
 */
public class Question416_是否可以化为两个和相等的子集 {

    static boolean ans;

    //Each of the array element will not exceed 100.
    //The array size will not exceed 200.
    //MAX_SUM等于20000， target最大为10000
    //可以使用动态规划，典型的01背包问题

    //二维数组
    public static boolean DPcanPartition(int[] nums) {

        ans = false;

        if (nums == null || nums.length == 0)
            return true;

        Arrays.sort(nums);

        int sum = 0;
        for (int x : nums)
            sum += x;
        if ((sum & 1) == 1)
            return ans;

        sum = sum >> 1;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++)
            dp[i][0] = true;

        for (int i = 1; i <= nums.length; i++)
            for (int j = 1; j <= sum; j++) {
                if (dp[i - 1][j])
                    dp[i][j] = true;

                if (j >= nums[i - 1])
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
            }


        return dp[nums.length][sum];


    }


    //一维优化
    public static boolean canPartition(int[] nums) {

        ans = false;

        if (nums == null || nums.length == 0)
            return true;

        Arrays.sort(nums);

        int sum = 0;
        for (int x : nums)
            sum += x;
        if ((sum & 1) == 1)
            return ans;

        sum = sum >> 1;

        boolean[] dp = new boolean[sum+1];

        dp[0] = true;

        for (int i = 0 ; i < nums.length; i++)
        {
            for (int j = sum ; j >= 0; j--)
                if (j-nums[i] >=0)
                    dp[j] |= dp[j-nums[i]];
        }

        return dp[sum];
    }



        //DFS 超时
    public static boolean DFScanPartition(int[] nums) {

        ans = false;

        if (nums == null || nums.length == 0)
            return true;

        Arrays.sort(nums);

        int sum = 0;
        for (int x : nums)
            sum += x;
        if ((sum & 1) == 1)
            return ans;
        else
            dfs(nums, sum >> 1, 0);

        return ans;

    }

    private static void dfs(int[] nums, int target, int start) {

        if (ans)
            return;
        if (target == 0) {
            ans = true;
            return;
        }


        for (int i = start; i < nums.length; i++) {
            if (ans || target < nums[i])
                break;

            dfs(nums, target - nums[i], i + 1);
        }


    }


    public static void main(String[] args) {

        System.out.println(canPartition(new int[]{1, 2, 5}));


    }
}
