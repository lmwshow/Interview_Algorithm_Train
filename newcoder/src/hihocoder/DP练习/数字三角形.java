package hihocoder.DP练习;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/29 19:55
 * @Description: http://hihocoder.com/problemset/problem/1037
 */
public class 数字三角形 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int ans = 0;
        int n = in.nextInt();
        if (n > 0)
        {
            int[][] map = new int[n+1][n+1];

            for (int i = 1 ; i <= n ; i++)
                for (int j = 1; j <=i ; j++)
                    map[i][j] = in.nextInt();

            int[][] dp = new int[n+1][n+1];
            dp[1][1] = map[1][1];

            for (int i = 2 ; i <= n ; i++)
                for (int j = 1; j <= i; j++)
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+map[i][j];


            for (int i = 1 ; i <= n ; i++)
                ans = Math.max(ans,dp[n][i]);
        }

        System.out.println(ans);



    }

}
