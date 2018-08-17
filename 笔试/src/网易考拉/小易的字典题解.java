package 网易考拉;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @Auther: minGW
 * @Date: 2018/8/14 17:20
 * @Description:
 */
public class 小易的字典题解 {

    /*
    题意：给你n个a,m个z组成所有可能的字符串，并将字符串按字典序从小到大排列，输出第k个字符串。
         若不存在，输出-1。

         如果使用非递归全排列，输出第k个排列的话，会超时，只能50%

         针对这道题，首先要注意到字符串只有a,z两种。
         这里可以使用动态规划，实质上是一个找第k小的字符串，可以通过二分加快查找速度。

         dp[i][j] 表示i个a,j个z 组成的全排列的个数
         那么假设第一位只有2中情况，要么是a，要么是z。

         则状态转移方程为 dp[i][j] = dp[i-1][j] + dp[i][j-1];
         当然dp[i-1][j]中的所有排列 都比 dp[i][j-1] 要小。

         若最高位是a，则dp[i-1][j]个数是全排列中最小的dp[i-1][j]个数，此时如果 k <= dp[i-1][j],则最高位输出a
         否则说明，第k小的数在 dp[i][j-1]中，此时需要输出z，但是需要动态维护k ， k -= dp[i-1][j]

         重复这个过程直到i或j为0

         这里如果不使用大数类，dp[i][j]会溢出
         流氓的Java 使用BigInteger

    */

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        String[] parts = in.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        long k = Long.parseLong(parts[2]);


        BigInteger[][] dp = new BigInteger[n+1][m+1];

        //初始化dp
        for (int i = 1; i <= n; i++)
            dp[i][0] = BigInteger.valueOf(1);
        for (int i = 1; i <= m; i++)
            dp[0][i] = BigInteger.valueOf(1);

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                dp[i][j] = dp[i - 1][j].add(dp[i][j - 1]);


        StringBuilder ans = new StringBuilder();

        if (dp[n][m].compareTo(BigInteger.valueOf(k)) == -1)
            System.out.println(-1);
        else {
            int curx = n;
            int cury = m;

            while (curx != 0 && cury != 0) {
                //判断第k小的字符串，在哪一边，以最高位a,z两种情况划分
                if (dp[curx - 1][cury].compareTo(BigInteger.valueOf(k)) >= 0) {
                    ans.append('a');
                    curx--;
                } else {
                    ans.append('z');
                    k = BigInteger.valueOf(k).subtract(dp[curx - 1][cury]).intValue();
                    cury--;

                }
            }

            while (curx != 0) {
                ans.append('a');
                curx--;
            }

            while (cury != 0) {
                ans.append('z');
                cury--;
            }


            System.out.println(ans.toString());
        }
    }

}
