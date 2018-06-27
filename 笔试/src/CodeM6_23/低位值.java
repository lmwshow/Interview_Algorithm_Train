package CodeM6_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/23 14:50
 * @Description:
 */
public class 低位值 {

    //字符串的长度是 20005 不是大小
    static int maxN = 20005;
    static int[][] map = new int[maxN][maxN];
    static int n;
    static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        String str = in.readLine();
        n = Integer.valueOf(str, 2);

        for (int i = 0; i <= n; i++)
            for (int j = i + 1; j <= n; j++) {
                if (j - lowbit(j) >= i)
                    map[i][j] = map[i][j - lowbit(j)] + 1;
                else
                    map[i][j] = map[i][j - 1] + 1;


                ans = Math.max(ans, map[i][j]);
            }

        System.out.println(ans);

    }

    private static int lowbit(int x) {

        String str = Integer.toBinaryString(x);
        int index = str.lastIndexOf("1");

        index = str.length() - index;

        return (int) Math.pow(2, index-1);
    }
}
