package Top_Interview_Questions_2;

public class Question62_迷宫路径数 {

    static int ans;
    static int[][] dp;

    //dfs超时，动态规划  dp[i][j] 表示起点到(i,j)点时的路径数
    //状态转移方程:      dp[i][j] = dp[i-1][j]+dp[i][j-1];
    public static int uniquePaths(int m, int n) {

        dp = new int[m][n];

        for (int i = 0 ; i < m ; i++)
            dp[i][0] = 1;

        for (int i = 0 ; i < n ;i++)
            dp[0][i] = 1;

        for (int i = 1; i  < m ; i++)
            for (int j = 1 ; j < n ; j++)
                dp[i][j] = dp[i-1][j]+dp[i][j-1];


        return dp[m-1][n-1];
    }


    public static int DPuniquePaths(int m, int n) {

        ans = 0;

        dfs(m,n,0,0);

        return ans;
    }

    private static void dfs(int m, int n, int x, int y) {

        if (x==m-1 && y==n-1)
        {
            ans++;
            return;
        }

        if (x+1 < m)
            dfs(m,n,x+1,y);
        if (y+1 < n)
            dfs(m,n,x,y+1);

    }

    public static void main(String[] args){

        System.out.println(uniquePaths(3,7));


    }
}
