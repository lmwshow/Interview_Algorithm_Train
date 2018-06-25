package hihocoder.图论;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**

 *
 * @Auther: minGW
 * @Date: 2018/6/22 19:26
 * @Description
 * https://blog.csdn.net/spark__s/article/details/69525645
 *
 * 割边：在连通图中，删除了连通图的某条边后，图不再连通。这样的边被称为割边，也叫做桥。
 * 割点：在连通图中，删除了连通图的某个点以及与这个点相连的边后，图不再连通。这样的点被称为割点。
 *
 * 树边：在搜索树中的蓝色线所示，可理解为在DFS过程中访问未访问节点时所经过的边，也称为父子边
 * 回边：在搜索树中的橙色线所示，可理解为在DFS过程中遇到已访问节点时所经过的边，也称为返祖边、后向边
 *
 * 用dfn[u]记录节点u在DFS过程中被遍历到的次序号，low[u]记录节点u或u的子树通过非父子边追溯到最早的祖先节点（即DFS次序号最小），那么low[u]的计算过程如下：
 *
 *      low[u] = min(low[u]+low[v])    s.t. (u,v)为树边
 *      low[u] = min(low[u],dfn[v])    s.t. (u,v)为回边且v不为u的父亲节点，因为low表示通过非树边到达的最早祖先
 *
 * 使用Tarjan算法
 *
 * 分析：tarjan求无向连通图的割点与割边(桥)。
引理：对于连通无向图G={V,E}，S={V,T}为G的一个DFS树，则结点u是G的割点当且仅当下面条件之一被满足：

1.  u是T的根且u至少有两个儿子

2.  u不是T的根且存在u的某个儿子w，使得从w或者w的后代没有边连回u的祖先（注意，不是连回u本身）。
 */
public class 连通性一_割边与割点minGW {

    static int maxN = 20005;
    static int[] dfn = new int[maxN];
    static int[] low = new int[maxN];
    static int[] have = new int[maxN];              //标记是否已经加入
    static int[] parent = new int[maxN];
    static int[] visit = new int[maxN];             //标记是否已经访问
    static int[] ansNode = new int[maxN];
    static int n,m,counter,anscount;
    static Graph graph;
    static List<Edge> ans;

    static class Vertex {
        public final int index;
        public ArrayList<Edge> neighbours;
        public int deg;

        public Vertex(int index) {
            this.index = index;
            neighbours = new ArrayList<Edge>();
        }

    }


    static class Edge {
        public final Vertex source;
        public final Vertex target;

        public Edge(Vertex source, Vertex target) {
            this.source = source;
            this.target = target;
        }
    }


    static class Graph {
        private Vertex[] vertices;

        public Graph(int numberVertices) {
            vertices = new Vertex[numberVertices + 1];
            for (int i = 1; i <= numberVertices; i++) {
                vertices[i] = new Vertex(i);
            }
        }

        public void addEdge(int src, int dest) {
            Vertex s = vertices[src];
            Vertex d = vertices[dest];
            Edge new_edge = new Edge(s, d);
            Edge re_edge = new Edge(d, s);

            s.neighbours.add(new_edge);
            d.neighbours.add(re_edge);
            d.deg++;
            s.deg++;
        }

        public void removeVertex(int index) {
            Vertex v = vertices[index];
            for (Edge edge : v.neighbours) {
                Vertex dest = edge.target;
                dest.deg--;
            }

        }

        public Vertex[] getVertices() {
            return vertices;
        }

        public Vertex getVertex(int vert) {
            return vertices[vert];
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = in.readLine().split(" ");

        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        graph = new Graph(n);
        for (int i = 0 ; i < m ; i++)
        {
            parts = in.readLine().split(" ");
            graph.addEdge(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
        }

        ans = new ArrayList<>();

        tarjan(1);//如果已经确定是连通图，就这样写
        /*
        否则要这样
        for(int i = 1; i <= n; i++) {
            if(dfn[i] == 0) tarjan(1);
        }
        */

        if (anscount == 0) System.out.println("Null");
        else {

            Arrays.sort(ansNode,0,anscount);
            System.out.print(ansNode[0]);

            for (int i = 1; i < anscount;i++)
                System.out.print(" " + ansNode[i]);

            System.out.println();
        }


        ans.sort((e1,e2)->{
            if (e1.source.index == e2.source.index)
                return e1.target.index - e2.target.index;

            else
                return e1.source.index - e2.source.index;
        });



        for (Edge e : ans)
            System.out.println(e.source.index + " " + e.target.index);
    }

    private static void tarjan(int u) {

        dfn[u] = low[u] = ++ counter;
        int children = 0;       //计算u的儿子节点个数
        visit[u] = 1;
        List<Edge> edges = graph.getVertex(u).neighbours;
        for (int i = 0 ; i < edges.size();i++)
        {
            int v = edges.get(i).target.index;

            //未访问
            if (visit[v] == 0)
            {
                children++;
                parent[v] = u;
                tarjan(v);
                low[u] = Math.min(low[u],low[v]);

                if ((parent[u] == 0 && children > 1) || (parent[u]!=0 && low[v] >= dfn[u]))
                {
                    if (have[u] == 0)
                    {
                        ansNode[anscount++] = u;
                        have[u] = 1;
                    }

                }

                //判断是否割边(桥)
                if (low[v] > dfn[u])
                    ans.add(new Edge(new Vertex(Math.min(v,u)),new Vertex(Math.max(v,u))));

            }
            //关键点
            //已访问，说明是回边   搞明白low的定义，记录节点u或u的子树通过非父子边追溯到最早的祖先节点，有这定义，才有上面对割点割边的判断，所以需要v不是u的父亲节点
            else if (v != parent[u])
                low[u] = Math.min(low[u],dfn[v]);



        }

    }
}
