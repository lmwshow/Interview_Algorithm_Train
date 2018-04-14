package Top_Interview_Questions.again;

/**
 * Created by Gracecoder on 2017/11/15.
 */
public class Partition_Equal_Subset_Sum {

    public boolean baoli_canPartition(int[] nums) {
        if(nums == null || nums.length == 0)
            return true;

        int sum = 0;
        for (int x : nums)
            sum += x;

        return dfs(nums,0,0,sum);
    }

    public boolean dfs(int[] nums,int start , int left,int right)
    {
        if(start == nums.length || left == right)
        {
            if(left == right)
                return true;
            else
                return false;
        }

        return dfs(nums,start+1,left+nums[start],right-nums[start])||dfs(nums,start+1,left,right);
    }


    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0)
            return true;

        int sum = 0;
        for (int x : nums)
            sum += x;

        if (sum % 2 == 1)
            return false;

        int tar = sum / 2;
        boolean[][] dp = new boolean[nums.length+1][tar+1];
        dp[0][0] = true;
        for (int i = 1 ; i < dp.length ; i++)
            dp[i][0] = nums[i-1]==0 && dp[i-1][0];

        for (int i = 1 ; i < dp.length ; i ++)
        {
            for (int j = 1; j <= tar ; j++)
            {

                if (nums[i-1] <= j)
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }


        return dp[nums.length][tar];
    }


    //一维背包
    public boolean betterdp_canPartition(int[] nums) {
        if(nums == null || nums.length == 0)
            return true;

        int sum = 0;
        for (int x : nums)
            sum += x;

        if (sum % 2 == 1)
            return false;

        int tar = sum / 2;

        boolean[] dp = new boolean[tar +1];

        dp[0] = true;

        for (int i = 1 ; i < nums.length ; i ++)
        {
            for (int j = tar; j >= 0 ; j--)
            {

                if (nums[i-1] <= j)
                    dp[j] = dp[j-nums[i-1]] || dp[j];
            }
        }


        return dp[tar];
    }

    public static void main(String[] args){
        boolean[] d = new boolean[2];

        System.out.println(d[0]);


    }
}
