package pingduoduo0801;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Gracecoder on 2017/8/1.
 */
public class 冒险家 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        char[][] map = new char[m][n];

        String[] row = new String[m];
        for (int i = 0 ; i < m; i++)
            row[i] = in.nextLine();

        int startx,starty;

        for (int i = 0 ; i < m ; i ++)
            for (int j = 0 ; j < n ; j++)
            {
                map[i][j] = row[i].charAt(j);
                if (map[i][j] == '2')
                {
                    startx = i;
                    starty = j;
                }
            }

        List<Character> key = new ArrayList<>();

//        bfs(map,startx,starty,key);


    }
}
