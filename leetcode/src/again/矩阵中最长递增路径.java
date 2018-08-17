package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/14 09:48
 * @Description:
 */
public class 矩阵中最长递增路径 {


    //动态规划+记忆化搜索，记忆化搜索实现动态规划，记忆化搜索是搜索和动态规划的结合，在搜索过程中记录已经求解完毕的状态，使得每个状态只需进行一次搜索。
    //dp[i][j]表示在matrix[i][j]位置可以得到的最长路径
    //dp[i][j]是通过搜索相邻四个位置的dp值决定的，所以如果dp[i][j]已经访问过，那么dp[i][j]就是当前位置能够获得的最长路径值

    static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        int ans = 0;
        for (int i = 0 ; i < n ; i++)
            for (int j = 0 ; j < m ; j++)
                ans = Math.max(ans,find(matrix,i,j,visit,dp));

        return ans;

    }

    //查询dp[x][y]
    private int find(int[][] matrix, int x, int y, boolean[][] visit, int[][] dp) {

        if (visit[x][y])
            return dp[x][y];

        dp[x][y] = 1;

        for (int i = 0 ; i < 4 ; i++)
        {
            int curx = x + dir[i][0];
            int cury = y + dir[i][1];

            if (curx >= 0 && curx < matrix.length && cury >= 0 && cury < matrix[0].length && matrix[curx][cury] < matrix[x][y])
            {
                //当前值小于上一个值，当前位置的递增序列才能加上上面的
                dp[x][y] = Math.max(dp[x][y],find(matrix,curx,cury,visit,dp) + 1);
            }
        }

        visit[x][y] = true;
        return dp[x][y];

    }

}
