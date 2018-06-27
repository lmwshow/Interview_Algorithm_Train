package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/6/27 09:20 https://blog.csdn.net/u014634338/article/details/47025165?locationNum=4&fps=1
 * @Description: 对于一个无向图的子图，当删除其中任意一个点后，不改变图内点的连通性，这样的子图叫做点的双连通子图。而当子图的边数达到最大时，叫做点的双连通分量。
 *
 * 对于桥的两种情况，它分割个区域数刚好就等于割点数+1；
 * 而连通分量内的割点同样也是，每存在一个割点，点的双连通分量就增加一个。
 */
public class 连通性四_点的双连通分量 {

    static int maxN = 20100 ;
    static int maxM = 200100  ;
    static int[] dfn = new int[maxN];
    static int[] low = new int[maxN];
    static int[] parent = new int[maxN];
    static boolean[] visit = new boolean[maxN];
    static int[] belong = new int[maxN];
    static int[] Min = new int[maxM];
    static int n, m, counter,ans;
    static Graph graph;
    static Stack<Integer> stack = new Stack<>();


    static class Vertex {
        public final int index;
        public ArrayList<Edge> neighbours;
        public int deg;

        public Vertex(int index) {
            this.index = index;
            neighbours = new ArrayList<Edge>();
        }

    }


    //需要标记边
    static class Edge {
        public final Vertex source;
        public final Vertex target;
        public final int id;

        public Edge(int id,Vertex source, Vertex target) {
            this.id = id;
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

        public void addEdge(int id ,int src, int dest) {
            Vertex s = vertices[src];
            Vertex d = vertices[dest];
            Edge new_edge = new Edge(id,s,d);
            Edge re_edge = new Edge(id,d,s);

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
        for (int i = 1; i <= m; i++)
        {
            parts = in.readLine().split(" ");
            graph.addEdge(i,Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
        }


        tarjan(1);//如果已经确定是连通图，就这样写
        /*
        否则要这样
        for(int i = 1; i <= n; i++) {
            if(dfn[i] == 0) tarjan(1);
        }
        */


        int k = 0 , min = Integer.MAX_VALUE;
        ans++;
        while (!stack.isEmpty())
        {
            k = stack.pop();
            belong[k] = ans;
            k = Math.min(min,k);
        }
        Min[ans] = k;
        
        System.out.println(ans);
        
        for (int i = 1 ; i < m ; i++)
        {
            System.out.print(Min[belong[i]] + " ");
        }
        System.out.println(Min[belong[m]]);
        
        
    }

    private static void tarjan(int u) {

        //记录dfs遍历次序
        dfn[u] = low[u] = ++counter;

        //记录节点u的子树数
        int children = 0;

        visit[u] = true;

        List<Edge> edges = graph.getVertex(u).neighbours;

        for (int i = 0 ; i < edges.size() ; i++)
        {
            int v = edges.get(i).target.index;
            int id = edges.get(i).id;


            //已经标记过
            if (belong[id] != 0)
                continue;

            //未访问
            if (!visit[v])
            {
                children++;
                parent[v] = u;
                stack.push(id);
                tarjan(v);
                low[u] = Math.min(low[u],low[v]);


                //割点的充要条件
                if ((parent[u] == 0 && children > 1) || (parent[u]!=0 && low[v] >= dfn[u]))
                {
                    ans++;
                    int min = Integer.MAX_VALUE;
                    int k;

                    do {
                        k = stack.pop();
                        belong[k] = ans;         //该边所属分组
                        if (k < min)
                            min = k;
                    }while (k!=id);

                    
                    Min[ans] = min;     //该组最小连接编号   

                }

            }else if (v != parent[u])       //是回边
            {
                stack.push(id);
                low[u] = Math.min(low[u],dfn[v]);
            }
        }

    }

}
