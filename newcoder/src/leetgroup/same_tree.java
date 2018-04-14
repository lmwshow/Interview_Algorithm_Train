package leetgroup;

/**
 * Created by Gracecoder on 2017/6/25.
 */
public class same_tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;

        if (p == null || q == null || (p.val != q.val))
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
