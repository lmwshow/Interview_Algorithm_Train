package Top_Interview_Questions_2.again;

import Top_Interview_Questions_2.util.TreeNode;

public class Question101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        boolean ans = isSymmetricCore(root,root);
        return ans;
    }

    private boolean isSymmetricCore(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        return left.val == right.val && isSymmetricCore(left.left,right.right) && isSymmetricCore(left.right,right.left);

    }
}
