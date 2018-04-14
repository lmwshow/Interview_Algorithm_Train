package offer;

/**
 * Created by Gracecoder on 2017/12/18.
 *
 * 动态规划，笔记里有字符串
 */
public class 题19_正则表达式匹配 {

    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null)
            return false;

        int slen = str.length;
        int plen = pattern.length;

        boolean[][] dp = new boolean[plen+1][slen+1];
        dp[0][0] = true;

        for (int i = 1 ; i <= slen ; i++)
            dp[0][i] = false;

        //初始化，当p[i-1] == '*'时，看dp[i-2][0]的状态
        for (int i = 1 ; i <= plen ; i++)
            if (pattern[i-1] == '*'&&dp[i-2][0])
                dp[i][0] = true;

        for (int i = 1 ; i <= plen ; i++)
            for (int j = 1 ; j <= slen ; j++)
            {
                if (pattern[i-1]==str[j-1]||pattern[i-1]=='.')
                    dp[i][j] = dp[i-1][j-1];

                if (pattern[i-1] == '*')
                {
                    if (pattern[i-2] == str[j-1] || pattern[i-2]=='.')
                        dp[i][j] = dp[i-2][j]||dp[i-1][j]||dp[i][j-1];
                    else
                        dp[i][j] = dp[i-2][j];

                }
            }


        return dp[plen][slen];
    }
}
