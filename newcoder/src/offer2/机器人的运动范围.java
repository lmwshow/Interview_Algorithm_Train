package offer2;

import java.util.Queue;

/**
 * @Auther: minGW
 * @Date: 2018/5/24 09:17
 * @Description: https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 *
 */
public class 机器人的运动范围 {

    static int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    static int count = 0;

    public int movingCount(int threshold, int rows, int cols)
    {
        count = 0;
        boolean[][] visit = new boolean[rows][cols];

        if (threshold < 0)
            return count;

        DFS(threshold,rows,cols,0,0,visit);

        for (int i = 0 ; i < rows ; i++)
            for (int j = 0 ; j < cols ; j++)
                if (visit[i][j])
                    count++;

        return count;
    }

    private void DFS(int threshold, int rows, int cols, int i, int j, boolean[][] visit) {

        visit[i][j] = true;

        for (int d = 0 ; d < dir.length ; d++)
        {
            int[] cur = dir[d];
            int x = i + cur[0];
            int y = j + cur[1];

            if (x >= 0 && x < rows && y >= 0 && y < cols && !visit[x][y] && canReach(threshold,x,y))
                DFS(threshold,rows,cols,x,y,visit);

        }
    }

    private boolean canReach(int threshold, int x, int y) {

        if ((bitSum(x) + bitSum(y)) > threshold)
            return false;
        return true;

    }

    private int bitSum(int x) {
        int ans = 0;

        while (x!=0)
        {
            ans += x%10;
            x /= 10;
        }
        return ans;
    }
}
