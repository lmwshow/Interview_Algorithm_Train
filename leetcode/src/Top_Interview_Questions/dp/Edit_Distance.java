package Top_Interview_Questions.dp;

/**
 * Created by Gracecoder on 2017/10/9.
 *
 * 动态规划:
 * dp[i][j]：表示s1(0,1...i-1)转化为 s1(0,1....j-1) 的最短步数
 *
 * 因为存在3种操作：删除，插入，和修改
 *
 * 状态转移方程:
 * 1. s1(i-1) == s2(j-1)
 *    dp[i][j] = dp[i-1][j-1]
 * 2. s1(i-1) != s2(j-1)
 *    dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1   分别对应修改，插入到当前位置，修改
 *
 * 时间复杂度O(mn)
 */
public class Edit_Distance {

    public static int minDistance(String word1, String word2) {

        if (word1.length() == 0 || word2.length() == 0)
            return word1.length() == 0? word2.length():word1.length();

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0 ; i <= n ; i++)
            dp[0][i] = i;

        for (int i = 0 ; i <= m ; i++)
            dp[i][0] = i;

        for (int i = 1 ; i <= m ; i ++)
            for (int j = 1 ; j <= n ; j++)
            {
                if (word1.charAt(i -1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Integer.min(Integer.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]) +1 ;
            }

        return dp[m][n];
    }


    public static void main(String[] args){

            minDistance("worwd","wrwd");
    }
}
