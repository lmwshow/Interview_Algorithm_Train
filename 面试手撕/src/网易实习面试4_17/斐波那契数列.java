package 网易实习面试4_17;

/**
 * 1 1 2 3 5 8 13 求第n个数
 * 很简单 我说这不是斐波那契数列吗  f[0] = 1,f[1] = 1 , f[n] = f[n-1] + f[n-2] 用递归.... （现在一想老哥 前面那个就是状态转移方程吧！ 真是SB）
 *
 * 问我用递归的复杂度是多少？   我迟疑了 ， 想了会竟然说O(n)... 被反问 递归能到O(n)  心里一阵凉... 不能 但还是没转过来说出复杂度
 * 然后赶紧说了dp的话就能O(n)了
 * 怪不得说了dp后 面试官就结束了。。。 前面就搞混了
 */
public class 斐波那契数列 {

    //递归是这样的！！！ 递归的复杂度是 O(2^n)
    //因为有重复计算， 每次计算都调用前面两次的计算，  是以2为指数增长的
    public static long fib(int n)
    {
        if (n == 1 || n == 0)
            return 1;
        
        return fib(n-1)+fib(n-2);
    }

    //动态规划
    public static long fib2(int n)
    {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n ;i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }
    
    
    public static void main(String[] args){
     
        System.out.println(fib2(11));
    }

}
