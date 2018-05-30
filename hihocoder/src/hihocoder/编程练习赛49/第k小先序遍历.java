package hihocoder.编程练习赛49;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 第k小先序遍历 {

    static int N = 31;
    static int anslist[] = new int[N];
    static int ind = 0;
    static int orilist[] = new int[N];
    static long cnt[] = new long[N];    //cnt[n]代表节点数为n个的二叉树的形态有多少种，通过dp求得，cnt[0]=1; cnt[n] = sum(cnt[j-1]*cnt[n-j]) j=[1,n]



    public static void main(String[] args){

        for (int i = 0 ; i < N ; i++)
        {
            getCnt(i);//先求出cnt注意要从小到大求，后面要用到前面的
        }

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong(); //k可能超过int范围
        for (int i = 0 ; i < n ; i++)
            orilist[i] = in.nextInt();

        ind = 0;
        findKthRoot(k,0,n-1);
        for(int i=0;i<n;++i) System.out.println(anslist[i]);

    }

    /*
     * 利用先序遍历找出所有情况中第大的根
     * 然后再遍历左子树和右子树
     */

    private static void findKthRoot(long k, int l, int r) {

        if (l > r)
            return;     //空树
        if (l == r)     //就剩一个节点了
        {
            anslist[ind++] = orilist[l];
            return;
        }

        //对当前的数字进行从小到大遍历，然后算一下以某数字为根的树还有多少种可能，这里用的是堆
        PriorityQueue<int []> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for (int i = l ; i <= r ; i++)
            queue.add(new int[]{i,orilist[i]});


        int p = -1; //记录root下标

        while (!queue.isEmpty())
        {
            int[] f = queue.poll();

            int i = f[0];

            long t = cnt[i-l]*cnt[r-i];     //计算以当前下标的数字为根有多少种情况

            if (t >= k)                     //当前已经快要满足种数，退出
            {
                p = i;
                break;
            }else
                k-=t;   //从中减到
        }


        //确定根的值
        anslist[ind++] = orilist[p];

        //左子树每变化1，整颗树变化cnt[r-p]; 左子树要先第k/cnt[r-p]+(k%cnt[r-p]>0?1:0)
        findKthRoot(k/cnt[r-p]+(k%cnt[r-p]>0?1:0),l,p-1);

        //右子树选第 (k-1)%cnt[r-p]+1 , 先k-1是为了 避免k==cnt[r-p]时，实际上是要早第k个，结果变成第0个
        findKthRoot((k-1)%cnt[r-p]+1, p+1, r);

    }

    private static void getCnt(int n) {

        if (n == 0)
        {
            cnt[n] = 1;
            return;
        }

        cnt[n] = 0;
        for (int i = 1 ; i <= n ;i++)
            cnt[n]+=cnt[i-1]*cnt[n-i];

    }
}
