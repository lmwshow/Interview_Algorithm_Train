package hihocoder.线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/6/13 09:15
 * @Description: http://hihocoder.com/problemset/problem/1079
 *
 * 题意: 在[0,L]的区间上，贴若干段区间段[a,b]，问最后能被看见的区间段(露出的长度大于0)有几个
 *      由于数据量太大，无法直接声明数组，在数组上进行覆盖操作。
 *
 * 离散化+线段树+Lazy
 *
 * 题解: https://blog.csdn.net/howardemily/article/details/54709797
 *
 * 对离散化简单的理解就是给定的数据量太大,而我们所求的问题与具体数值是多少并无太大关系,
 * 这时候我们就可以进行离散化.我们在进行区间离散的过程中,虽然区间的大小会发生改变,
 * 但是他们的相对关系并没有变化.在离散过程中,我们将最小值标为1，次小值标为2，以此类推、
 *
 * 线段树的节点是有2种不同的意义的:离散型和连续型
 * 1.叶子节点：在离散型中，叶子节点是[i, i]，而连续性中是[i, i + 1]；2.分解区间：在离散型中，一段区间是分解成为[l, m], [m + 1, r]，而在连续型中，是分解成为[l, m], [m, r]；3.其他所有类似的判定问题。
 *
 *
 * 思路:将给定的区间用map进行离散化,然后每一张海报就相当于一次修改,然后用懒惰标记进行标记一下,对应的区间标记一下是否有海报,对应的是哪一张海报,然后查询一下即可；
 *
 */
public class 离散化 {

    static int maxN = 100005;

    static int[] lazy = new int[maxN * 3];
    static int[] ans = new int[maxN * 3];
    static Map<Integer, Integer> map = new HashMap<>();
    static int count = 0;
    static int[] x = new int[maxN * 3];
    static int[] y = new int[maxN * 3];
    static int[] nums = new int[maxN * 3];

    public static void main(String[] args) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int index = 0;
        for (int i = 1; i <= n; i++) {
            parts = in.readLine().split(" ");
            x[i] = Integer.parseInt(parts[0]);
            y[i] = Integer.parseInt(parts[1]);
            nums[index++] = x[i];
            nums[index++] = y[i];

        }

        //排序有效部分
        Arrays.sort(nums,0,index);
        //使用map进行区间的离散化映射,从1开始

        index = 0;
        for (int i = 0; i < 2 * n; i++)
            if (!map.containsKey(nums[i]))
                map.put(nums[i], ++index);

        for (int i = 1; i <= n; i++)
            update(map.get(x[i]), map.get(y[i]), 1, index, i, 1);

        query(1,index,1,index,1);

        System.out.println(count);

    }

    private static void query(int mapL, int mapR, int l, int r, int pos) {

        //查询该区间是否有海报,是哪张海报,并标记,因为是线段树,海报的长度可能会分成几部分. 如果当前部分已被覆盖，则不加count
        if (lazy[pos]>0 && ans[lazy[pos]]!=1)
        {
            ans[lazy[pos]] = 1;
            count++;
            return;
        }

        if (l+1 == r)
            return;

        int mid = ((r - l) >> 1) + l;

        pushDown(pos);

        if(mapL<=mid) query(mapL,mapR,l,mid,pos<<1);

        if(mapR>mid) query(mapL,mapR,mid,r,pos<<1|1);

        return;

    }

    //采用延迟更新，因为这里是连续区间，区间分为[l,m]和[m,r]
    private static void update(int mapL, int mapR, int l, int r, int val, int pos) {


        if (mapL <= l && mapR >= r) {
            lazy[pos] = val;
            return;
        }

        if (l + 1 == r)
            return;

        int mid = ((r - l) >> 1) + l;

        pushDown(pos);

        if(mapL<=mid) update(mapL,mapR,l,mid,val,pos<<1);

        if(mid<mapR) update(mapL,mapR,mid,r,val,pos<<1|1);

    }

    private static void pushDown(int pos) {

        if (lazy[pos] > 0)
        {
            lazy[pos << 1] = lazy[pos];
            lazy[pos << 1 | 1] = lazy[pos];
            lazy[pos] = 0;
        }

        return;

    }
}
