package dp;

/**
 * Created by Gracecoder on 2017/3/3.
 */
public class leetcode152 {


    /*
    求最大乘积，对于乘法，我们需要注意，负数乘以负数，会变成正数
    所以解这道题需要维护两个变量，当前的最大值以及最小值，最小值可能为负数，
    但没准下一步乘以一个负数，当前的最大值就变成了最小值，而当前的最小值则变成了最大值

    动态方程：
    maxDP[i] = max(maxDP[i-1]*A[i],A[i],minDP[i-1]*A[i])
    minDP[i] = min(minDP[i-1]*A[i],A[i],maxDP[i-1]*A[i])
    dp[i] = max(dp[i-1],maxDP[i])
     */

    public int maxProduct(int[] nums) {

        int length = nums.length;
        if (length < 1)
            return 0;
        int finalMax = nums[0] ;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1 ; i < length ; i++) {

            int t =max;

            max = Math.max(Math.max(max*nums[i],nums[i]),min*nums[i]);

            min = Math.min(Math.min(min*nums[i],nums[i]),t*nums[i]);

            finalMax = Math.max(max,finalMax);
        }

        return finalMax;
    }
}
