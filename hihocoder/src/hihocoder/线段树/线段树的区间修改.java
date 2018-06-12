package hihocoder.线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/12 08:44
 * @Description: http://hihocoder.com/problemset/problem/1078
 *
 * 区间内涉及到更新的话，可以使用线段树
 *
 * 这里并不是RMQ问题，而是查询区间和
 * 单点更新 和 区间更新  如果用tree[index] 表示区间和的话，则更新操作最坏情况下可能会修改所有的节点 超时.
 * 所以tree[index]不表示 节点index的区间和，区间和我们用另外sum数组来记录，tree的每个节点只有当前用到的节点才表示区间和，其他存在lazy。
 *
 * http://www.cnblogs.com/ECJTUACM-873284962/p/6791203.html
 *
 * Lazy思想：lazy－tag思想，记录每一个线段树节点的变化值，当这部分线段的一致性被破坏我们就将这个变化值传递给子区间，大大增加了线段树的效率。
 *
 */
public class 线段树的区间修改 {

    static int maxN = 100005;
    static int[] nums = new int[maxN];      //保存信息
    static Node[] tree = new Node[maxN*3];  //保存线段树信息
    static int[] add = new int[maxN*3];       //记录当前节点的lazy变化值
    static int[] set = new int[maxN*3];       //记录当前节点的lazy更新值,这里NewP大于0
    static int[] sum = new int[maxN*3];

    static class Node{
        int left;
        int right;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] parts = in.readLine().split(" ");
        for (int i = 0 ; i < parts.length ; i++)
            nums[i+1] = Integer.parseInt(parts[i]);

        //初始化节点
        for (int i = 0 ; i < tree.length ; i++)
            tree[i] = new Node();

        segBuild(1,1,n);

        int q = Integer.parseInt(in.readLine());

        int opt = 0 , arg0 = 0 , arg1 = 0 , value = 0;
        while (q-- > 0)
        {
            parts = in.readLine().split(" ");
            opt = Integer.parseInt(parts[0]);
            arg0 = Integer.parseInt(parts[1]);
            arg1 = Integer.parseInt(parts[2]);

            if (opt == 0)
                System.out.println(query(1,arg0,arg1));         //从父节点开始查找
            else {
                value = Integer.parseInt(parts[3]);
                update(1, arg0, arg1,value);
            }

        }

    }

    //区间更新
    private static void update(int index, int l, int r,int value) {

        //if(tree[rt].l == l && r == tree[rt].r) 这里就是用到Lazy思想的关键时刻
        //首先更新该节点的sum[rt]值，然后更新该节点具体每个数值应该加多少即add[rt]的值
        // 注意此时整个函数就运行完了，直接return，而不是还继续向子节点继续更新，这里就是Lazy思想，暂时不更新子节点的值。
        if (tree[index].left == l && tree[index].right == r)
        {
//            add[index] += value;
//            sum[index] += value*(r-l+1);
            set[index] = value;
            sum[index] = value*(r-l+1);
            return;
        }
        if (tree[index].left == tree[index].right) return;
        PushDown(index,tree[index].right - tree[index].left + 1);

        int mid = ((tree[index].right - tree[index].left)>>1)+tree[index].left;

        if ( r <= mid)
            update(index<<1,l,r,value);
        else if ( l > mid)
            update(index<<1|1,l,r,value);

        else
        {
            update(index<<1,l,mid,value);
            update(index<<1|1,mid+1,r,value);
        }

        PushUp(index);                              //子节点的lazy更新后，需要更新父节点

    }

    private static void PushUp(int index) {

        sum[index] = sum[index << 1] + sum[index << 1|1];

    }

    //在某部分update操作的时候需要用到那部分没有更新的节点的值的时候,即add > 0
    private static void PushDown(int index, int len) {

//        if (add[index] > 0)
//        {
//            add[index << 1] += add[index];              //更新其左孩子代表区间的lazy更新值
//            add[index << 1 | 1] += add[index];          //更新其右孩子代表区间的lazy更新值
//
//            sum[index << 1] += add[index]*(len - (len >> 1));       //更新当前父节点的sum
//            sum[index << 1 | 1] += add[index]*(len >> 1);
//            add[index] = 0;                             //更新后需要还原
//        }

        if (set[index] > 0)
        {
            set[index << 1] = set[index];
            set[index << 1 | 1] = set[index];

            sum[index << 1] = set[index]*(len - (len >> 1));
            sum[index << 1 | 1] = set[index]*(len >> 1);
            set[index] = 0;
        }

    }

    /*
 线段树的查找分为以下几种情况：
             1.l,r与某个节点区间刚好一致
             2.l,r属于节点左孩子
             3.l,r属于节点右孩子
             4.l,r横跨左右孩子，则节点取其中小的一个
 */
    private static int query(int index, int l, int r) {

         if (tree[index].left == l && tree[index].right == r)
             return sum[index];

         PushDown(index,tree[index].right - tree[index].left +1);

         int mid = ((tree[index].right - tree[index].left)>>1)+tree[index].left;


         if (r <= mid)
             return query(index << 1,l,r);
         if (l > mid)
             return query(index << 1|1,l,r);

         return query(index << 1,l,mid)+query(index << 1|1,mid+1,r);

    }


    //每个节点表示区间和
    private static void segBuild(int index, int l, int r) {

        tree[index].left = l;
        tree[index].right = r;

        if (l == r)
        {
            sum[index] = nums[l];
            return;
        }

        segBuild(index << 1,l,(l+r)>>1);
        segBuild(index << 1|1,((l+r)>>1)+1,r);

        PushUp(index);
    }
}
