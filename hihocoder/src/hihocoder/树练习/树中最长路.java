package hihocoder.树练习;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Vector;

/**
 * @Auther: minGW
 * @Date: 2018/6/5 09:22
 * @Description:
 *
 * 求树中任意两点之间的最长路径，这其实和二叉树中的最大路径和差不多
 * 只不过这里是一颗普通的树，思路还是一样，任何路径都会有折点
 * 深搜DFS，类似后序
 */
public class 树中最长路 {

    static int max = 0;
    //这里有链表数组来表示树
    public static void main(String[] args){

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());

            List<Integer>[] edges = new ArrayList[n+1];

            for (int i = 0 ; i <= n ; i++)
                edges[i] = new ArrayList<>();

            //n个点,n-1条边
            for (int i = 0 ; i < n - 1 ; i++)
            {
                String[] parts = in.readLine().split(" ");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                edges[x].add(y);
                edges[y].add(x);
            }


            boolean[] visited = new boolean[n+1];
            dfs(1,edges,visited);
            System.out.println(max);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //需要在每个节点的所有子节点中，找出最大的两条路径，更新max，同时用最大的路径更新父节点的val(返回最大深度+1)
    private static int dfs(int cur, List<Integer>[] edges, boolean[] visited) {

        int maxLarge = 0;
        int secondLarge = 0;
        visited[cur] = true;

        for (int next : edges[cur])
        {
            if (!visited[next])
            {
                int childHeight = dfs(next,edges,visited)+1;
                if (childHeight > maxLarge)
                {
                    secondLarge = maxLarge;
                    maxLarge = childHeight;
                }else if (childHeight > secondLarge)
                    secondLarge = childHeight;
            }
        }


        max = Math.max(maxLarge+secondLarge,max);
        return maxLarge;

    }
}
