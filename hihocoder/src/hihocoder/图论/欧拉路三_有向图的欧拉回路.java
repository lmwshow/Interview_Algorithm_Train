package hihocoder.图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @Auther: minGW
 * @Date: 2018/6/21 11:17
 * @Description: http://hihocoder.com/problemset/problem/1182
 *
 *
 * 有向图，其存在欧拉路的条件是，至多有两个点的入度不等于出度，且这两个点满足：其中一个点入度比出度多1，另一个点出度比入度多1。
 * 若所有点的入度都等于出度，则一定存在欧拉回路。这可以通过和无向图欧拉路同样的方法进行构造证明。
 *
 * 而我们构造的图，是使用边来表示数字，由构造方法可以知道对于任意一个点，其入度一定为2，出度一定为2。所以它必定存在欧拉回路。
 *
 * fleury算法 实质上是一个DFS
 */
public class 欧拉路三_有向图的欧拉回路 {

    static int Max = 1 << 15;
    static int n,m,cnt=0;
    static int[] ans = new int[Max];
    static int[] list = new int[Max];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());

        m = (1 << n) -1;
        dfs(0);

        for (int i = 1; i < n; i++)         //从0开始
            System.out.print(0);
        
        for (int i = cnt-1;i>n-2;i--)
            System.out.print(ans[i]);
        
        System.out.println();

    }

    private static void dfs(int v) {

        int x = (v << 1) & m;           //左移一位
        if (list[x] == 0)               //末位加0
        {
            list[x] = 1;
            dfs(x);
            ans[cnt++] = 0;
        }
        if (list[x+1] == 0)             //末位加1
        {
            list[x+1] = 1;
            dfs(x+1);
            ans[cnt++] = 1;
        }

    }


}
