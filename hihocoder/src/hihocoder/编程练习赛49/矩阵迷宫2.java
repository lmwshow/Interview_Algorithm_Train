package hihocoder.编程练习赛49;

import java.util.Scanner;

/*
解题思路：
典型的动态规划问题：
设dp[i][j][s][d] 为人站在I,j上目前已经转向了s次，朝向为d(0为向右，1为向下)时，总代价最小为多少，则ans = min{dp[n-1][n-1][s][d]} (s=[0-15], d=0,1);
由于A[i][j]<=100 所以最多的代价也就100*200+1 解释为走200步，再加一个转向。所以当转向次数过多时是高于这个数的。可以判断出s最多只要15。
然后的话是转移议程
Dp[i][j][s][d] = min(
dp[i-1][j][s][d] + A[i][j] 上面直走来的
dp[i-1][j][s-1][d^1]+ A[i][j] +(1<<(s-1)) 上面拐过来的
dp[i][j-1][s][d]+ A[i][j]  左面直走来的
dp[i][j-1][s-1][d^1] + A[i][j] +(1<<(s-1)) 左面拐过来的
)

以上公式注意边界判断 如i-1>=0，j-1>=0, s-1>=0。
 */

public class 矩阵迷宫2 {


    static int dir[][] = {{0,1},{1,0}};
    static int maze[][];
    static int dp[][][][];
    static int maxStep = 16 ;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        maze = new int[n][n];
        dp = new int[n][n][maxStep][2];

        for (int i = 0 ;i < n ;i++)
        {
            for (int j = 0 ;j < n ;j++)
            {
                maze[i][j] = in.nextInt();
                for (int s = 0 ;s < maxStep ; s++)
                    dp[i][j][s][0] = dp[i][j][s][1] = Integer.MAX_VALUE;
            }
        }



        int ans = getAns(n);

        System.out.println(ans);

    }

    private static int getAns(int n) {

        dp[0][0][0][0] = maze[0][0];

        dp[0][0][0][1] = maze[0][0];

        for (int i = 0 ;i < n;i++)
        {
            for (int j = 0 ;j < n ; j++)
            {
                for (int s = 0 ; s < maxStep ; s++)
                {
                    for (int d = 0 ; d < 2; d++)
                    {
                        int t = dp[i][j][s][d];
                        if (t == Integer.MAX_VALUE) continue;;

                        //向原方向走
                        int cor[] = getNextStep(i,j,d,0);
                        if (isInRange(cor,n))
                        {
                            dp[cor[0]][cor[1]][s][d] = Math.min(dp[cor[0]][cor[1]][s][d],t + maze[cor[0]][cor[1]]);
                        }

                        //变换反向
                        cor = getNextStep(i,j,d,1);
                        if (s+1 < maxStep && isInRange(cor,n))
                        {
                            dp[cor[0]][cor[1]][s+1][d^1] = Math.min(dp[cor[0]][cor[1]][s+1][d^1],t + maze[cor[0]][cor[1]] + (1 << s));

                        }
                    }
                }
            }
        }


        int ans = Integer.MAX_VALUE;

        for (int s = 0 ;s < maxStep ; s++)
        {
            for (int d = 0 ; d < 2; d++)
                ans = Math.min(dp[n-1][n-1][s][d],ans);
        }

        return ans;
    }

    private static boolean isInRange(int[] cor, int n) {

        if (cor[0] >= n || cor[1] >= n)
            return false;
        return true;
    }

    private static int[] getNextStep(int i, int j, int d, int isForward/*是否原方向，0为是*/) {

        d ^= isForward; //是否变化方向,0不变 1变
        int ans[] = new int[]{i+dir[d][0],j+dir[d][1]};
        return ans;
    }
}
