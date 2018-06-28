package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/28 10:30
 * @Description:
 *
 * 注意图是有向图还是无向图
 * 多源最短路径：Floyd算法
 *
 * 动态规划：e[i][j]表示从i到j的最短路径。
 * 从i号顶点到j号顶点只经过前k号点的最短路程。
 * 其实这是一种“动态规划”的思想！
        for(k=1;k<=n;k++)
            for(i=1;i<=n;i++)
                for(j=1;j<=n;j++)
                    if(e[i][j]>e[i][k]+e[k][j])
                        e[i][j]=e[i][k]+e[k][j];
 *
 */
public class 最短路径二_多源最短路径 {

    static int maxN = 105;
    static int maxM = 1005;
    static int MAX = 1000005;
    static int[][] edges = new int[maxN][maxN];
    static int n, m ;


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");

        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        
        for (int i = 1; i <= n ; i++)
            for (int j = 1;  j <= n ; j++)
                if (i == j)
                    edges[i][j] = 0;
                else
                    edges[i][j] = MAX;
        
        for (int i = 1 ; i <= m ; i++)
        {
            parts = in.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            edges[x][y] = Math.min(edges[x][y],Integer.parseInt(parts[2]));
            edges[y][x] = Math.min(edges[y][x],Integer.parseInt(parts[2]));
        }
        
        for(int k = 1;  k <= n ; k ++)
            for (int i = 1 ; i <= n ; i++)
                for (int j = 1 ; j <= n ; j++)
                    if (edges[i][k] + edges[k][j] < edges[i][j])
                        edges[i][j] = edges[i][k] + edges[k][j];
        
        for (int i = 1 ; i <= n ; i++) {
            System.out.print(edges[i][1]);
            for (int j = 2; j <= n; j++) {
                System.out.print(" " + edges[i][j]);
            }
            System.out.println();
        }
    }

}
