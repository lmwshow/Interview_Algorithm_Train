package dp;

/**
 * Created by Gracecoder on 2017/2/28.
 */
public class leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;    //行数
        int n = obstacleGrid[0].length; //列数
        boolean flag = false;           //初始化第一行 ，第一列的时候用，遇到障碍物后，需要使后面的都为0，后面的障碍物也要置0，不能为1混淆意义
                                        //这里是直接在obstacleGrid上处理， 当然可以另外新建 dp[m][n]来模拟

        if (obstacleGrid[0][0]== 1)
            return 0;

        for (int i = 0; i < n ; i ++)
        {
            if (flag)
            {
                obstacleGrid[0][i] = 0;
                continue;
            }

            if (obstacleGrid[0][i] == 1)
            {
                obstacleGrid[0][i] = 0 ;
                flag = true;
                continue;
            }
            obstacleGrid[0][i] = 1;
        }

        flag = false;

        for (int i = 1 ; i < m ; i ++)
        {
            if (flag)
            {
                obstacleGrid[i][0] = 0;
                continue;
            }

            if (obstacleGrid[i][0] == 1)
            {
                obstacleGrid[i][0] = 0;
                flag = true;
                continue;
            }
            obstacleGrid[i][0] = 1;
        }

        for (int i = 1 ; i < m ; i ++)
            for (int j = 1 ;j < n ; j ++)
            {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }

        return obstacleGrid[m-1][n-1];
    }
}
