package hihocoder.编程练习赛57;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/4/29 12:53
 * @Description: http://hihocoder.com/problemset/problem/1734?sid=1313017
 * 现在小Hi可以用魔法移除一个格子上的障碍，也就是'#'变成'.'，使其可以经过。

    请你计算在只能移除一处障碍的情况下，小Hi最少移动多少步可以逃离迷宫。

    三维动态规划 dp[i][j][k]  表示到达map[i][j]在状态为k的情况下的最小步数， k大小为2,0表示用过魔法，1表示没用过
 */
public class Q3_逃离迷宫5 {
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;

        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++)
            map[i] = in.next().toCharArray();

        int[][][] dp = new int[n][n][2];

        for (int[][] t : dp)
            for (int[] tt : t)
                Arrays.fill(tt, 1000009);           //初始化

        dp[0][0][0] = 0;
        dp[0][0][1] = 0;

        int[][]dirs={{1,0},{-1,0},{0,1},{0,-1}};


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});  //起点
        while (!queue.isEmpty())
        {
            int[] t = queue.remove();
            int i = t[0];
            int j = t[1];
            if (i == n-1 && j==n-1)
            {
                System.out.println(Math.min(dp[n-1][n-1][0], dp[n-1][n-1][1]));
                return;
            }

            for (int[]d : dirs)         //遍历每个点的四个方向
            {
                int ii = i + d[0],jj = j + d[1];
                if (ii <0 || jj < 0 || ii >=n || jj >= n)           //越界检查
                    continue;
                if (map[ii][jj] == '.')                             //不是障碍,都能走
                {
                    if (dp[i][j][0] + 1 < dp[ii][jj][0] || dp[i][j][1] + 1 < dp[ii][jj][1])
                        queue.add(new int[]{ii,jj});

                    dp[ii][jj][0] = Math.min(dp[i][j][0] + 1,dp[ii][jj][0]);
                    dp[ii][jj][1]=Math.min(dp[ii][jj][1], dp[i][j][1]+1);

                }else                                               //是障碍，只能还没用魔法的状态能走
                {
                    if (dp[i][j][1] + 1 < dp[ii][jj][0])
                        queue.add(new int[]{ii,jj});
                    dp[ii][jj][0]=Math.min(dp[ii][jj][0], dp[i][j][1]+1);

                }
            }

        }

        System.out.println(-1);

    }
}
