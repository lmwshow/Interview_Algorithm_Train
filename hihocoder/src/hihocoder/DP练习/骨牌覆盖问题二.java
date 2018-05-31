package hihocoder.DP练习;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/5/31 09:46
 * @Description: http://hihocoder.com/problemset/problem/1151
 *
 * 3*N骨牌问题，感觉和状态压缩2差不多,但是这里1≤N≤100,000,000 ,按照那样会内存溢出
 *
 * 两种解法：1.找规律 2.矩阵快速幂
 *
 *
 * 1.递归找规律
 * 思路：
        当N为基数的时候，肯定覆盖不了。

        当N为偶数的时候，对N做除2操作，找出递推公式。

        a[0] = 1;
        a[1] = 3;
        a[2] = 11;

        递推公式为：

        f(n)=3(f(n-1)+f(n-2))-f(n-3);

 * 2.矩阵快速幂 http://www.cnblogs.com/xcw0754/p/4780431.html
 *   矩阵的状态转移，关键理解点是，当前放置第i+1行，使得第i行填满的方案有几种
 *
 *
 */
public class 骨牌覆盖问题二 {


    static int MOD = 12357;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long[][] transferMatrix = { { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 0, 1, 0, 0, 1, 0 }, };
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        if (val % 2 == 1) {
            System.out.println(0);
        } else {
            long[][] pw = power(transferMatrix, val);
//			MatrixUtils.printMatrix(pw);
            System.out.println(pw[pw.length-1][pw[0].length-1]);
        }
        scanner.close();
    }

    public static long[][] multiply(long[][] m1, long[][] m2) {
        long[][] multi = new long[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                long val = 0;
                for (int k = 0; k < m1[0].length; k++) {
                    val += (m1[i][k] * m2[k][j]) ;
                    val %= 12357;
                }
                multi[i][j] = val;
            }
        }
        return multi;
    }

    public static long[][] power(long[][] matrix, int n) {
        if (n <= 1) {
            return matrix;
        }
        long[][] pm = power(matrix, n / 2);
        long[][] retMatrix = new long[pm.length][pm[0].length];
        for (int i = 0; i < retMatrix.length; i++) {
            for (int j = 0; j < retMatrix[0].length; j++) {
                long val = 0;
                for (int k = 0; k < retMatrix[0].length; k++) {
                    val += pm[i][k] * pm[k][j];
                    val %= 12357;
                }
                retMatrix[i][j] = val;
            }
        }
        if (n % 2 == 1) {
            retMatrix = multiply(retMatrix, matrix);
        }
        return retMatrix;
    }

    public static void mw_main(String[] args) {

        Scanner in = new Scanner(System.in);
        long N = in.nextLong();

        if ((N & 1) == 1)
            System.out.println(0);
        else
            System.out.println(solve1(N));
    }

    private static int solve1(long n) {

        n = n / 2;
        int[] a = new int[3];

        a[0] = 1;
        a[1] = 3;
        a[2] = 11;
        int tmp = 0;

        if (n < 3)
            return a[(int) n];

        for (int i = 3; i <= n; i++) {
            tmp = (3 * a[2] + 3 * a[1] - a[0] + MOD) % MOD;
            a[0] = a[1];
            a[1] = a[2];
            a[2] = tmp;
        }
        return tmp;
    }


}

