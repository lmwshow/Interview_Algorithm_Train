package Top_Interview_Questions_2.图论;

public class Question200_连通图的个数 {

    static int ans;
    static boolean[][] visit;

    static int[][] step = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {

        ans = 0;
        if (grid == null || grid.length == 0)
            return ans;

        int n = grid.length;
        int m = grid[0].length;
        visit = new boolean[n][m];

        for (int i = 0 ; i < n ;i++)
        {
            for (int j = 0 ; j < m ;j++)
            {
                if (grid[i][j] == '0'||visit[i][j])
                    continue;

                helper(grid,i,j);
                ans++;
            }
        }

        return ans;

    }

    private void helper(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'||visit[i][j])
            return;

        visit[i][j] = true;

        for (int k = 0 ; k < step.length;k++)
            helper(grid,i+step[k][0],j+step[k][1]);

    }

}
