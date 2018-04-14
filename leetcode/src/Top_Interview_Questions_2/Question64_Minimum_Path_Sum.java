package Top_Interview_Questions_2;

public class Question64_Minimum_Path_Sum {

    //求左上到右下的最小路径
    //动态规划  dp[i][j] 表示 到达(i,j)时的最小路径
    public static int minPathSum(int[][] grid) {

        int ans = 0 ;
        if (grid == null || grid.length == 0)
            return ans;

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1 ; i < grid.length ; i++)
            dp[i][0] = grid[i][0] + dp[i-1][0];

        for (int i = 1; i < grid[0].length ; i++)
            dp[0][i] = grid[0][i] + dp[0][i-1];

        for (int i = 1 ; i < grid.length ; i++)
            for (int j = 1 ; j < grid[0].length ; j++)
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];


        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args){



    }
}
