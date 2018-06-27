package newcoder6_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/14 20:10
 * @Description: 60%
 *
 * 从数据规模可以看到，我们一共有10万颗星星以及最多10万次查询，如果我们每次查询都把给出的范围内遍历一遍的话肯定会超时。
 * 那么，我们就需要换一种方法。
 * 因为我们只需要得到一个矩形范围内的星星的数量，我们就可以先跑一遍整个数据范围，找到这个点的左上方向一共有多少颗星星，并把它标记出来。
 * 那么，我们要得到的矩形范围内的星星数量就变为了这个矩形
 * 右下角的点的值减去这个矩形左下角左边那个点的值再减去这个矩形右上角上面那个点的值再加上这个矩形左上角的左上边那个点的值（可以想象一下容斥定理）。
 * 那么，我们只需要遍历一次1000*1000的地图就行了，每个查询可以O（1）来获取。
 */
public class 牛牛数星星_某矩阵区域内的星星数量 {

    static int maxN = 1005;

    static int[][] map = new int[maxN][maxN];
    static int[][] num = new int[maxN][maxN];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String[] parts = new String[2];
        for (int i = 0 ; i < n ; i++)
        {
            parts = in.readLine().split(" ");
            map[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])]++;
        }

        //预处理矩阵num
        for (int i = 1 ; i < maxN ; i++)
            for (int j = 1 ; j < maxN ; j++)
            {
                num[i][j] = num[i-1][j] + num[i][j-1] + map[i][j] - num[i-1][j-1];
            }

        int m = Integer.parseInt(in.readLine());
        parts = new String[4];

        for (int i = 0 ; i< m ; i++)
        {
            parts = in.readLine().split(" ");
            int x1 = Integer.parseInt(parts[0]);
            int y1 = Integer.parseInt(parts[1]);
            int x2 = Integer.parseInt(parts[2]);
            int y2 = Integer.parseInt(parts[3]);
            System.out.println(num[x2][y2] - num[x1-1][y2] - num[x2][y1-1] + num[x1-1][y1-1]);

        }
    }


}
