package Top_Interview_Questions_2.树;

import Top_Interview_Questions_2.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/8/10 09:18
 * @Description:
 */
public class Question100_相同二叉树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null || (p.val != q.val))
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
