package Top_Interview_Questions_2.again;

public class Question72_编辑距离 {

    //有三种操作：插入，替换，删除， 要让word1变成word2
    //将其化为子问题  s[0..i] 变为 p[0..j] 最少需要几步，对于每对不同的字符，可以有3种操作，需要对比记录其中最少的步骤
    //动态规划，定义: dp[i][j] 表示从s[0..i-1]变成j[0..j-1]的最少步骤
    //  状态转移方程: dp[i][j] = s[i-1] == p[j-1]? dp[i-1][j-1]:(min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1)

    public int minDistance(String word1, String word2) {

        if (word1.length() == 0 || word2.length() == 0)
            return word1.length() == 0? word2.length():word1.length();

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0 ; i <= m ;i++)
            dp[i][0] = i;
        for (int i = 0 ; i <= n ;i++)
            dp[0][i] = i;

        for (int i = 1 ; i <= m ; i++)
            for (int j = 1 ; j <= n ;j++)
                dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1)? dp[i-1][j-1]:(Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1);


        return dp[m][n];




    }
}