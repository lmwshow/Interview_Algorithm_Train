package offer2;

import offer2.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/18 07:43
 * @Description: https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 平衡二叉树 {

    static boolean ans;
    public boolean IsBalanced_Solution(TreeNode root) {

        ans = true;
        if (root == null)
            return ans;

        postTraversal(root);

        return ans;
    }

    private void postTraversal(TreeNode root) {

        if (!ans)
            return;

        if (root == null)
            return;

        postTraversal(root.left);
        postTraversal(root.right);

        int diff = Math.abs((root.left==null?0:root.left.val) - (root.right==null?0:root.right.val));
        if (diff > 1)
        {
            ans = false;
            return;
        }

        root.val = Math.max((root.left==null?0:root.left.val) , (root.right==null?0:root.right.val)) + 1;

    }
}
