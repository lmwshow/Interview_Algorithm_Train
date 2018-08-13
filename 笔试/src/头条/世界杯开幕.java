package 头条;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/8/12 10:07
 * @Description:
 */
public class 世界杯开幕 {

    static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};

    static int count = 0;
    static int max = 0;
    static int cursum = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = in.readLine().split(",");

        int m = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);

        int[][] map = new int[m][n];


        for (int i = 0 ; i < m ; i++)
        {
            parts = in.readLine().split(",");
            for (int j = 0 ; j < n ; j++)
                map[i][j] = Integer.parseInt(parts[j]);
        }

        boolean[][] visit = new boolean[m][n];

        for (int i = 0 ; i < m ; i++)
            for (int j = 0 ; j < n ; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = true;
                    cursum = 1;
                    dfs(map, visit, i, j);
                    max = Math.max(cursum,max);
                    count++;
                }
            }

            System.out.println(count + "," + max);


    }

    private static void dfs(int[][] map, boolean[][] visit, int x, int y) {


        for (int i = 0 ; i < dir.length ; i++)
        {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];

            if (nextx >= 0 && nextx < map.length && nexty >= 0 && nexty < map[0].length && map[nextx][nexty]==1 &&  !visit[nextx][nexty])
            {
                cursum++;
                visit[nextx][nexty] = true;
                dfs(map,visit,nextx,nexty);
            }
        }

    }
}
