package newcoder6_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: minGW
 * @Date: 2018/6/14 20:23
 * @Description: 60%
 */
public class 牛牛游玩记 {

//    static char[][] map = new char[1005][1005];
//    static boolean[][] visit = new boolean[1005][1005];

    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int min = Integer.MAX_VALUE;

    static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        char[][] map = new char[n][n];
        boolean[][] visit = new boolean[n][n];

        for (int i = 0; i < n; i++)
            map[i] = in.readLine().toCharArray();


        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (map[i][j] == '*') {
                    queue.add(new Point(i, j));
                    visit[i][j] = true;
                    break;
                }

        int ans = 0;
        boolean flag =false;

        while (!queue.isEmpty()) {

            int cursize = queue.size();

            for (int i = 0 ; i < cursize ; i++)
            {
                Point tmp = queue.poll();
                if (map[tmp.x][tmp.y] == '@')
                {
                    System.out.println(ans);
                    return;
                }

                for (int j = 0 ; j < dir.length; j++)
                {
                    int nextx = tmp.x + dir[j][0];
                    int nexty = tmp.y + dir[j][1];

                    if ((nextx >= 0 && nextx < n) && (nexty >= 0 && nexty < n) && !visit[nextx][nexty] && map[nextx][nexty] != '#') {
                        visit[nextx][nexty] = true;
                        queue.add(new Point(nextx,nexty));
                        if (map[nextx][nexty] == '@')
                            flag = true;
                    }


                }


            }

            ans++;
            if (flag)
            {
                System.out.println(ans);
                return;
            }
        }

//        for (int i = 0; i < n; i++)
//            for (int j = 0; j < n; j++) {
//                if (map[i][j] == '@') {
//                    visit[i][j] = true;
//                    dfs(i, j, 0, n);
//                    visit[i][j] = false;
//                }
//            }


//        System.out.println(min);


    }

//    private static void dfs(int x, int y, int step, int len) {
//
//        if (map[x][y] == '*') {
//            min = Math.min(min, step);
//            return;
//        }
//
//        for (int i = 0; i < dir.length; i++) {
//            int nextx = x + dir[i][0];
//            int nexty = y + dir[i][1];
//
//            if ((nextx >= 0 && nextx < len) && (nexty >= 0 && nexty < len) && !visit[nextx][nexty] && map[nextx][nexty] != '#') {
//                visit[nextx][nexty] = true;
//                dfs(nextx, nexty, step + 1, len);
//                visit[nextx][nexty] = false;
//            }
//        }
//    }
}
