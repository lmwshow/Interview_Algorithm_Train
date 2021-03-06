package again;

/**
 * @Auther: minGW
 * @Date: 2018/8/9 10:25
 * @Description:
 *
 * 给定两个字符串word1, word2。求出从word1到word2步骤最少的修改方式，修改方式包括替换(replace)，插入(insert)，删除(delete)。
 *
 * 可以借鉴正则表达式匹配的思想，使用动态规划求解。
 * dp[i][j]: 表示s[0...i-1] -> p[0...j-1] 最少转换步数
 *
 * 对于每一个字符串，可以有3个操作，替换，插入，删除
 * 对于每一种操作的状态转移方程：
 * 1. replace:   dp[i][j] = dp[i-1][j-1] + 1 //保留s[0...i-2] -> p[0...j-2]的转换步数 + 1
 * 2. insert:    dp[i][j] = dp[i][j-1] + 1   //保留s[0...i-1] -> p[0...j-2]的转移步数 + 1
 * 3. delete:    dp[i][j] = dp[i-1][j] + 1  //保留s[0...i-2] -> p[0...j-1]的转移步数 + 1
 *
 * 最后选择最小值
 */
public class 字符串转换最短编辑距离 {

    public int minDistance(String word1, String word2) {

        if (word1.length() == 0 || word2.length() == 0)
            return word1.length() == 0? word2.length():word1.length();

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0 ; i <= m ; i++)
            dp[i][0] = i;
        for (int i = 0 ; i <= n ;i++)
            dp[0][i] = i;

        for (int i = 1 ; i <= m ; i++)
            for (int j = 1 ; j <= n ; j++)
                dp[i][j] = word1.charAt(i-1) == word2.charAt(j-1)?dp[i-1][j-1]:(Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1);


        return dp[m][n];
    }
}
