package 网易3_27;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//求解重叠矩阵最多的地方，矩阵的个数
//注意求解的是重叠矩阵最多的地方，而不是求与某个矩阵重叠的最大个数
//关键点：重叠矩阵最多的地方，肯定包含某个点，被其他矩阵所包含，所以关键是遍历顶点，求出包含顶点最多的矩阵个数

public class 矩阵重叠 {

    static final int maxn = 50 + 5;

    static long[] x1 = new long[maxn];
    static long[] y1 = new long[maxn];
    static long[] x2 = new long[maxn];
    static long[] y2 = new long[maxn];
    static Set<Long> xx = new HashSet<>();       //表示点集
    static Set<Long> yy = new HashSet<>();

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            x1[i] = in.nextLong();
            xx.add(x1[i]);
        }
        for (int i = 0; i < n; i++) {
            y1[i] = in.nextLong();
            yy.add(y1[i]);
        }
        for (int i = 0; i < n; i++) {
            x2[i] = in.nextLong();
            xx.add(x2[i]);
        }
        for (int i = 0; i < n; i++) {
            y2[i] = in.nextLong();
            yy.add(y2[i]);
        }

        int ans = 0;
        int count = 0;
        //遍历每个点，实际上通过这样的组合，多了很多无效点，但是这些点不会包含在任何矩阵中
        for (long x : xx)
            for (long y : yy) {
                count = 0;
                for (int i = 0; i < n; i++) {
                    //由于不考虑边界，这里判断的时候模拟取一个角为[ 另一个角为) 即可。
                    if ((x >= x1[i] && y >= y1[i]) && (x < x2[i] && y < y2[i]))
                        count++;
                }
                ans = Math.max(ans, count);

            }

        System.out.println(ans);


    }
}
