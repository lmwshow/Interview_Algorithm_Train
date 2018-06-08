package hihocoder.树练习;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @Auther: minGW
 * @Date: 2018/6/7 10:39
 * @Description: https://blog.csdn.net/qq_35935435/article/details/54916022
 *
 * DFS + ST
 * ①DFS(从右到左)
 * 假设遍历顺序从右至左，则DFS遍历可得。
    DFS遍历序列F_____________1 3 5 7 5 6 5 3 4 3 1 2
    深度序列deep______________1 2 3 4 3 4 3 2 3 2 1 2
    结点首次出现位置first ____1 12 2 9 3 6 4
    对于查询两个结点的LCA就是各自首次出现位置间深度最小的结点。于是可以转化为RMQ问题，在一段区间中寻找最小值。所以再用ST算法解决该问题。
    根据例题，如果询问LCA(4,7)，就相当于RMQ(4,7)。first[4]=9，first[7]=4。在深度序列中区间(4,9)是4 3 4 3 2 3，而最近公共祖先的深度就是这段区间中最小的2。再将深度代入遍历序列得到LCA(4,7)=3。
    ②ST
    令F[i,j]为从下标i开始，长度为2^j的元素的最小值。那么状态转移方程就是F[i,j]=min(F[i,j-1],F[i+2^(j-1),j-1])。这个式子在这里有详细解释哦！
    ③查询
    假如要查询[m,n]的最小值，那么先求出一个最大的k。使k满足2^k<=(n-m+1)。于是我们可以将[m,n]分成两个（部分重叠的）长度为2^k的区间:[m,m+2^k-1],[n-2^k+1,n];
    F[m,k]为F[m,m+2^k-1]的最小值，F[n-2^k+1,k]是[n-2^k+1,n]的最小值。状态转移方程：RMQ(i,j)=min(F[m,k],F[n-2^k+1,k]);
 */
public class LCA在线算法 {

    static int M = 100009;
    static int[] dep = new int[M];          //记录深度序列
    static int[] pos = new int[M];          //记录节点首次出现的序列
    static int[] f = new int[M];            //记录DFS序列
    static int[] indeg = new int[M];           //表示每个节点的度数
    static Vector<Integer>[] adj = new Vector[M];  //记录邻接表
    static Map<String,Integer> map = new HashMap<>();  //名称和序号的map
    static String[] name = new String[M];
    static int n,m,tot;

    static int[][] dp = new int[M][100];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        //n条边的话，点需要初始化两倍 2*n，避免每条边的点都不一样
        for (int i = 0 ; i <= 2*n; i++)
            adj[i] = new Vector<>();

        for (int i = 0 ; i < n ;i ++)
        {
            String[] parts = in.readLine().split(" ");
            String a = parts[0];
            String b = parts[1];
            if (!map.containsKey(a))
            {
                map.put(a,++tot);       //tot表示序列
                name[tot] = a;
            }
            if (!map.containsKey(b))
            {
                map.put(b,++tot);
                name[tot] = b;
            }

            adj[map.get(a)].add(map.get(b));    //插入树
            indeg[map.get(b)] ++;

        }

        tot = 0;

        for (int i = 1 ; i <= n ; i++)
        {
            if (indeg[i] == 0)                 //找到根节点
            {
                dfs(i,-1,0);
                break;
            }
        }

        st();               //RMQ运用了ST算法

        m = Integer.parseInt(in.readLine());
        for (int i = 0 ; i < m ; i++)
        {
            String[] parts = in.readLine().split(" ");
            String a = parts[0];
            String b = parts[1];

            int atot = map.get(a);
            int btot = map.get(b);
            int ans = rmq(atot,btot);           //ans 是区间atot到btot中dep最小的数
            System.out.println(name[f[ans]]);
        }
    }

    private static int rmq(int l, int r) {

        l = pos[l];
        r = pos[r];
        if (l > r)
        {
            int tmp = l;
            l = r;
            r =tmp;
        }

        int len = r - l +1;
        int k = (int) ((Math.log(len)/Math.log(2)));

        if (dep[dp[l][k]]< dep[dp[r - (1 << k)+1][k]]) return dp[l][k];
        return dp[r - (1 << k)+1][k];
    }

    private static void st() {
        for (int i = 1 ; i <= tot ; i++)
            dp[i][0] = i ;              //dp[i][j]表示从下标i开始，长度为2^j的元素的RMQ,初始化，即每个长度为1的区间的RMQ就是本身


        //注意循环的顺序，会发现j在外层，i在里层。这是由于动态转移方程的意义所限制
        //即外层循环表示 遍历区间段大小, 1 2 4...         这样大区间才能通过记忆缓存小区间计算
        //状态转移方程就是F[i,j]=min(F[i,j-1],F[i+2^(j-1),j-1])
        for (int j = 1 ; (1 << j) <= tot ; j++)
        {
            for (int i = 1 ; i + (1 << j) - 1 <= tot ; i++)
            {
                int mid = i + (1<<(j-1));
                if (dep[dp[i][j-1]] < dep[dp[mid][j-1]])
                    dp[i][j] = dp[i][j-1];

                else
                    dp[i][j] = dp[mid][j-1];
            }

        }

    }

    private static void dfs(int u, int pre, int depth) {

        f[++tot] = u;       //f用来记录dfs遍历的序列，先右后左
        pos[u] = tot;       //记录第一次出现的地方
        dep[tot] = depth;   //记录当前深度

        //遍历子节点
        for (int i = 0; i < adj[u].size() ; i ++)
        {
            int v = adj[u].get(i);
            if (v == pre) continue;             //访问过不再递归
            dfs(v,u,depth+1);
            f[++tot] = u;       //这里不会是第一次出现的地方，所以不用设置pos
            dep[tot] = depth;
        }

    }


}
