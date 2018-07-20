package again;

/**
 * @Auther: minGW
 * @Date: 2018/7/18 11:16
 * @Description: 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class 正则表达式匹配 {

    //动态规划,dp[i][j]表示模式串(0,i-1) 能否匹配 原串(0,j-1)
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;

        boolean[][] dp = new boolean[pattern.length + 1][str.length + 1];

        dp[0][0] = true;
        for (int i = 1; i <= pattern.length; i++) {
            if (i == 1)
                dp[i][0] = false;
            else
                dp[i][0] = pattern[i - 1] == '*' && dp[i - 2][0];
        }


        for (int i = 1; i <= pattern.length; i++)
            for (int j = 1; j <= str.length; j++) {
                if (pattern[i - 1] == str[j - 1] || pattern[i - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[i - 1] == '*')
                    dp[i][j] = dp[i - 2][j] || dp[i - 1][j] || (dp[i][j - 1] && (pattern[i - 2] == str[j - 1] || pattern[i - 2] == '.'));

            }

        return dp[pattern.length][str.length];

    }
}
