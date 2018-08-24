package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/23 14:17
 * @Description:
 */

/**
 * Created by Gracecoder on 2017/11/30.
 * <p>
 * 题目链接：https://leetcode-cn.com/problems/burst-balloons/description/
 * <p>
 * 题解：
 * http://bookshadow.com/weblog/2015/11/30/leetcode-burst-balloons/
 * http://blog.csdn.net/swartz2015/article/details/50561199
 * <p>
 * 如果我们采用回溯法，第一次有n个选择踩掉，第二次n-1个选择，总的时间复杂度为n!,显然无法接受
 * <p>
 * 这里采用动态规划：以最后被爆破的气球m为界限，把数组分为左右两个子区域
 * <p>
 * 因为只有定义m为最后被爆破的气球，左右两个子区域才会是相对独立的区域！！！
 * 关键点：m为区间内最后爆破的气球
 * dp[l][r]表示扎破(l, r)范围内所有气球获得的最大硬币数，不含边界；
 * dp[l][r] = Math.max(dp[l][r],new_nums[l]*new_nums[m]*new_nums[r]+dp[l][m] + dp[m][r]);
 */

public class 戳气球 {

    public int maxCoins(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int[] array = new int[nums.length + 2];
        int n = 1;
        for (int x : nums)
            array[n++] = x;

        array[0] = 1;
        array[n++] = 1;

        int[][] dp = new int[n][n];

        for (int step = 2; step < n; step++)        //step表示步长，相当于先算所有距离为2的value，然后算3的时候利用上一次循环的结果来计算，有点区间最低代价问题
            for (int l = 0; l < n - step; l++) {
                int r = l + step;
                for (int m = l + 1; m < r; m++)
                    dp[l][r] = Math.max(dp[l][r], array[l] * array[m] * array[r] + dp[l][m] + dp[m][r]);
            }

        return dp[0][n - 1];

    }
}
