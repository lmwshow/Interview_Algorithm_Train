package hihocoder.编程练习赛49;

import java.util.Arrays;
import java.util.Scanner;

public class 挑选子集 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[] nums = new int[n+1];
        for (int i = 1 ;  i < nums.length ; i++)
            nums[i] = in.nextInt();

        Arrays.sort(nums);

        int[][] dp = new int[m+1][n+1];

        for (int i = 1 ; i <= n ; i++)
            dp[1][i] = 1;

        for (int i = 2 ; i <= m ; i ++)
        {
            for (int j = i ; j <= n ; j ++)
            {
                for (int x = 1 ; x < j; x++)
                {
                    if ((nums[j] - nums[x])%k == 0)
                        dp[i][j] = (dp[i][j] + dp[i-1][x]) % 1000000009;
                }
            }

        }

        int res = 0;
        for (int i = m ; i <= n ; i++)
            res= (res + dp[m][i])%1000000009;       //先相加 再取模

        System.out.println(res);


    }
}
