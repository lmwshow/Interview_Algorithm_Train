package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Auther: minGW
 * @Date: 2018/6/28 09:02
 * @Description: 最短路径
 * Dijkstra 邻接表 + 优先队列
 *
 * 这是是无向图,Dijkstra求单源最短路径
 * 正因为是单源，所以顶点内保存的最短路都是和这个源的距离
 */
public class 最短路径一 {

    static int n,m,s,t;

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

        //计算Dijkstra
        calculate(graph.getVertices().get(s));

        System.out.println((int)graph.getVertices().get(t).minDistance);
    }

    private static void calculate(Vertex source) {

        // Algo:
        // 1. Take the unvisited node with minimum weight.
        // 2. Visit all its neighbours.
        // 3. Update the distances for all the neighbours (In the Priority Queue).
        // Repeat the process till all the connected nodes are visited.

        source.minDistance = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(source);

        while (!queue.isEmpty())
        {
            Vertex u = queue.poll();

            for (Edge neighbour : u.neighbours)
            {
                Double newDist = u.minDistance + neighbour.weight;

                if (neighbour.target.minDistance > newDist)
                {
                    // Remove the node from the queue to update the distance value.
                    // 如果存在就remove,不存在返回false，优先队列中存的是刚更新的最短路径，如果队列为空，说明都更新完了
                    queue.remove(neighbour.target);
                    neighbour.target.minDistance = newDist;

                    //Reenter the node with new distance.
                    queue.add(neighbour.target);
                }
            }
        }
    }
}
