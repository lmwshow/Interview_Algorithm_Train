package Top_Interview_Questions.搜索;

/**
 * Created by Gracecoder on 2017/10/16.
 */
public class Number_of_Islands {

    private static int[][] visit;
    private static int count;
//    private static int[][] step = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public static int numIslands(char[][] grid) {

        count = 0;
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;

        visit = new int[m][n];

        for (int i = 0 ; i < m ;i++)
            for (int j = 0 ; j < n ; j++)
            {
                if (visit[i][j] == 0) {
                    dfs(grid, visit, i, j);

                    if (grid[i][j]=='1')
                        count ++;
                }
            }

        return count;

    }

    private static void dfs(char[][] grid, int[][] visit,int x,int y) {

        visit[x][y] = 1;
        if (grid[x][y] == '0')
            return;
        else
        {
            if (x - 1 >= 0 && visit[x-1][y]==0)
                dfs(grid,visit,x-1,y);
            if (x + 1 < visit.length && visit[x+1][y]==0)
                dfs(grid,visit,x+1,y);
            if (y - 1 >= 0 && visit[x][y-1]==0)
                dfs(grid,visit,x,y-1);
            if (y+1 < visit[0].length && visit[x][y+1]==0)
                dfs(grid,visit,x,y+1);
        }
    }


     public static void main(String[] args){

         char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};

         System.out.println(numIslands(grid));


     }
}
