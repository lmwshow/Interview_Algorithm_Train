package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/21 09:00
 * @Description:
 *
 * 给定无孤立结点图G，若存在一条路，经过图中每边一次且仅一次，该条路称为欧拉路
 *
 * 欧拉路是有判定条件的：一个无向图存在欧拉路当且仅当该图是连通的且有且只有2个点的度数是奇数，此时这两个点只能作为欧拉路径的起点和终点。
 * 1. 连通的
 * 2. 只有2个点的度数是奇数或者0个
 * (因为除了起点和终点,中间的点必然有进有出，所以肯定度数是偶数)
 *
 * 对于有向图，其存在欧拉路的条件是，至多有两个点的入度不等于出度，且这两个点满足：其中一个点入度比出度多1，另一个点出度比入度多1。
 *
 * 严格的证明的话：
 * 若图G连通，有零个或两个奇数度结点，我们总有如下方法构造一条欧拉路：
 * 若有两个奇数度结点，则从其中的一个结点开始构造一条迹，即从v[0]出发经关联边e[1]“进入”v[1]，若v[1]的度数为偶数，则必可由v[1]再经关联边e[2]进入v[2]，如此进行下去，每边仅取一次。由于G是连通的，故必可到达另一奇数度结点停下，得到一条迹L：v[0]-e[1]-v[1]-e[2]…v[i]-e[i+1]…v[k]。若G中没有奇数度结点则从任一结点v[0]出发，用上述方法必可回到结点v[0]，得到上述一条闭迹L1。
 * 若L1通过了G的所有边，则L1就是欧拉路。
 * 若G中去掉L1后得到子图G′，则G′中每个结点度数为偶数，因为原来的图是连通的，故L1与G′至少有一个结点v[i]重合，在G′中由v[i]出发重复第一步的方法，得到闭迹L2。
 * 当L1与L2组合在一起，如果恰是G，则即得欧拉路，否则重复第三步可得到闭迹L3，以此类推直到得到一条经过图G中所有边的欧拉路。
 *
 *
 */
public class 欧拉路一 {

    //简洁来说就是判断出入度+并查集判断连通分量个数。

    static int maxn = (int) (1e5 + 10);
    static int[] degree = new int[maxn];
    static int[] father = new int[maxn];
    static int[] rnk = new int[maxn];
    static int n ;
    static int m;


    private static void makeSet()  //初始化并查集
    {
        for (int i = 0 ; i < n ;i ++)
        {
            father[i] = i;
            rnk[i] = 0;
        }
    }

    private static int findSet(int x)  //查找父节点
    {
        if (x != father[x])
            father[x] = findSet(father[x]);

        return father[x];
    }

    private static void unionSet(int x, int y) //合并
    {
        x = findSet(x);
        y = findSet(y);
        if (x == y)
            return;

        //加入rank[N]来记录每个节点的秩（即树的高度），并按秩进行合并，可避免合并时的最糟糕情况，（树形为一条直线）
        if (rnk[x] > rnk[y]) father[y] = x;
        else
        {
            father[x] = y;
            rnk[y] += (rnk[x] == rnk[y])?1:0;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = in.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);

        makeSet();
        for (int i = 0 ; i < m ; i++)
        {
            parts = in.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            degree[u] ++;
            degree[v] ++;
            unionSet(u,v);
        }

        int cnt = 0;
        int cnt2 = 0;

        //有几个连通图说明有几个根父节点
        for (int i = 1 ; i <= n ; i++)
        {
            if (findSet(i) == i)
                cnt++;

            if ((degree[i] & 1) == 1)
                cnt2++;
        }

        if (cnt == 1 &&(cnt2 == 0 || cnt2 == 2))
            System.out.println("Full");
        else
            System.out.println("Part");


    }

}
