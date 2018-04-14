package newcoder2018_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main (String[] args) throws Exception{


        Scanner in  = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int map[][] = new int[n+1][n+1];
        int ans[] = new int[2];

        for (int i = 1 ; i <= n ; i++)
            for (int j = 1 ; j <= n ; j++)
                map[i][j] = Integer.MAX_VALUE;

        int x = 0;
        int y = 0;
        int d = 0;
        for (int i = 0 ; i < m ; i++) {
            x = in.nextInt();
            y = in.nextInt();
            d = in.nextInt();

            map[x][y] = Math.min(map[x][y],d);
            map[y][x] = Math.min(map[x][y],d);
        }

        int visit[] = new int[n+1];
        int curPos = 1;
        visit[curPos] = 1;

        int dis[] = new int[n+1];

        for (int i = 1 ; i <= n ; i++)                          //dis[i] 表示节点i 到最小生成树的最短距离
            dis[i] = map[1][i];

        ans[1] = 1;

        while (ans[1] < n)
            curPos = getNext(map,visit,curPos,ans,dis);

        System.out.println(ans[0]);




    }

    private static int getNext(int[][] map, int[] visit, int curPos,int[] ans,int[] dis) {


        int len = Integer.MAX_VALUE;
        int next = curPos;
        for (int i = 1 ; i < map[curPos].length ;i++)
        {
            if (visit[i]==0 && dis[i]<len)
            {
                next = i;
                len = dis[i];
            }
        }       

        ans[0] = Math.max(len,ans[0]);
        visit[next] = 1;
        ans[1]++;


        //将一个点加入生成树中时，需要更新其他未访问节点到生成树的距离，如果其他点到该点的距离小于，其之前和生成树的距离，那就要更新
        for (int i = 1 ; i < map[curPos].length ; i++)
        {
            if (visit[i]==0 && dis[i] > map[i][next])
                dis[i] = map[i][next];
        }
        return next;


    }





}
