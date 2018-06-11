package newcoder6_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/8 19:04
 * @Description:
 */
public class 走格子 {

    static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int[][] map =new int[n+1][n+1];

        map[n][1] = 1;
        int indexx = n;
        int indexy = 1;
        int[] cur = dir[0];
        int next = 0;
        for (int i = 0 ; i < m ; i++)
        {
            while ((indexx+cur[0] < 1 || indexx+cur[0] > n) ||(indexy+cur[1] < 1 || indexy+cur[1] > n)|| map[indexx+cur[0]][indexy+cur[1]] == 1)
                cur = dir[(++next)%4];

            map[indexx+cur[0]][indexy+cur[1]] = 1;
            indexx += cur[0];
            indexy += cur[1];

        }

        int ansx = indexy;
        int ansy = n-(indexx - 1);

        System.out.println(ansx+" "+ansy);

    }
}
