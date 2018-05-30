package hihocoder.DP练习;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/30 08:49
 * @Description: http://hihocoder.com/problemset/problem/1044
 * <p>
 * 有点难度,要求连续M个位置中如果超过Q个位置被打扫就'报警'
 * <p>
 * 因为我不知道之前具体的选取方案，我是没有办法判断当前这个位置能否进行选取的，这便是违反了动态规划状态定义的无后效性！
 * 那么我需要做的事情无非就是在状态中记录之前的选取方法，并且这些记录需要能够让我推算出当前这个位置的垃圾是否能被清扫而不引起口角！
 * <p>
 * 之所以称为状态压缩，是使用了二进制来表示每个位置的状态，010101,1表示清理过，0表示未清理
 * <p>
 * dp[i][j]表示清理范围为[0, i]时，位置[i - m + 1, i]这m个位置各位置是否被清理的压缩后状态（0未清理，1已清理，其中压缩状态j的高位为位置i的清理位）
 * <p>
 * 状态转移公式：关键点是要弄清晰，随着i的变化,j表示的范围会随着变化 位置区间[i - m + 1, i]
 * 对于清理范围为[0, i + 1]时，对于位置i + 1，
 * 当不清理位置i + 1时，dp[i][j] -> dp[i + 1][j >> 1]
 * 当清理位置i + 1时，要求满足状态j中各位和小于等于q，此时
 * dp[i][j] -> dp[i + 1][(1 << (m - 1)) | (j >> 1)]， 其中j的各位之和小于等于q。
 */
public class 状态压缩 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        boolean[] lte = init(m, q);
        int[] value = new int[n];
        for (int i = 0; i < n; i++)
            value[i] = in.nextInt();

        System.out.println(resolve(n, m, q, value, lte));

    }

    private static int resolve(int n, int m, int q, int[] value, boolean[] lte) {

        int[][] dp = new int[n + 1][1 << m];

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < (1 << m); j++) {
                //当前位置不清理的情况
                int s0 = j >> 1;
                //存在多次转移到dp[i][s0]，因此取max，下同
                dp[i][s0] = Math.max(dp[i][s0], dp[i - 1][j]);

                //清理的情况,当s1满足1不超过q时
                //dp[i][s1] 和dp[i-1][j] 无关联， 即使当前位置选择i清理，i-m位置也是清理，但是它们已经不是在连续m的范围了
                int s1 = (1 << (m - 1)) | (j >> 1);
                if (lte[s1])
                    dp[i][s1] = Math.max(dp[i][s1], dp[i - 1][j] + value[i - 1]);

            }

        int max = 0;
        for (int j = 0; j < (1 << m); j++) {
            max = Math.max(max, dp[n][j]);
        }
        return max;

    }

    // 初始化各状态值是否满足1的个数不超过q
    private static boolean[] init(int m, int q) {

        boolean[] lte = new boolean[1 << m];

        for (int i = 0; i < (1 << m); i++) {
            int cnt = 0;
            for (int j = i; j > 0; j >>= 1)
                cnt += j & 1;

            lte[i] = cnt <= q;
        }

        return lte;

    }
}
