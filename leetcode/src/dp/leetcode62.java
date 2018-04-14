package dp;

/**
 * Created by Gracecoder on 2017/2/28.
 */
public class leetcode62 {

    //dp[i][j] 表示在到达map[i][j]这个位置时，当前的总路径数
    //状态转移方程: dp[i][j] = dp[i-1][j] + dp[i][j-1]        (因为只能右下移动，所以当前位置的路径数等于 上左两个点的和)
    //初始化 第一行和第一列的 路径数为1

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0 ; i < n ; i ++)
            dp[0][i] = 1;
        for (int i = 1 ; i < m ; i ++)              //dp[0][0]已经初始化过
            dp[i][0] = 1;

        for (int i = 1 ; i < m ; i ++)
            for (int j = 1 ; j < n ; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];

        return dp[m-1][n-1];
    }
}
