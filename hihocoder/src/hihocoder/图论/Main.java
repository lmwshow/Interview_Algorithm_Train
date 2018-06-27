package hihocoder.图论;

import java.util.*;

public class Main{
    static List<Edge>[] edges;
    static Map<Edge, Integer> edgeIndex;
    static int time = 0, numComponent;
    static int[] dfn, low, uf;
    static Stack<Integer> stack;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        edges = new List[n];
        for (int i = 0; i < n; ++i) {
            edges[i] = new ArrayList<>();
        }
        int m = in.nextInt();
        numComponent = m;
        edgeIndex = new HashMap<>();
        for (int i = 1; i <= m; ++i) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            Edge e = new Edge(v);
            edges[u].add(e);
            edgeIndex.put(e, i);
            e = new Edge(u);
            edges[v].add(e);
            edgeIndex.put(e, i);
        }
        dfn = new int[n];
        low = new int[n];
        uf = new int[m + 1];
        for (int i = 1; i <= m; ++i) {
            uf[i] = i;
        }
        stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            if (dfn[i] == 0) {
                dfs(i, -1);
            }
        }
//        System.out.println(Arrays.toString(low));
        System.out.println(numComponent);
        for (int i = 1; i < m; ++i) {
            System.out.print(find(i) + " ");
        }
        System.out.println(find(m));
    }

    static void dfs(int n, int p) {
        int numChildren = 0;
        dfn[n] = low[n] = ++time;
        for (Edge e : edges[n]) {
            if (dfn[e.to] == 0) {
                int eidx = edgeIndex.get(e);
                stack.push(eidx);
//                System.out.println(stack);
                ++numChildren;
                dfs(e.to, n);
                low[n] = Math.min(low[n], low[e.to]);
                if (low[e.to] >= dfn[n]) {
                    int i;
                    while ((i = stack.pop()) != eidx) {
                        union(i, eidx);
                        --numComponent;
                    }
//                    System.out.println(stack);
                }
            } else if (e.to != p && dfn[e.to] <= dfn[n]) {
                int eidx = edgeIndex.get(e);
                stack.push(eidx);
//                System.out.println(stack);
                low[n] = Math.min(low[n], dfn[e.to]);
            }
        }
    }

    static void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi < pj) {
            uf[pj] = pi;
        } else {
            uf[pi] = pj;
        }
    }

    static int find(int i) {
        if (uf[i] == i) {
            return i;
        }
        uf[i] = find(uf[i]);
        return uf[i];
    }
}

class Edge {
    int to;
    Edge(int to) {
        this.to = to;
    }
}