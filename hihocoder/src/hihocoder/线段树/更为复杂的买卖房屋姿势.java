package hihocoder.线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Auther: minGW
 * @Date: 2018/6/15 09:13
 * @Description: http://hihocoder.com/problemset/problem/1080
 *
 * 线段树 区间修改，包含了set add 操作
 * 需要深刻理解延迟操作，子节点只有到查询到的时候才会将之前所有的延迟更新掉
 */
public class 更为复杂的买卖房屋姿势 {

    static int maxN = 100005;
    static int[] nums = new int[maxN];
    static Node[] tree = new Node[maxN<<2];
    static int[] sum = new int[maxN<<2];
    static int[] add = new int[maxN<<2];
    static int[] set = new int[maxN<<2];

    static class Node{
        int left;
        int right;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = in.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);

        parts = in.readLine().split(" ");
        for (int i = 0 ; i < parts.length; i++)
            nums[i+1] = Integer.parseInt(parts[i]);

        //初始化节点
        for (int i = 0 ; i < tree.length ; i++)
            tree[i] = new Node();

        //建立线段树,根节点不能从0开始，因为这样孩子节点都会是0
        segBuild(1,1,N+1);

        int opt = 0 ,left = 0,right = 0,value = 0;
        for (int i = 0 ; i < M ; i++)
        {
            parts = in.readLine().split(" ");
            opt = Integer.parseInt(parts[0]);
            left = Integer.parseInt(parts[1]);
            right = Integer.parseInt(parts[2]);
            value = Integer.parseInt(parts[3]);

            update(1,opt,left+1,right+1,value);
            System.out.println(sum[1]);         //从父节点开始查找
        }

    }



    //采用延迟更新，因为这里是离散区间，区间分为[l,m]和[m+1,r]
    private static void update(int index, int opt, int l, int r, int value) {

        if (tree[index].left == l && tree[index].right == r) {
            //自发增减
            if (opt == 0) {
                add[index] += value;          //表示孩子节点存在延迟
                sum[index] += (r - l + 1) * value;
            } else if (opt == 1)             //政府控制
            {
                set[index] = value;
                add[index] = 0;
                sum[index] = (r - l + 1) * value;

            }

            return;             //延迟的关键
        }

        //如果是叶子节点，那么上面的操作已经更新完毕
        if (tree[index].left == tree[index].right)
            return;
        //此时说明需要更新下层，那么PushDown 延迟更新下层
        pushDown(opt,index,tree[index].right - tree[index].left + 1);

        int mid = ((tree[index].right - tree[index].left) >> 1) + tree[index].left;

        if ( r <= mid)
            update(index<<1,opt,l,r,value);
        else if ( l > mid)
            update(index<<1|1,opt,l,r,value);

        else
        {
            update(index<<1,opt,l,mid,value);
            update(index<<1|1,opt,mid+1,r,value);
        }

        pushUp(index);                              //子节点的lazy更新后，需要更新父节点


    }

    //延迟操作包括了之前延迟的set和add，所以两者都需要进行更新
    private static void pushDown(int opt, int index, int len) {

        //延迟更新时， 先更新set标记 ，再更新add标记
        if (set[index] > 0)
        {
            set[index << 1] = set[index];
            set[index << 1 | 1] = set[index];
            add[index << 1] = 0;                        //子节点的增减标记清0
            add[index << 1 | 1] = 0;

            sum[index << 1] = set[index]*(len-(len>>1));
            sum[index << 1 | 1] = set[index]*(len >> 1);
            set[index] = 0;
        }
        if (add[index]!=0)       //add 可能会负数，因为会有下降 所以条件为不等于0, 也可以都执行
        {
            add[index << 1] += add[index];              //更新其左孩子代表区间的lazy更新值
            add[index << 1 | 1] += add[index];          //更新其右孩子代表区间的lazy更新值

            sum[index << 1] += add[index]*(len - (len >> 1));       //更新当前父节点的sum
            sum[index << 1 | 1] += add[index]*(len >> 1);
            add[index] = 0;                             //更新后需要还原
        }


    }

    private static void segBuild(int index, int l, int r) {

        tree[index].left = l;
        tree[index].right = r;

        if (l == r)
        {
            sum[index] = nums[l];
            return;
        }

        int mid = ((r - l) >> 1) + l;
        segBuild(index << 1,l,mid);
        segBuild(index <<1 | 1,mid+1,r);

        pushUp(index);
    }

    //向上更新
    private static void pushUp(int index) {

        sum[index] = sum[index<<1] + sum[index<<1|1];

    }


}
