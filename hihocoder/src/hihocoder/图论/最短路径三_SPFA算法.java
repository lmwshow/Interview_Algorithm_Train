package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: minGW
 * @Date: 2018/6/28 11:18
 * @Description: https://www.cnblogs.com/scau20110726/archive/2012/11/18/2776124.html
 *
 * SPFA算法的原理 其实是使用BFS  进行优化剪枝
 *
 * 针对于系数图， 点多，边少
 *
 */
public class 最短路径三_SPFA算法 {

    static int MAX = 100000005;
    static int MAXN = 100005;
    static int n,m,s,t;
    static boolean[] visit = new boolean[MAXN];
    static int[] counter = new int[MAXN];
    static int[] dist = new int[MAXN];


    static class Vertex implements Comparable<Vertex> {
        public final int id;
        public ArrayList<Edge> neighbours;
        public double minDistance = Double.POSITIVE_INFINITY;

        @Override
        public int compareTo(Vertex other) {
            return Double.compare(minDistance, other.minDistance);
        }

        public Vertex(int id) {
            this.id = id;
            neighbours = new ArrayList<>();
        }
    }

    static class Edge {
        public final Vertex target;
        public final double weight;

        public Edge(Vertex target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }


    static class Graph{
        private ArrayList<Vertex> vertices;

        public Graph(int numberVertices) {
            vertices = new ArrayList<>(numberVertices);

            for (int i = 0 ; i <= numberVertices ; i++) {
                vertices.add(new Vertex(i));
            }
        }

        public void addEdge(int src , int target , int weight){
            Vertex s = vertices.get(src);
            Vertex t = vertices.get(target);
            Edge new_edge = new Edge(t,weight);
            s.neighbours.add(new_edge);

            new_edge = new Edge(s,weight);
            t.neighbours.add(new_edge);
        }

        public ArrayList<Vertex> getVertices() {
            return vertices;
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = in.readLine().split(" ");

        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        s = Integer.parseInt(parts[2]);
        t = Integer.parseInt(parts[3]);

        Graph graph = new Graph(n);
        for (int i = 0 ; i < m ; i++)
        {
            parts = in.readLine().split(" ");
            graph.addEdge(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
        }

        for (int i = 0 ; i <= n ; i++)
            dist[i] = MAX;

        dist[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visit[s] = true;
        counter[s] = 1;
        //顶点入队vis要做标记，另外要统计顶点的入队次数
        int OK = 1;

        while (!queue.isEmpty())
        {
            //队头元素出队，并且消除标记
            int u = queue.poll();
            visit[u] = false;

            List<Edge> edges = graph.getVertices().get(u).neighbours;

            for (int i = 0 ; i < edges.size() ; i++)
            {
                int v = edges.get(i).target.id;

                if (dist[u] + edges.get(i).weight < dist[v])
                {
                    dist[v] =  dist[u] + (int)edges.get(i).weight;          //松弛

                    if (!visit[v])                      //顶点y不在队内
                    {
                        visit[v] = true;                //标记
                        counter[v]++;                   //统计次数
                        queue.add(v);
                        if (counter[v] > n) {           //超过入队次数上限，说明有负环
                            OK= 0;
                            return;
                        }
                    }

                }
            }

        }


        System.out.println(dist[t]);

    }


}
