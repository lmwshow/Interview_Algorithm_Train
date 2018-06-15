package newcoder6_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/14 20:10
 * @Description: 60%
 */
public class 牛牛数星星 {

    static int[][] map = new int[1005][1005];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String[] parts = new String[2];
        for (int i = 0 ; i < n ; i++)
        {
            parts = in.readLine().split(" ");
            map[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])]++;
        }

        int m = Integer.parseInt(in.readLine());
        parts = new String[4];

        for (int i = 0 ; i< m ; i++)
        {
            parts = in.readLine().split(" ");
            System.out.println(solve(parts));

        }
    }

    private static int solve(String[] parts) {

        int ans = 0;

        for (int i = Integer.parseInt(parts[0]) ; i <= Integer.parseInt(parts[2]); i++)
            for (int j = Integer.parseInt(parts[1]); j <= Integer.parseInt(parts[3]); j++)
                ans+=map[i][j];

        return ans;
    }
}
