package dp;

/**
 * Created by Gracecoder on 2017/3/1.
 */
public class leetcode53 {
    public int maxSubArrayTimeLimitExceeded(int[] nums) {

        int length = nums.length;
        if (length < 1)
            return 0;
        int[][] dp = new int[length][length];
        int max = nums[0];

        for (int i = 0 ;i < length ; i ++) {
            dp[i][i] = nums[i];
            max = Math.max(max, dp[i][i]);
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    //dp的关键是找到一个合适的子问题，该子问题需要能够和我们最终的目标有联系
    //状态定义: dp[i][j] 表示A[i]-A[j]之间的最大子连续串的和 ， 那最终是要求A[0][length-1]  ，两者联系不明显  这个子问题定义的不行
    //状态定义: dp[i] 表示以i结尾的最大子连续串和， 目标则是求 dp其中的最大值
    //状态转移方程： dp[i] = max(dp[i-1]+nums[i],nums[i])
    public int maxSubArray(int[] nums) {

        int length = nums.length;
        if (length < 1)
            return 0;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1 ; i < length ; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i],max);
        }

        return max;

    }

    //二分法
    //假设数组存在最大区间，mid = (left + right)/2 ,无非就三种情况：
    //  1.最大值在A[left，mid-1]里面
    //  2.最大值在A[mid+1, right]里面
    //  3.最大值跨过了mid，也就是我们需要计算[left，mid - 1] 区间的最大值，以及[mid + 1，right] 的最大值，然后加上mid，三者之和就是总的最大值
    public int maxSubArrayDivide(int[] nums)
    {
        return divide(nums,0,nums.length - 1,Integer.MIN_VALUE);
    }

    public int divide(int[] nums, int left, int right , int tmax)
    {
        //首先是递归的退出条件
        if (left > right)
            return Integer.MIN_VALUE;

        int mid = left + (right - left)/2;
        //得到左子区间的最大值
        int lmax = divide(nums,left,mid -1 ,tmax);
        //得到右子区间的最大值
        int rmax = divide(nums,mid + 1 , right , tmax);

        tmax = Math.max(tmax,lmax);
        tmax = Math.max(tmax,rmax);

        int sum = 0 ;
        int mlmax = 0 ;
        //得到左区间最大值的具体方法
        for (int i = mid -1 ; i >= left ; i--)
        {
            sum += nums[i];
            mlmax = Math.max(mlmax,sum);
        }

        //得到右区间最大值的具体方法
        sum = 0 ;
        int mrmax = 0 ;
        for (int i = mid+1; i <= right ; i++)
        {
            sum += nums[i];
            mrmax = Math.max(mrmax,sum);
        }

        //每次迭代都要更新tmax,即算出那一小区间段的 最大和
        tmax = Math.max(tmax , nums[mid] + mlmax + mrmax);
        return tmax;
    }
}
