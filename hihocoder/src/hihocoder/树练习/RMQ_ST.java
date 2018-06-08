package hihocoder.树练习;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/6/7 19:52
 * @Description: http://hihocoder.com/problemset/problem/1068?sid=1325085
 *
 * RMQ  ST 算法
 *
 * 先预先计算一些区间的最小值，然后把每个询问都拆成若干个计算了最小值的区间，并且统计这些区间的最小值的最小值，从而得出答案的。
 * 那么其实我可以将统计的区间这样规定——统计所有长度为2的非负整数次幂的区间。
 *
 * ST 是一个动态规划，注意循环时，外层循环是每次的区间大小
 *
   令F[i,j]为从下标i开始，长度为2^j的元素的最小值。那么状态转移方程就是F[i,j]=min(F[i,j-1],F[i+2^(j-1),j-1])。这个式子在这里有详细解释哦！
   查询
   假如要查询[m,n]的最小值，那么先求出一个最大的k。使k满足2^k<=(n-m+1)。于是我们可以将[m,n]分成两个（部分重叠的）长度为2^k的区间:[m,m+2^k-1],[n-2^k+1,n];
   F[m,k]为F[m,m+2^k-1]的最小值，F[n-2^k+1,k]是[n-2^k+1,n]的最小值。状态转移方程：RMQ(i,j)=min(F[m,k],F[n-2^k+1,k]);
 */
public class RMQ_ST {

    static int MAX = 1000005;
    static int[][] dp = new int[MAX][20];

    public static void main(String[] args) throws IOException {

        // MD用Scanner 超时， 以后还是就用Buffer吧 ， 计算读取的只是个整数
//        Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[] nums = new int[N+1];

        for (int i = 1 ; i <= N ; i++)
            nums[i] = Integer.parseInt(in.readLine());

        for (int i = 1 ; i <= N; i++)
            dp[i][0] = nums[i];

        //ST
        for (int j = 1 ; (1 << j) <= N ; j++)
        {
            for (int i = 1 ; i + (1 << j) - 1 <= N ; i++)
            {
                //取前后两端的较小值
                dp[i][j] = Math.min(dp[i][j-1],dp[i+(1<<(j-1))][j-1]);
            }

        }


        int Q = Integer.parseInt(in.readLine());
        for (int i = 0 ; i < Q ; i++)
        {
            String[] parts = in.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            if (a > b)
            {
                int tmp = a;
                a = b;
                b = a;
            }

            int len = b - a +1;
            int k = (int) ((Math.log(len)/Math.log(2)));

            //先求出一个最大的k，使k满足2^k<=(n-m+1)。
            // 于是我们可以将[m,n]分成两个（部分重叠的）长度为2^k的区间:[m,m+2^k-1],[n-2^k+1,n]
            int ans = Math.min(dp[a][k],dp[b - (1 << k) + 1][k]);
            System.out.println(ans);
        }
    }
}
