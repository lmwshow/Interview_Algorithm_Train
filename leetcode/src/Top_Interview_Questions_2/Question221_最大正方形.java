package Top_Interview_Questions_2;

public class Question221_最大正方形 {

    //动态规划：dp[i][j] 代表在以i-1, j-1这一格为右下角的正方形边长。
    //如果这一格的值也是1，那这个正方形的边长就是他的上面，左手边，和斜上的值的最小边长 +1。因为如果有一边短了缺了，都构成不了正方形。
    //dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int dp[][] = new int[matrix.length + 1][matrix[0].length + 1];

        int ans = 0;

        for (int i = 1; i <= matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }


        return ans * ans;

    }
}
