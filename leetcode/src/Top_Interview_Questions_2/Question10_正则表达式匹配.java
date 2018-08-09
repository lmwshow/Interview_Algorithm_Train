package Top_Interview_Questions_2;

public class Question10_正则表达式匹配 {

    public static boolean isMatch(String s, String p) {

        if (s == null || p == null)
            return false;
        //状态转移方程 dp[i][j] 表示 s[0...i-1] 是否可以匹配 p[0...j-1]
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        //初始化
        dp[0][0] = true;
        for (int i = 1 ; i <= p.length() ; i++)
        {
            if (p.charAt(i-1)=='*' && dp[i-2][0])
                dp[0][i] = true;
        }

        //重点是p.charAt(j - 1) == '*'时 的三种情况，分别匹配0个，1个，多个
        for (int i = 1 ; i <= s.length() ; i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];

                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || ((s.charAt(i - 1) == p.charAt(j - 2)|| p.charAt(j-2) == '.') && dp[i - 1][j]);
                else
                    dp[i][j] = false;
            }
        }

        return dp[s.length()][p.length()];


    }
    public static void main(String[] args){


        System.out.println(isMatch("abbcd","ac*b*cd"));

    }
}
