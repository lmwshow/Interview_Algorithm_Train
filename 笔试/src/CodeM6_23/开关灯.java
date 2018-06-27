package CodeM6_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/23 14:02
 * @Description:
 */
public class 开关灯 {

    static int maxN = 240000000;

    static int[] map = new int[maxN];

    static int n,m,k;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");

        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        k = Integer.parseInt(parts[2]);

        for (int i = 0 ; i < k ;i ++)
        {
            parts = in.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int opt = Integer.parseInt(parts[2]);

        }


        System.out.println(map);
    }
}
