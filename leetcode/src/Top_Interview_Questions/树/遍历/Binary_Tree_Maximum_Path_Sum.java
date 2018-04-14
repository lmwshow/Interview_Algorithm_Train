package Top_Interview_Questions.树.遍历;

/**
 * Created by Gracecoder on 2017/10/12.
 *
 * 二叉树中最长的路径
 *
 * 路径是可以从任意一个点开始，经过它的父节点，到任何一个节点结束, 节点数至少为一个。
 * 后序遍历，每次访问的时候，计算以当前节点为最高父节点的最大长度，如果左右子节点都存在 ，且value大于0（小于0，会使路径减少），那么都加上，否则就不加。
 *
 * 同时比较当前最长长度 和 max的大小， 更新结果max
 *
 * 然后将当前节点的value设置为从左子树上来 和 从右子树上来 两条路径的较大值，即每个节点表达的含义为以该节点为其中一个子节点时的最大值
 */
public class Binary_Tree_Maximum_Path_Sum {

    //不能使用静态变量，因为leetcode会用来跑很多例子，max不会重置，除非赋值 在函数中
    private static int max;

    static class Res{
        int max = Integer.MIN_VALUE;

    }

    public static int maxPathSum(TreeNode root) {

        if (root == null)
            return 0;

//        max = Integer.MIN_VALUE;
        Res res = new Res();

        postorder(root,res);

        return res.max;

    }

    private static void postorder(TreeNode root,Res res) {

        if (root!=null)
        {
            postorder(root.left,res);
            postorder(root.right,res);

            int tmpmax = 0;
            int left = 0;
            int right = 0;
            if (root.left != null && root.left.val > 0)
                left = root.left.val;
            if (root.right != null && root.right.val > 0)
                right = root.right.val;

            tmpmax = root.val + left + right;                             //以该节点为最高点的最大长度

            res.max = tmpmax > res.max? tmpmax: res.max;

            root.val += left>right?left:right;                            //更新节点为 以该节点为其中一个子节点时，该节点的最大值

        }

    }


    public static void main(String[] args){


        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(8);
//        root.left.left.left = new TreeNode(1);
//        root.right.right = new TreeNode(3);

        System.out.println(maxPathSum(root));

    }
}
