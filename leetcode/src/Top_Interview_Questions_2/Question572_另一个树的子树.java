package Top_Interview_Questions_2;

import Top_Interview_Questions_2.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/3 07:54
 * @Description: https://leetcode-cn.com/problemset/all/?search=572
 */
public class Question572_另一个树的子树 {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null) {
            if (t == null)
                return true;
            else
                return false;
        }


        return isSubtreeCore(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    private boolean isSubtreeCore(TreeNode s, TreeNode t) {

        if (s == null && t == null)
            return true;

        if (s == null || t == null || s.val != t.val)
            return false;

        return isSubtreeCore(s.left, t.left) && isSubtreeCore(s.right, t.right);


    }
}
