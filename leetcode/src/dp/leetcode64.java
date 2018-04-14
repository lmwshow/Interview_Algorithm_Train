package dp;

/**
 * Created by Gracecoder on 2017/2/28.
 */
public class leetcode64 {


    public int minPathSum(int[][] grid) {

        //dp[i][j] 表示走到grid[i][j]时的 最小代价
        //状态转移方程： dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]           等于左上中较小的一个 + (i,j)点的代价 即为 当前最低代价
        //dp[m-1][n-1]

        int m = grid.length;    //行数
        int n = grid[0].length; //列数
        int dp[][] = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1 ; i < n ; i ++)
            dp[0][i] = dp[0][i-1] + grid[0][i];

        for (int i = 1 ; i < m ; i ++)
            dp[i][0] = dp[i-1][0] + grid[i][0];

        for (int i = 1 ; i < m ; i ++)
            for (int j = 1 ; j < n ; j++)
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];

        return dp[m-1][n-1];
    }
}
