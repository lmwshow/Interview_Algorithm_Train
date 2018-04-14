package second0323;


import java.awt.*;
import java.util.*;

/**
 * Created by thd on 2017/8/1
 */
public class Main4 {
    static class point {
        int x;
        int y;

        Set<Character> key = new HashSet<>();
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int startX = 0,startY =0,endX=0,endY=0;
        char [][] arr = new char[m][n];
        String[] row = new String[m];
        for (int i = 0; i < m; i++) {
            row[i] = sc.nextLine();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = row[i].charAt(j);
                if (arr[i][j] == '2'){
                    startX = i;
                    startY = j;
                }
                if (arr[i][j] == '3'){
                    endX = i;
                    endY = j;
                }
            }
        }
//        Set<Character> key = new HashSet<>();            不能作为局部变量，每个点都需要有私有的set，不然明明没有经过那个路径，这个点就可能莫名有了钥匙
        Queue<point> queue = new LinkedList<>();
        point start = new point(startX,startY);
        int res = 0;
        queue.add(start);
        int[][] next = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int k = 0 ; k < size ;k++) {
                point cur = queue.poll();
                if (cur.x == endX && cur.y == endY) {
                    System.out.println(res);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int tx = cur.x + next[i][0];
                    int ty = cur.y + next[i][1];
                    if (tx >= 0 && tx < m && ty >= 0 && ty < n && arr[tx][ty] != '0') {
                        if (arr[tx][ty] < 'A' || arr[tx][ty] > 'Z') {
                            point nn = new point(tx, ty);
                            nn.key = new HashSet<>(cur.key);
                            if (arr[tx][ty] >= 'a' && arr[tx][ty] <= 'z') nn.key.add(Character.toUpperCase(arr[tx][ty]));
                            queue.add(nn);

                        } else {
                            if (cur.key.contains(arr[tx][ty])) {
                                point nn = new point(tx, ty);
                                nn.key = new HashSet<>(cur.key);
                                queue.add(nn);
                            }
                        }
                    }
                }
            }


            res++;

        }
    }

}

