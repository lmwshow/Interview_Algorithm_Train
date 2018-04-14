package Top_Interview_Questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gracecoder on 2017/11/17.
 *
 * 计算连通图的个数 不知道有什么更好的写法。
 *
 * DFS
 */
public class Friend_Circles {

    int sum = 0;

    public int findCircleNum(int[][] M) {

        if (M == null || M.length ==0)
            return 0;

        int n = M.length;

        int[] visit = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0 ; i < n ; i ++)
        {
            if (visit[i] == 0) {
                sum ++;
                queue.add(i);

                while (!queue.isEmpty())
                {
                    int k = queue.poll();
                    if (visit[k]==0)
                    {
                        for (int m = 0 ; m < n; m++)
                        {
                            if (M[k][m] == 1) {
                                queue.add(m);
                            }
                        }

                        visit[k] = 1;
                    }
                }
            }


        }

        return sum;


    }



    //典型dfs
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int dfs_findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
