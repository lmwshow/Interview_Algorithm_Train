package hihocoder.树练习;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Auther: minGW
 * @Date: 2018/6/6 08:48
 * @Description: http://hihocoder.com/problemset/problem/1055
 *
 * 给一棵带点权的树，现在要从根节点开始选出m个连通的节点，使总权值最大。
 *
 *
 * 不能使用优先队列做贪心，因为贪心只能保证当前步最优，不能保证全局最优。
 * 比如：4个节点选3个  value:2 3 4 5  edges:1-2,1-3,2-4    用贪心的话答案为9，而全局最优为10
 *
 *
 * 树形DP
 * 思路：
 * 给一棵带点权的树，现在要从根节点开始选出m个连通的节点，使总权值最大。
 * 状态转移方程为：dp[u][j]=max(dp[v1][k1]+dp[v2][k2]+...+dp[vx][kx])，v是u的子节点,并且需要保证m1+m2+...+mk+1=m
 * 和无限背包很像，可以不用单独的求解每一个f(t, m)而是针对于每一个t，同时求解它的f(t, 0..M)
 *
 * dp(u,m)=max(dp(u,m),dp(u,m-k)+dp(son,k))，其中0<=k<m。
 */
public class 刷油漆_树形DP {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        Set<Integer>[] edges = new HashSet[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new HashSet<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            edges[x].add(y);
            edges[y].add(x);
        }
        int[] result = solve(edges, data, 0, -1, m);
        System.out.println(result[m]);
    }

    private static int[] solve(Set<Integer>[] edges, int[] data, int current, int parent, int m) {
        int[] dp = new int[m + 1];
        dp[1] = data[current];
        for (int next : edges[current]) {
            if (parent != next) {
                int[] subDp = solve(edges, data, next, current, m);
                for (int i = m; i > 0; i--) {
                    for (int j = 1; j < i; j++) {
                        dp[i] = Math.max(dp[i], dp[i - j] + subDp[j]);
                    }
                }
            }
        }
        return dp;
    }


//    static class Node{
//        int index;
//        int value;
//
//        public Node(int index, int value) {
//            this.index = index;
//            this.value = value;
//        }
//    }
//    
//    public static void main(String[] args){
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int ans = 0;
//
//        try {
//            String[] parts = in.readLine().split(" ");
//            int n = Integer.parseInt(parts[0]);
//            int m = Integer.parseInt(parts[1]);
//
//            List<Integer>[] edges = new ArrayList[n+1];
//            for (int i = 0 ; i <= n ; i++)
//                edges[i] = new ArrayList<>();
//
//            parts = in.readLine().split(" ");
//
//            Node[] nodes = new Node[n + 1];
//            for (int i = 1 ; i <= n ; i++)
//                nodes[i] = new Node(i,Integer.parseInt(parts[i-1]));
//
//            for (int i = 0 ; i < n - 1;i++)
//            {
//                parts = in.readLine().split(" ");
//                int x = Integer.parseInt(parts[0]);
//                int y = Integer.parseInt(parts[1]);
//
//                edges[x].add(y);
//                edges[y].add(x);
//            }
//
//            boolean[] visit = new boolean[n + 1];
//
//
//            PriorityQueue<Node> priorityQueue = new PriorityQueue<>((x,y)->(y.value - x.value));
//            priorityQueue.add(nodes[1]);
//            for (int i = 0 ; i < m ; i++)
//            {
//                Node cur = priorityQueue.poll();
//                ans += cur.value;
//                visit[cur.index] = true;
//
//                for (int j = 0 ; j < edges[cur.index].size() ; j++)
//                    if (!visit[edges[cur.index].get(j)])
//                        priorityQueue.add(nodes[edges[cur.index].get(j)]);
//            }
//
//            System.out.println(ans);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
}
