package Top_Interview_Questions_2.dp;

public class Question279_完美平方数 {


    //动态规划  dp[n]表示target为n的最少平方个数
    //         dp[n+1] = Math.min(dp[1]+dp[n],....,dp[n]+dp[1]);
    public static int numSquares(int n) {

        int[] dp = new int[n+1];
        int index = (int) Math.sqrt(n);

        for (int i = 1; i <=n ;i++)
            dp[i] = Integer.MAX_VALUE;

        for (int i = 1;i <=index ; i++)
            dp[i*i] = 1;


        for (int i = 1; i <=n ; i++)
        {
            if (dp[i]==1)
                continue;

            else
            {
                for (int j = 1; j <= (i/2);j++)
                    dp[i] = Math.min(dp[j]+dp[i-j],dp[i]);
            }
        }


        return dp[n];

    }


    //更好的DP
    public int BetterDPnumSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0 ; i <= n ; i++)
            dp[i] = Integer.MAX_VALUE;

        dp[0] = 0;
        //遍历i时 直接计算需要dp[i]的其他完美平方数的最优解
        for (int i = 0 ; i <= n ; i++)
            for (int j = 1; i + j*j <= n ;j++)
                dp[i+j*j] = Math.min(dp[i+j*j],dp[i]+1);

        return dp[n];
    }

    public static void main(String[] args){


        System.out.println(numSquares(13));


    }
}
