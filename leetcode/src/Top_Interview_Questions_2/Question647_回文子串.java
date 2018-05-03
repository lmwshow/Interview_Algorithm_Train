package Top_Interview_Questions_2;

/**
 * @Auther: minGW
 * @Date: 2018/5/3 09:49
 * @Description: https://leetcode-cn.com/problems/palindromic-substrings/description/
 *
 * 动态规划判断回文子串时，当i < j 时令dp[i][j]=true,即空串是回文串
 */
public class Question647_回文子串 {

    public int countSubstrings(String s) {

        int ans = 0;
        if (s == null || s.length() == 0)
            return ans;

        boolean[][] dp = new boolean[s.length()][s.length()];


        //动态规划判断回文子串时，当i < j 时令dp[i][j]=true,即空串是回文串
        for (int i = 0 ; i < s.length() ; i++)
            for (int j = 0 ; j <=i ;j++)
                dp[i][j] = true;

        ans = s.length();

        for (int i = s.length() - 2; i >=0; i--)
        {
            for (int j = 1; j < s.length() ; j++)
            {
                if (j <= i)
                    continue;
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                if (dp[i][j])
                    ans ++;
            }
        }

        return ans;

    }
}
