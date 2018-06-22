package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/6/22 08:49
 * @Description: https://blog.csdn.net/jhgkjhg_ugtdk77/article/details/47166809
 *
 * 割边：在连通图中，删除了连通图的某条边后，图不再连通。这样的边被称为割边，也叫做桥。
 * 割点：在连通图中，删除了连通图的某个点以及与这个点相连的边后，图不再连通。这样的点被称为割点。
 * <p>
 * 使用Tarjan算法
 *
 * 分析：tarjan求无向连通图的割点与割边(桥)。
引理：对于连通无向图G={V,E}，S={V,T}为G的一个DFS树，则结点u是G的割点当且仅当下面条件之一被满足：

1.  u是T的根且u至少有两个儿子

2.  u不是T的根且存在u的某个儿子w，使得从w或者w的后代没有边连回u的祖先（注意，不是连回u本身）。
 */
public class 连通性一_割边与割点 {

    static int maxN = 20005;
    static int[] dfn = new int[maxN];
    static int[] low = new int[maxN];
    static int n,m,counter;
    static Graph graph;
    static Set<Integer> set;
    static List<Edge> ans;
    static boolean judge;

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

        set = new HashSet<>();
        ans = new ArrayList<>();

        tarjan(1,1);//如果已经确定是连通图，就这样写
        /*
        否则要这样
        for(int i = 1; i <= n; i++) {
            if(dfn[i] == 0) tarjan(1, -1);
        }
        */

        if (!judge) System.out.println("Null");
        else {

            //点这里需要排序
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            Iterator iterator = list.iterator();
            boolean first = true;
            while (iterator.hasNext()) {
                if (first)
                {
                    System.out.print(iterator.next());
                    first = !first;
                }
                else
                    System.out.print(" " + iterator.next());
            }

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

    private static void tarjan(int u, int father) {

        dfn[u] = low[u] = ++ counter;
        int children = 0;       //计算u的儿子节点个数
        List<Edge> edges = graph.getVertex(u).neighbours;
        for (int i = 0 ; i < edges.size();i++)
        {
            int v = edges.get(i).target.index;
            if (v == father) continue;

            if (dfn[v] == 0)
            {
                children++;
                tarjan(v,u);
                low[u] = Math.min(low[u],low[v]);

                //判断是否割点，点可能进入多次，所以用set方便
                if ((father == u && children > 1) || (father!=u && low[v] >= dfn[u]))
                {
                    set.add(u);
                    judge = true;
                }

                //判断是否割边(桥)
                if (low[v] > dfn[u])
                    ans.add(new Edge(new Vertex(Math.min(v,u)),new Vertex(Math.max(v,u))));

            }else   //不需判断是否在栈中
                low[u] = Math.min(low[u],dfn[v]);



        }

    }
}
