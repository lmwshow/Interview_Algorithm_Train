package hihocoder.编程练习赛49;

import java.util.Scanner;

public class 矩阵迷宫 {

//    这样子深搜超时，需要剪枝， 不用每个路径都搜索，对于每个节点

//    static int minPath = Integer.MAX_VALUE;
//
//    public static void main(String[] args){
//
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//
//        int[][] map = new int[n+1][n+1];
//
//        for (int i = 1 ; i <= n ; i ++)
//            for (int j = 1 ; j <= n ; j++)
//                map[i][j] = in.nextInt();
//
//
//        //记录当前方向，0为无方向 1为右 2为下
//        dfs(map,n,1,1,1,map[1][1],0);
//
//        System.out.println(minPath);
//
//
//    }
//
//    private static void dfs(int[][] map,int length, int x, int y, int pay, int cur,int dir) {
//
//        if (x == length && y == length)
//        {
//            minPath = Math.min(minPath,cur);
//            return;
//        }
//
//
//
//        if (dir == 0)
//        {
//            if (x <= length-1)
//                dfs(map,length,x+1,y,pay,cur+map[x+1][y],2);
//            if (y <= length-1)
//                dfs(map,length,x,y+1,pay,cur+map[x][y+1],1);
//        }
//
//        if (dir == 1)
//        {
//            if (x <= length-1)
//                dfs(map,length,x+1,y,pay*2,cur+map[x+1][y]+pay,2);
//            if (y <= length-1)
//                dfs(map,length,x,y+1,pay,cur+map[x][y+1],1);
//        }
//
//        if (dir == 2)
//        {
//            if (x <= length-1)
//                dfs(map,length,x+1,y,pay,cur+map[x+1][y],2);
//            if (y <= length-1)
//                dfs(map,length,x,y+1,pay*2,cur+map[x][y+1] + pay,1);
//        }
//
//
//    }


    //每个点都有两个方向，向下和向右的代价都要记录，另外声明的辅助一维数组只能记录当前比较小的路径（不一定会是全局最小），无法记录两个
    //这里需要使用思维数组 进行dp


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] map = new int[n+1][n+1];



        for (int i = 1; i <= n; i ++)
            for (int j = 1 ; j <= n ; j++)
                map[i][j] = in.nextInt();

        //x,y,d,s d表示反向(下标0表示向右，下标1表示向下), s表示代价的次数k（0,1,2....） 2^(k-1)
        long[][][][] dp = new long[n+1][n+1][2][2];

        dp[1][1][0][0] = map[1][1];
        dp[1][1][1][0] = map[1][1];
        dp[1][1][0][1] = 1;
        dp[1][1][1][1] = 1;


        for (int i = 2; i <= n ; i++)
        {
            dp[1][i][0][0] = map[1][i] + dp[1][i-1][0][0];
            dp[1][i][0][1] = 1;

            dp[1][i][1][0] = Integer.MAX_VALUE;
            dp[1][i][1][1] = 1;

            dp[i][1][1][0] = map[i][1] + dp[i-1][1][1][0];
            dp[i][1][1][1] = 1;
            dp[i][1][0][1] = 1;
            dp[i][1][0][0] = Integer.MAX_VALUE;
        }

        //考虑越界
        for (int i = 2; i<=n; i++) {
            for (int j = 2; j <= n; j++) {


                long x1 = dp[i][j - 1][0][0];                                   //左边按原方向  往右
                long x2 = dp[i][j - 1][1][0] + (1<<(dp[i][j - 1][1][1]-1));              //左边改变方向  往右，  d=1 表示原方向向下

                dp[i][j][0][0] = Math.min(x1, x2) + map[i][j];
                if (x2 < x1)
                    dp[i][j][0][1] = dp[i][j - 1][1][1]==16?16:(dp[i][j - 1][1][1]+1);
                else
                    dp[i][j][0][1] = dp[i][j - 1][0][1];

                long y1 = dp[i - 1][j][0][0] + (1<<(dp[i-1][j][0][1]-1));              //上边
                long y2 = dp[i - 1][j][1][0];

                dp[i][j][1][0] = Math.min(y1, y2) + map[i][j];
                if (y1 < y2)
                    dp[i][j][1][1] = dp[i - 1][j][0][1]==16?16:(dp[i-1][j][0][1]+1);
                else
                    dp[i][j][1][1] = dp[i - 1][j][1][1];

            }
        }

        long ans = Math.min(dp[n][n][0][0],dp[n][n][1][0]);
        System.out.println(ans);

        System.out.println(dp[n][n][0][0]);
        System.out.println(dp[n][n][0][1]);

        System.out.println(dp[n][n][1][0]);

        System.out.println(dp[n][n][1][1]);

    }



}
