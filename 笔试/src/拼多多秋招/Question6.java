package 拼多多秋招;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/8/30 20:04
 * @Description:
 */
public class Question6 {


    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");

        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);

        char[][] map = new char[n][m];

        for (int i = 0 ; i < n ; i++)
            map[i] = in.readLine().toCharArray();


        for (int i = 0 ; i < m ; i++)
        {
            int base = n;
            int row = n -1;
            while (row >= 0)
            {
                if (map[row][i] == '.')
                    row--;
                else if (map[row][i] == 'x')
                {
                    base = row;
                    row --;
                }else
                {
                    map[row][i] = '.';
                    row --;
                    if (base != n) {
                        map[--base][i] = 'o';
                    }
                }
            }
        }


        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
}
