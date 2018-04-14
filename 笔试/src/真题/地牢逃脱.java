package 真题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
   地牢由 '.' 和障碍物'X' 构成
   出口可能在任意一个'.'的位置， 给定一个出发点，和一些步长，求最坏情况下需要的步数，达不到 输出-1

   大意其实就是，从一个点出发，按一定步长遍历整个地牢，如果能访问到所有'.' 那就输出到达最后一个'.'的步数
   如果无法遍历所有'.' 那最坏情况就是无法到达
 */
public class 地牢逃脱 {


    static char map[][];
    static int step[][];
    static int ans = Integer.MIN_VALUE;
    static boolean visit[][];
    static int count = 0;

    static class Point
    {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        map = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0 ; i < n ;i++) {

            String str = in.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '.')
                    count++;
            }
        }

        Point startPoint = new Point(in.nextInt(),in.nextInt());

        int k = in.nextInt();

        step = new int[k][2];

        for (int i = 0 ; i < k ; i++)
        {
            step[i][0] = in.nextInt();
            step[i][1] = in.nextInt();
        }

        Queue<Point> queue = new LinkedList<>();
        visit[startPoint.x][startPoint.y] = true;
        count --;
        queue.add(startPoint);
        int deep = 0;
        //广搜遍历map
        while (!queue.isEmpty())
        {
            int size = queue.size();
            deep++;
            for (int i = 0 ;i <size ;i++)
            {
                Point cur = queue.poll();
                for (int j = 0 ; j < k ; j++)
                {
                    if (isOverRange(cur.x+step[j][0],cur.y+step[j][1])||!isVaild(cur.x,cur.y,step[j][0],step[j][1]) || visit[cur.x+step[j][0]][cur.y+step[j][1]])
                        continue;
                    else
                    {
                        visit[cur.x+step[j][0]][cur.y+step[j][1]] = true;
                        count -- ;
                        queue.add(new Point(cur.x+step[j][0],cur.y+step[j][1]));
                    }
                }
            }
        }


        if (count > 0)
            System.out.println(-1);
        else
            System.out.println(deep-1);


    
    }

    private static boolean isOverRange(int x, int y) {
        if (x >= map.length || y >= map[0].length || x < 0 || y< 0)
            return true;
        return false;
    }



    //判断到达点是否是障碍
    private static boolean isVaild(int x, int y, int xmv, int ymv) {


        if (map[x+xmv][y+ymv]=='X')
            return false;

        return true;

    }
}
