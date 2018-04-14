package leetgroup.DP;

/**
 * Created by Gracecoder on 2017/9/13.
 */
public class regular_expression_matching {

    public static boolean isMatch(String s, String p) {

        if (s == null || p == null)
            return false;

        int slen = s.length();
        int plen = p.length();

        boolean[][] dp = new boolean[plen+1][slen+1];

        dp[0][0] = true;
        for (int i = 1 ; i <= slen ; i++)
            dp[0][i] = false;

        for (int i = 1 ; i <= plen ; i++)
        {
            if (p.charAt(i-1)=='*'&&dp[i-2][0])
                dp[i][0] = true;
        }

        for (int i = 1 ; i <= plen ; i++)
            for (int j = 1 ; j <= slen ; j++)
            {
                if (p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1)=='.')
                    dp[i][j] = dp[i-1][j-1];

                if (p.charAt(i-1) == '*')
                    dp[i][j] = dp[i-2][j]||((p.charAt(i-2) == s.charAt(j-1) || p.charAt(i-2)=='.')&&(dp[i-1][j]||(dp[i][j-1])));
            }



        return dp[plen][slen];

    }


    public static void main(String[] args){

        boolean res = isMatch("aab","b.*");
        System.out.println(res);

    }
}
