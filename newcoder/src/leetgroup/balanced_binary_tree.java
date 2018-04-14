package leetgroup;

/**
 * Created by Gracecoder on 2017/6/16.
 */
public class balanced_binary_tree {

    /* 题解 自顶向下，0(n^2)*/

    public boolean isBalanced2(TreeNode root) {

        if (root == null) return true;

        int left=depth(root.left);
        int right=depth(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int depth(TreeNode root)
    {
        if (root == null)
            return 0;

        return Math.max(depth(root.left),depth(root.right))+1;

    }





    /*----------------自低向上 O(n)------------------------------*/

    class Res {
        Boolean isBalanced = true;
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        Res res = new Res();
        DFS(root, res);

        return res.isBalanced;
    }

    private int DFS(TreeNode root, Res res) {

        int ldeep = 0, rdeep = 0;                               //表示每个节点的左子树深度和右子树深度

        if (res.isBalanced == false)
            return 0;

        if (root.left != null) {
            ldeep = DFS(root.left, res);
            ldeep += 1;
        }
        if (root.right != null) {
            rdeep = DFS(root.right, res);
            rdeep += 1;
        }


        if (ldeep-rdeep> 1|| rdeep - ldeep >1)
            res.isBalanced = false;

        return ldeep>rdeep?ldeep:rdeep;
    }
}
