package hihocoder.DP练习;

import java.util.Scanner;

/**
 * @Auther: minGW
 * @Date: 2018/6/1 08:03
 * @Description: http://hihocoder.com/problemset/problem/1162
 *
 *
 *
 *
 * 这是个状压加矩阵快速幂的好题。
 *
 * 这题和之前的一个 状态压缩二，是很类似的.
 * 但是覆盖二里面也说过,n比较大，开不下数组，无法使用之前的类似方法。
 * 但是由于k比较小，可以使用状态压缩。
 * 所以结合这道题目的前2个版本，考虑使用矩阵快速幂进行计算，关键是计算出状态转移的矩阵M，这里无法手动定了，我们使用dfs，跑出状态转移矩阵
 *
 * 用二进制表示状态,上一行的状态用y表示，当前行的状态用x表示
 * 枚举当前行的每一个空的位置，放置骨牌，有3种情况。由于我们只关系上一行和当前行，所以竖放也是指覆盖当前行和上一行，所以每行遍历过来，每个位置都是还未放置的。
 * 当前行放用1表示，不放用0表示
 * 每一种放置方法解释如下，假设当第i行的状态为x，第i-1行的状态为y：

    第i行不放置，则前一行必须有放置的骨牌。x对应二进制位为0，y对应二进制位为1。
    第i行竖放骨牌，则前一行必须为空。x对应二进制位为1，y对应二进制位为0。
    第i行横向骨牌，则前一行必须两个位置均有骨牌，否则会产生空位。x对应二进制位为1，y对应二进制位为1


    关键点：：能这样直接左移是因为我们是从最低位开始的，当前最低位是指上一个已经遍历的位置，左移后出来的最低位才是我们当前要放置的位置
    第i行不放置：new_x = x << 1, new_y = (y << 1) + 1; 列数+1
    第i行竖放骨牌：new_x = (x << 1) + 1, new_y = y << 1; 列数+1
    第i行横向骨牌：new x = (x << 2) + 3, new_y = (y << 2) + 3; 列数+2
 */
public class 骨牌覆盖问题三 {


    static final int MOD = 12357;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();

        int col = 1 << k;
        //DFS构建状态转移方程 transferMatrix
        long[][] transferMatrix = new long[col][col];

        dfsBuildMatrix(transferMatrix,0,0,0,k);

        if ((n*k)%2 == 1)
        {
            System.out.println(0);
        }else {

            long[][] pw = power(transferMatrix,n);
            System.out.println(pw[pw.length - 1][pw[0].length - 1]);

        }

    }

    private static long[][] power(long[][] matrix, int n) {
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

                }
                val %= 12357;
                retMatrix[i][j] = val;
            }
        }
        if (n % 2 == 1) {
            retMatrix = multiply(retMatrix, matrix);
        }
        return retMatrix;
    }

    private static long[][] multiply(long[][] m1, long[][] m2) {

        long[][] multi = new long[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                long val = 0;
                for (int k = 0; k < m1[0].length; k++) {
                    val += (m1[i][k] * m2[k][j]);
                }
                val %= 12357;
                multi[i][j] = val;
            }
        }
        return multi;
    }

    private static void dfsBuildMatrix(long[][] transferMatrix, int x, int y, int col, int k) {

        if (col == k)
        {
            //当前行遍历到最后一列，且上一行填满。 即此时x可以转化为y
            transferMatrix[x][y]++;
            return;
        }

        //不放置,当前行x为0,上一行y为1
        dfsBuildMatrix(transferMatrix,x<<1,(y<<1)+1,col+1,k);

        //竖放,当前行x为1，上一行y为0
        dfsBuildMatrix(transferMatrix,(x<<1)+1,y<<1,col+1,k);

        //横放,3 二进制为11，表示当前列和下一列都为1
        if (col + 2 <= k) {
            dfsBuildMatrix(transferMatrix, (x << 2) + 3, (y << 2) + 3, col + 2,
                    k);
        }
    }


}
