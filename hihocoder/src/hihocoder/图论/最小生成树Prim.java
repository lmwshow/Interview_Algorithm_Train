package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/29 08:44
 * @Description http://hihocoder.com/problemset/problem/1097
 *
 * Prim 算法： 每次从未访问过的点中找距离生成树最短的一条边，用一个数组维护每个点到生成树的距离，加入生成树后，需要更新其他边
 *
 * Prim算法的复杂度只与点数有关
 * 所以求最小生成树的时候和边数无关，和顶点数有关，适合稠密网的最小生成树。
 */
public class 最小生成树Prim {

    static int n;
    static int maxN = 1005;
    static int[][] map = new int[maxN][maxN];
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        String[] parts;

        for (int i = 0 ; i < n ; i++ )
        {
            parts = in.readLine().split(" ");
            for (int j = 0; j < n ; j++)
                map[i][j] = Integer.parseInt(parts[j]);
        }

        int pos = 0,minimun;
        int min_tree = 0;

        //lowcost数组记录当前点距离生成树的最小权值，visited数组标记某点是否已访问

        int[] lowcost = new int[n];
        boolean[] visited = new boolean[n];

        //以第一个节点为起点，构成最小生成树
        visited[0] = true;
        for(int i = 0 ; i < n ;i++)
            lowcost[i] = map[0][i];


        //
        for(int i = 0 ; i < n ;i++)
        {
            int curMin = Integer.MAX_VALUE;
            for(int j = 0 ; j < n ; j++)
            {
                if(!visited[j] && lowcost[j] < curMin)
                {
                    pos = j;
                    curMin = lowcost[j];
                }
            }

            //如果curMin == Integer.MAX_VALUE，表示已经没有点可以再加入最小生成树
            if(curMin == Integer.MAX_VALUE)
                break;

            min_tree += curMin;
            //加入生成树，并更新其他点的距离
            visited[pos] = true;
            for(int j = 0 ; j < n ; j++)
            {
                if(!visited[j] && lowcost[j] > map[j][pos])
                    lowcost[j] = map[j][pos];
            }
        }


        System.out.println(min_tree);




    }

}
