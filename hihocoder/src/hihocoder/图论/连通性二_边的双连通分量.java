package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: minGW
 * @Date: 2018/6/25 09:51
 * @Description:
 *
 * 直观的做法自然先用上周的算法求出所有桥，去掉所有桥之后再做DFS求出每一个连通子图。
 * 我们这周要介绍一种更"抽象"的算法，
 * 通过在Tarjan算法当中巧妙地用一个栈来统计出每一个组内的节点，其代码如下
 */
public class 连通性二_边的双连通分量 {

    static int maxN = 20005;
    static int[] dfn = new int[maxN];
    static int[] low = new int[maxN];
    static int[] visit = new int[maxN];
    static int[] parent = new int[maxN];
    static int[] belong = new int[maxN];
    static int n,m,top,ans=1,counter = 0;
    static Graph graph;
    static int[] stack = new int[maxN];

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

        tarjan(1);
        
        System.out.println(ans);
        
        System.out.print(belong[1]);
        for (int i = 2 ; i <= n ; i++)
            System.out.print(" " + belong[i]);
        
        System.out.println();
    }

    private static void tarjan(int u) {

        //记录dfs遍历次序
        dfn[u] = low[u] = ++ counter;
        //记录节点u的子树数
        int children = 0;

        List<Edge> edges = graph.getVertex(u).neighbours;
        visit[u] = 1;

        //将u加入栈
        stack[++top] = u;

        for (int i = 0 ; i < edges.size() ; i++)
        {
            int v = edges.get(i).target.index;

            //节点未访问，则(u,v)为树边
            if (visit[v] == 0)
            {
                children ++;
                parent[v] = u;
                tarjan(v);

                low[u] = Math.min(low[u],low[v]);

                //是割边，桥
                if (low[v] > dfn[u])
                    ans++;
            }
            else if (v != parent[u])
                low[u] = Math.min(low[u],dfn[v]);
        }


        if (low[u] == dfn[u])
        {
            // 因为low[u] == dfn[u]，对(parent[u],u)来说有dfn[u] > dfn[ parent[u] ]，因此low[u] > dfn[ parent[u] ]
            // 所以(parent[u],u)一定是一个桥，那么此时栈内在u之前入栈的点和u被该桥分割开
            // 则u和之后入栈的节点属于同一个组
            //将从u到栈顶所有的元素标记为一个组，并弹出这些元素。

            int tmp = top;
            int cur = 0,min = maxN;
            do {
                cur = stack[top--];
                min = Math.min(min,cur);
            }while (cur != u);
            
            for (int i = top + 1; i <= tmp ; i++)
                belong[stack[i]] = min;        
        }


    }
}
