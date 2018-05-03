package Top_Interview_Questions_2;

import Top_Interview_Questions_2.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/3 08:48
 * @Description: https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class Question617_合并二叉树 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null)
            return null;
        if (t1 == null || t2 == null)
            return t1 == null ? t2 : t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);

        return t1;
    }
}
