package 拼多多秋招;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/7/22 19:28
 * @Description:
 */
public class Question2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        String[] rank = new String[m];

        for (int i = 0 ; i < m ; i++)
            rank[i] = in.readLine();

        String cur;
        int lt = 0, bt = 0;
        boolean isKing = true;

        for (int i = 0 ; i < n ; i ++)
        {
            lt = 0;
            bt =0;
            isKing = true;
            for (int j = 0 ; j < n ; j++)
            {
                if (i == j)
                    continue;

                for (int k = 0 ; k < m ; k ++)
                {
                    cur = rank[k];
                    if (cur.charAt(i) < cur.charAt(j))
                        bt ++;

                    if (cur.charAt(i) > cur.charAt(j))
                        lt ++;
                }

                if (bt <= lt) {
                    isKing = false;
                    break;
                }
                else
                {
                    lt = 0;
                    bt =0;
                }
            }


            if (isKing)
            {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);

    }
}
