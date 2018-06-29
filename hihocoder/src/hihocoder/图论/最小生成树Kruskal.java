package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Auther: minGW
 * @Date: 2018/6/29 09:10
 * @Description http://hihocoder.com/problemset/problem/1098
 *
 * Kruskal算法（使用并查集）

 * Kruskal算法一开始将每个点视为一个集合，然后每次取最小的边，边的两端如果已经在同一个集合中则跳过，否则进行连接形成生成树，同时将边的两端点并为一个集合。
 * 到最后生成一颗最小生成树。
 *
 * 适合于点多，边少的稀疏图
 */
public class 最小生成树Kruskal {

    static int maxN = 100005;
    static int maxM = 1000005;
    static int n, m;
    static int[] father = new int[maxN];
    static Edge[] edges = new Edge[maxM];
    static int[] rnk = new int[maxN];


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

    private static boolean unionSet(int x, int y) //合并
    {
        x = findSet(x);
        y = findSet(y);
        if (x == y)
            return false;

        //加入rank[N]来记录每个节点的秩（即树的高度），并按秩进行合并，可避免合并时的最糟糕情况，（树形为一条直线）
        if (rnk[x] > rnk[y]) father[y] = x;
        else
        {
            father[x] = y;
            rnk[y] += (rnk[x] == rnk[y])?1:0;
        }
        return true;
    }


    static class Edge{
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts ;
        parts = in.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);

        for (int i  = 0 ; i < m ; i++)
        {
            parts = in.readLine().split(" ");
            edges[i] = new Edge(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
        }

        //初始化每个点的根节点，一开始每个点本身就是每个集合的根节点
        makeSet();

        Arrays.sort(edges,0,m,(edge1,edge2)->{
            return edge1.weight - edge2.weight;
        });

        int min_tree = 0 , cnt = 0;

        //对所有边进行判断选择，每次选择集合外最小的边，通过并查集判断是否在一个集合
        for (int i = 0 ; i < m ; i++)
        {
            if (unionSet(edges[i].x,edges[i].y))
            {
                min_tree += edges[i].weight;
                cnt++;
            }
            //最小生成树的边为n-1条
            if (cnt == n-1)
                break;

        }

        System.out.println(min_tree);




    }



}
