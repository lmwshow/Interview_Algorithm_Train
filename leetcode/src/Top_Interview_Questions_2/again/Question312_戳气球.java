package Top_Interview_Questions_2.again;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gracecoder on 2017/11/30.
 *
 * 题目链接：https://leetcode-cn.com/problems/burst-balloons/description/
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
 * 关键点：m为区间内最后爆破的气球
 * dp[l][r]表示扎破(l, r)范围内所有气球获得的最大硬币数，不含边界；
 * dp[l][r] = Math.max(dp[l][r],new_nums[l]*new_nums[m]*new_nums[r]+dp[l][m] + dp[m][r]);
 */


public class Question312_戳气球 {


    public static int maxCoins(int[] nums) {

        int[] new_nums = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) new_nums[n++] = x;
        new_nums[0] = new_nums[n++] = 1;
        int[][] dp = new int[n][n];

        for (int step = 2; step < n; step++)      //step表示步长，相当于先算所有距离为2的value，然后算3的时候利用上一次循环的结果来计算，有点区间最低代价问题
            for (int l = 0; l < n - step; l++) {
                int r = l + step;

                //new_nums[l]*new_nums[m]*new_nums[r]  因为m点为最后戳破的点，所以value = nums[l]*nums[m]*nums[r] 即乘以边界值
                for (int m = l + 1; m < r; m++)
                    dp[l][r] = Math.max(dp[l][r], new_nums[l] * new_nums[m] * new_nums[r] + dp[l][m] + dp[m][r]);
            }


        return dp[0][n-1];

    }


    static int max;
    static int cur;

    //暴力回溯,超时
    public static int BaolimaxCoins(int[] nums) {

        max = Integer.MIN_VALUE;
        cur = 0;
        if (nums == null || nums.length == 0)
            return 0;
        List<Integer> list = new ArrayList<>();
        for (int x : nums)
            list.add(x);
        solver(nums, list);

        return max;

    }

    private static void solver(int[] nums, List<Integer> list) {

        if (list.size() == 0) {
            max = Math.max(max, cur);
            return;
        }

        int left = 0, right = 0, tmp = 0;
        for (int i = 0; i < list.size(); i++) {
            tmp = list.get(i);
            left = (i == 0) ? 1 : list.get(i - 1);
            right = (i == list.size() - 1) ? 1 : list.get(i + 1);
            cur += tmp * left * right;
            list.remove(i);
            solver(nums, list);
            list.add(i, tmp);
            cur -= tmp * left * right;
        }

    }


    public static void main(String[] args) {

        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }
}
