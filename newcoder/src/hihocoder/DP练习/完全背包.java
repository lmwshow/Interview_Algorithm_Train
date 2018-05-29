package hihocoder.DP练习;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/29 20:48
 * @Description: http://hihocoder.com/problemset/problem/1043
 *
 * 每种物品都有无限件可用
 * 最简单的思路是，按照01背包，但是此时的策略不再是0,1即放与不放了，而是放多少个的问题了
 * f[i][v]=max{f[i-1][v-k*c[i]]+k*w[i]|0<=k*c[i]<= v}
 *
 * 如果用单维数组 dp[j] = Math.max(dp[j],dp[j-need[i]]+value[i]) 来求解的话
 * 01背包是逆序的，而完全背包是顺序的！！！！ 其他都一样
 *
 *
 * 优化：把第i种物品拆成费用为c[i]*2^k、价值为w[i]*2^k的若干件物品，其中k满足c[i]*2^k<V。
 * 这是二进制的思想，因为不管最优策略选几件第i种物品，总可以表示成若干个2^k件物品的和。
 *
 */
public class 完全背包 {

    public static void main(String[] args) {

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


        /*
        for (int i = 1 ; i <= n; i++)
            for (int j = m ; j >= need[i] ; j--)
                for (int k = 1; k*need[i] <= j ; k++)
                    dp[j] = Math.max(dp[j],dp[j-k*need[i]]+k*value[i]);
        */

        //顺序即可，因为每种背包都是无限的。当我们把i从1到N循环时，f[v]表示容量为v在前i种背包时所得的价值，这里我们要添加的不是前一个背包，而是当前背包，所以考虑当前状态
        for (int i = 1 ; i <= n; i++)
            for (int j = need[i] ; j <=m ; j++)
                dp[j] = Math.max(dp[j],dp[j-need[i]]+value[i]);

        System.out.println(dp[m]);
    }
}
