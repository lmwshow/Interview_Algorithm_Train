package hihocoder.DP练习;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/31 09:36
 * @Description: http://hihocoder.com/problemset/problem/1143
 *
 * 简单DP： dp[n] = dp[n-1] + dp[n-2]
 */
public class 骨牌覆盖问题一 {

    static int MOD = 19999997;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        long N = in.nextLong();
        long a = 1;
        long b = 2;
        long ans = N < 3?N:0;



        for (int i = 3 ; i <= N ; i++)
        {
            ans = (a + b) % MOD;
            a = b ;
            b = ans;
        }


        System.out.println(ans);
    }
}
