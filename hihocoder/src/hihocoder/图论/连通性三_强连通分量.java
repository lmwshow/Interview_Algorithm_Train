package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/6/25 10:32
 * @Description:
 *
 * 对于有向图上的2个点a,b，若存在一条从a到b的路径，也存在一条从b到a的路径，那么称a,b是强连通的。
 * 对于有向图上的一个子图，若子图内任意点对(a,b)都满足强连通，则称该子图为强连通子图。
 * 非强连通图有向图的极大强连通子图，称为强连通分量。
 *
 * 先根据原图找到所有的强连通分量，然后再根据原图边的关系建立新的图，之后再用拓扑排序来处理就可以得到最终结果。
 * 将每一个强连通分量缩成一个点
 * 建立一个新的图，这个图中的点对应的是每一个强连通块。
 * 若原图中存在边(u,v)，连接了属于强连通分量A的点u和属于强连通分量B的点v，那么我们就在新图中建立一条边(A,B)。
 *
 * 构建新图之后就可以使用dfs求值了
 *
 * 用Tarjan算法 求强连通分量
 */
public class 连通性三_强连通分量 {

    static int maxN = 20005;
    static int maxM = 100005;
    static int n,m,counter,sccno;
    static int[] dfn = new int[maxN];
    static int[] low = new int[maxN];
    static int[] belong = new int[maxN];
    static int[] weight = new int[maxN];
    static Edge[] edge = new Edge[maxM];

    static boolean[] instack = new boolean[maxN];
    static int[] visit = new int[maxN];
    static Graph graph,new_graph;
    static List<Integer> path = new ArrayList<>();
    static int ans = Integer.MIN_VALUE;
    static Stack<Integer> stack = new Stack<>();


    static class Vertex {
        public final int index;
        public ArrayList<Edge> neighbours;
        public int weight;
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

            s.neighbours.add(new_edge);
            d.deg++;
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
        parts = in.readLine().split(" ");

        for (int i = 1;  i <= n ; i++)
            graph.getVertex(i).weight = Integer.parseInt(parts[i-1]);

        for (int i = 1 ; i <= m ; i++)
        {
            parts = in.readLine().split(" ");
            edge[i] = new Edge(new Vertex(Integer.parseInt(parts[0])),new Vertex(Integer.parseInt(parts[1])));
            graph.addEdge(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
        }

        tarjan(1);
        new_graph = new Graph(sccno);
        reconstruct_graph();

        dfs(belong[1],weight[belong[1]]);

        System.out.println(ans);

    }

    private static void reconstruct_graph() {

        for (int i = 1 ; i <= m;i++)
        {
            int u = belong[edge[i].source.index];
            int v = belong[edge[i].target.index];

            if (u == 0 || v == 0)//点1出发不能到达的点不需进入新图
                continue;

            if (u != v)
                new_graph.addEdge(u,v);
        }
    }


    private static void tarjan(int u) {

        //记录dfs遍历次序,因为tarjan算法的复杂度是O(m+n),所以dfn其实可以用来当visit
        dfn[u] = low[u] = ++counter;

        instack[u] = true;
        stack.push(u);

        List<Edge> edges = graph.getVertex(u).neighbours;
        for (int i = 0 ; i < edges.size() ; i++)
        {
            int v = edges.get(i).target.index;

            if (dfn[v] == 0)
            {
                tarjan(v);
                low[u] = Math.min(low[u],low[v]);
            }
            if (instack[v])         // 如果节点v还在栈内(很重要,无向图没有这一步)
                low[u] = Math.min(low[u],dfn[v]);

        }


        //划分强连通图
        // 因为low[u] == dfn[u]，对(parent[u],u)来说有dfn[u] > dfn[ parent[u] ]，因此low[u] > dfn[ parent[u] ]
        // 所以(parent[u],u)一定是一个桥，那么此时栈内在u之前入栈的点和u被该桥分割开
        // 则u和之后入栈的节点属于同一个组
        //将从u到栈顶所有的元素标记为一个组，并弹出这些元素。
        if (low[u] == dfn[u])
        {
            //记录强连通分量数量
            sccno++;
            while (!stack.isEmpty())
            {
                int cur = stack.pop();
                instack[cur] = false;
                belong[cur] = sccno;
                weight[sccno] += graph.getVertex(cur).weight;
                if (u == cur)
                    break;
            }
        }




    }

    private static void dfs(int u,int cur) {

        List<Edge> edges = new_graph.getVertex(u).neighbours;

        for (int i = 0 ; i < edges.size() ; i++)
        {
            int v = edges.get(i).target.index;
            if (visit[v] == 1)
                continue;

            visit[v] = 1;
            dfs(v,cur + weight[v]);
            visit[v] = 0;
        }

        ans = Math.max(cur,ans);
    }

}
