package hihocoder.DP练习;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/29 20:20
 * @Description:
 */
public class 经典01背包 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] need = new int[n+1];
        int[] value = new int[n+1];

        for (int i = 1 ; i <= n ; i++)
        {
            need[i] = in.nextInt();
            value[i] = in.nextInt();
        }

        int[] dp = new int[m+1];

        for (int i = 1 ; i <= n; i++)
            for (int j = m ; j >= need[i] ; j--)
                dp[j] = Math.max(dp[j],dp[j-need[i]]+value[i]);

        System.out.println(dp[m]);
    }
}
