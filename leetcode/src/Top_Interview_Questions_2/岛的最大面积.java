package Top_Interview_Questions_2;

/**
 * @Auther: minGW
 * @Date: 2018/8/29 20:54
 * @Description:
 */
public class 岛的最大面积 {

    static int max = 0;
    static int count = 0;
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {

        max = 0;
        if (grid == null || grid.length == 0)
            return max;

        boolean[][] visit = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    count = 0;
                    dfs(grid, visit, i, j);
                    max = Math.max(max, count);
                }
            }


        return max;

    }

    private void dfs(int[][] grid, boolean[][] visit, int x, int y) {

        visit[x][y] = true;
        count++;
        for (int i = 0; i < dir.length; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];

            if (nextx >= 0 && nextx < grid.length && nexty >= 0 && nexty < grid[0].length && grid[nextx][nexty] == 1 && !visit[nextx][nexty])
                dfs(grid, visit, nextx, nexty);
        }

    }
}
