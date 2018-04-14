package Top_Interview_Questions.dp.again;

/**
 * Created by Gracecoder on 2017/11/30.
 *
 * 题解：
 * http://bookshadow.com/weblog/2015/11/30/leetcode-burst-balloons/
 * http://blog.csdn.net/swartz2015/article/details/50561199
 *
 * 如果我们采用回溯法，第一次有n个选择踩掉，第二次n-1个选择，总的时间复杂度为n!,显然无法接受
 *
 * 这里采用动态规划：以最后被爆破的气球m为界限，把数组分为左右两个子区域
 *
 * 因为只有定义m为最后被爆破的气球，左右两个子区域才会是相对独立的区域！！！
 *
 * dp[l][r]表示扎破(l, r)范围内所有气球获得的最大硬币数，不含边界；
 *      dp[l][r] = Math.max(dp[l][r],new_nums[l]*new_nums[m]*new_nums[r]+dp[l][m] + dp[m][r]);
 */
public class Burst_Balloons {

    public int maxCoins(int[] nums) {

        int[] new_nums = new int[nums.length +2];
        int n = 1;
        for (int x : nums) if (x > 0) new_nums[n++] = x;
        new_nums[0] = new_nums[n++] = 1;
        int[][] dp = new int[n][n];

        for (int k = 2 ; k < n; k ++)               //k表示区间段距离，相当于先算所以距离为2的value，然后算3的时候上一次循环的结果来计算，有点像最短路径
            for (int l = 0; l < n - k ; l++)
            {
                int r = l + k;
                for (int m = l +1 ; m < r ; m++)
                {

                    //new_nums[l]*new_nums[m]*new_nums[r]  因为m点为最后戳破的点，所以value = nums[l]*nums[m]*nums[r] 即乘以边界值
                    dp[l][r] = Math.max(dp[l][r],new_nums[l]*new_nums[m]*new_nums[r]+dp[l][m] + dp[m][r]);
                }
            }


        return dp[0][n-1];


    }
}
