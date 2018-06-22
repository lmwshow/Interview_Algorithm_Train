package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/21 09:51
 * @Description: http://hihocoder.com/problemset/problem/1181
 *
 * 理解题目的本意，要把所有的骨牌连起来，也就是把所有的边都走一次，就是求欧拉路径
 * Fleury算法求欧拉路径
 *
 * 在上一次的证明中我们知道，除了L1之外，其他的路径L2、L3...一定都满足起点与终点为同一个点。所以从任意一个公共节点出发一定有一条路径回到这个节点。
 * 由此我们得到了一个算法：
 *  1.在原图中找一个L1路径
 *  2.从L1的终点往回回溯，依次将每个点出栈。并检查当前点是否还有其他没有经过的边。若存在则以当前点为起点，查找L2，并对L2的节点同样用栈记录重复该算法。
 *  3.当L1中的点全部出栈后，算法结束。
 *
 * 而且这个算法在实现时也有很巧妙的方法。因为DFS本身就是一个入栈出栈的过程，所以我们直接利用DFS的性质来实现栈
 */
public class 欧拉路二_无向图的欧拉回路 {

    static int N = 1005;
    static int[] degree = new int[N];
    static int[][] map = new int[N][N];                 //因为数据量较小，使用连接矩阵
    static int[] ans = new int[5005];
    static int top,n,m;                                     //top表示栈顶位置


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = in.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);

        for (int i = 0 ; i < m ; i++)
        {
            parts = in.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            map[u][v] ++;                       //记录边，因为是无向图，所以加两条边，两点之间可能有多条边
            map[v][u] ++;
            degree[u] ++;
            degree[v] ++;
        }

        int flag = 1;                   //flag标记开始点。 如果所有点度数全为偶数那就从1开始搜

        int cnt = 0;
        for (int i = 1 ; i <= n ;i++)
        {
            if ((degree[i] & 1) == 1)
            {
                cnt ++;
                flag = i;
            }
        }

        if (cnt == 0 || cnt == 2)
            fleury(flag);
    }

    private static void fleury(int x) {

        top = 1;
        ans[top] = x;

        while (top > 0)
        {
            int k = 0;
            for (int i = 1 ; i <= n;i++)            //判断是否可扩展
            {
                if (map[ans[top]][i] >= 1)          //若存在一条从ans[top]出发的边  那么就是可扩展
                {
                    k = 1;
                    break;
                }
            }

            if (k == 0)                             //该点x没有其他的边可以先走了（即不可扩展）， 那么就输出它
            {
                if (top == 1)
                    System.out.println(ans[top]);
                else
                    System.out.print(ans[top]+" ");

                top--;
            }else if (k == 1)                       //如可扩展， 则dfs可扩展的哪条路线
            {
                top--;                              //这需要注意
                dfs(ans[top+1]);
            }
        }

    }

    private static void dfs(int x) {

        ans[++top] = x;
        for (int i = 1; i <= n ; i++)
        {
            if (map[x][i]>=1)
            {
                map[x][i] -- ;
                map[i][x] -- ;
                dfs(i);
                break;
            }
        }

    }
}
