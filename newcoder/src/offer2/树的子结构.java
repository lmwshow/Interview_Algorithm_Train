package offer2;

import offer2.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/11 08:04
 * @Description:
 */
public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null)
            return false;

        return HasSubtreeCore(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    private boolean HasSubtreeCore(TreeNode root1, TreeNode root2) {

        if (root2 == null)
            return true;
        if (root1 == null || root1.val != root2.val)
            return false;

        return HasSubtreeCore(root1.left, root2.left) &&
                HasSubtreeCore(root1.right, root2.right);

    }
}
