package again;

import offer.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/7/27 10:24
 * @Description
 *
 * 1. 可以在遍历每个节点的时候，调用TreeDepth得到左右子树，然后进行判断，但是这样需要重复计算子问题
 * 2. 使用后序遍历，遍历每个节点的时候，其左右子树已经遍历完成，即可判断是否为平衡树
 */
public class 平衡二叉树 {

    public static boolean ans = true;
    public boolean IsBalanced_Solution(TreeNode root) {

        ans = true;

        if (root == null)
            return ans;

        postTraversal(root);

        return ans;
    }

    private int postTraversal(TreeNode root) {

        if (!ans)
            return 0;

        if (root == null)
            return 0;

        int left = postTraversal(root.left);
        int right = postTraversal(root.right);

        int diff = left - right;
        if (diff <= 1 && diff >= -1)
            ans = true;
        else
            ans = false;

        return Math.max(left,right)+1;
    }
}
