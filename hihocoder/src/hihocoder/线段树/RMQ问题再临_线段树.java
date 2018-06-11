package hihocoder.线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: minGW
 * @Date: 2018/6/11 09:52
 * @Description: http://hihocoder.com/problemset/problem/1077
 *
 * 使用线段树
 *
 * 其实就是递归将数组区间平均分成两份，也就是左孩子和右孩子，每个节点都保存了孩子节点的最值，所以能求出区间最值。
 * 但是不能进行删除元素和插入元素，只能解决区间查询。由于是完全二叉树，所以左孩子下标肯定是父节点的2倍，右孩子就是左孩子下标+1.。
 */
public class RMQ问题再临_线段树 {

    static int maxN = 1000005;

    static int[] nums = new int[maxN];  //保存信息

    static Node[] tree = new Node[maxN*3];  //保存线段树信息........长度设为maxN*2 还是不够，RE

    static class Node{
        int left;       //左区间
        int right;      //右区间
        int num;        //商品重量
    }


    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        String[] parts = in.readLine().split(" ");

        for (int i = 0 ; i < parts.length ; i++)
            nums[i + 1] = Integer.parseInt(parts[i]);

        //初始化节点
        for (int i = 0 ; i < tree.length ; i++)
            tree[i] = new Node();

        segBuild(1,1,n);

        int q = Integer.parseInt(in.readLine());
        int opt = 0,arg0 = 0 ,arg1 = 0;

        while (q-- > 0)
        {
            parts = in.readLine().split(" ");
            opt = Integer.parseInt(parts[0]);
            arg0 = Integer.parseInt(parts[1]);
            arg1 = Integer.parseInt(parts[2]);

            if (opt == 0)
                System.out.println(query(1,arg0,arg1));
            else
                update(1,arg0,arg1);
        }
    }

    private static void update(int index, int targetIndex, int value) {         //从祖先节点开始找修改节点的信息

        if (tree[index].left == tree[index].right)                              //找到该节点(就是left = right = pi)，修改信息
        {
            tree[index].num = value;
            return;
        }

        int mid = (tree[index].left + tree[index].right) >> 1;

        if (targetIndex <= mid)                                                 //该节点属于父亲左孩子
            update(index*2,targetIndex,value);
        else
            update(index*2+1,targetIndex,value);                          //该节点属于父亲右孩子

        tree[index].num = Math.min(tree[index*2].num,tree[index*2+1].num);      //更新父亲保存重量的最小值，去孩子中较小的一个


    }

    /*
     线段树的查找分为以下几种情况：
                 1.l,r与某个节点区间刚好一致
                 2.l,r属于节点左孩子
                 3.l,r属于节点右孩子
                 4.l,r横跨左右孩子，则节点取其中小的一个
     */
    private static int query(int index, int l, int r) {

        int curmin = 1000000;
        if (tree[index].left == l && tree[index].right == r)
            return tree[index].num;

        int mid = (tree[index].left + tree[index].right) >> 1;

        if (r <= mid)         //属于左区间
            return query(index*2,l,r);
        if (l > mid)                        //属于右区间
            return query(index*2 + 1,l,r);

        return Math.min(query(2*index,l,mid),query(2*index+1,mid+1,r));         //横跨左右孩子

    }

    private static void segBuild(int index, int l, int r) {     //建立线段树

        tree[index].left = l;                           //该点保留哪个区间
        tree[index].right = r;

        if (l == r)                                     //左右区间相等，说明该点是叶子节点，叶子节点保存商品重量
        {
            tree[index].num = nums[l];
            return;
        }

        segBuild(2*index,l,(l+r)>>1);           //递归建立左孩子
        segBuild(2*index+1,((l+r)>>1)+1,r);     //递归建立右孩子

        tree[index].num = Math.min(tree[2*index].num,tree[2*index+1].num);      //该父节点保存左右孩子重量小的一个


    }
}
