package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: minGW
 * @Date: 2018/6/20 09:08
 * @Description:
 */
public class 拓扑排序一 {

    static int count = 0;
    static Queue<Vertex> queue = new LinkedList<>();

    static class Vertex {
        public final int index;
        public ArrayList<Edge> neighbours;
        public int deg;

        public Vertex(int index) {
            this.index = index;
            neighbours = new ArrayList<Edge>();
        }

    }


    static class Edge{
        public final Vertex source;
        public final Vertex target;
        public Edge(Vertex source, Vertex target){
            this.source = source;
            this.target = target;
        }
    }



    static class Graph {
        private Vertex[] vertices;
        public Graph(int numberVertices){
            vertices = new Vertex[numberVertices+1];
            for(int i=1;i<=numberVertices;i++){
                vertices[i] = new Vertex(i);
            }
        }

        public void addEdge(int src, int dest){
            Vertex s = vertices[src];
            Vertex d = vertices[dest];
            Edge new_edge = new Edge(s,d);
            s.neighbours.add(new_edge);
            d.deg ++;
        }

        public void removeVertex(int index)
        {
            Vertex v = vertices[index];
            for (Edge edge : v.neighbours)
            {
                Vertex dest = edge.target;
                dest.deg--;
                if (dest.deg == 0)
                    queue.add(dest);
            }
            count++;

        }
        public Vertex[] getVertices() {
            return vertices;
        }

        public Vertex getVertex(int vert){
            return vertices[vert];
        }
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        while ( T -- > 0)
        {
            String[] parts = in.readLine().split(" ");
            int N = Integer.parseInt(parts[0]);
            int M = Integer.parseInt(parts[1]);

            Graph graph = new Graph(N);
            for (int i = 1 ; i <= M ; i++) {
                parts = in.readLine().split(" ");
                graph.addEdge(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
            }

            Vertex[] vertices = graph.getVertices();
            for (int i = 1; i < vertices.length ; i++)
                if (vertices[i].deg == 0)
                    queue.add(vertices[i]);

            while (!queue.isEmpty())
            {
                Vertex tmp = queue.poll();
                graph.removeVertex(tmp.index);
            }

            if (count == N)
                System.out.println("Correct");
            else
                System.out.println("Wrong");

            count = 0;

        }
    }
}
