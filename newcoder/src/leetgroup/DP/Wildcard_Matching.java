package leetgroup.DP;

/**
 * Created by Gracecoder on 2017/9/8.
 *
 * 通配符匹配：？代表任意一个，*表示任意字符串可以为空
 *
 * 解决方案1：DP
 * 状态转移方程 dp[i][j] 表示 字符串p从0到i的的子字符串能否匹配s从0到j的子字符串
 *
 * dp[i][j] = dp[i-1][j-1]     如果p的第i个字符等于s的第j个字符 或者 p的第i个字符== '?'
 * dp[i][j] = dp[i-1][j]||dp[i-1][j-1]||dp[i-1][j-2]...||dp[i-1][0]         when p的第i个字符 == '*'
 *
 * 由于当p的第i个字符为*时, dp[i][j-1] = dp[i-1][j-1]||dp[i-1][j-2]||...||dp[i-1][0]
 * 推出 dp[i][j] =dp[i-1][j]||dp[i][j-1]
 *
 *
 */
public class Wildcard_Matching {

    public boolean isMatch(String s, String p) {

        if (s==null || p==null)
            return false;

        int m = p.length();
        int n = s.length();

        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] =true;

        for (int i = 1 ; i <= m ; i++)
            dp[i][0] = dp[i-1][0]&&p.charAt(i-1)=='*';


        for (int i = 1 ; i <= m; i++)
            for (int j = 1 ; j <= n; j++)
            {
                if (p.charAt(i-1)=='?' || p.charAt(i-1) == s.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                if (p.charAt(i-1)=='*')
                    dp[i][j] = dp[i-1][j]||dp[i][j-1];

            }

        return dp[m][n];


    }


    public boolean isMatch2(String s,String p)
    {
        if (s==null || p==null)
            return false;

        int sIndex = 0,pIndex = 0,match = 0,starIdx = -1;

        while (sIndex < s.length())
        {
            if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex)=='?'))
            {
                sIndex++;
                pIndex++;
            }else if (pIndex < p.length() && p.charAt(pIndex) == '*')
            {
                starIdx = pIndex;
                match = sIndex;
                pIndex++;
            }else if (starIdx != -1)
            {
                pIndex = starIdx + 1;
                match ++ ;
                sIndex = match;
            }
            else
                return false;
        }

        while (pIndex < p.length() && p.charAt(pIndex)=='*')
            pIndex++;

        return pIndex == p.length();

    }
}
