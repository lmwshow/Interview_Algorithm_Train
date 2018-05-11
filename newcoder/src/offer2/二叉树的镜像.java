package offer2;

import offer2.util.TreeNode;

import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/5/11 08:12
 * @Description:
 */
public class 二叉树的镜像 {

    public void Mirror(TreeNode root) {

        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty()||cur!=null)
        {
            while (cur!=null)
            {
                swap(cur);
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty())
            {
                cur = stack.pop();
                cur = cur.right;
            }
        }

        return;
    }

    private void swap(TreeNode cur) {
        TreeNode tmp = cur.left;
        cur.left = cur.right;
        cur.right = tmp;
    }
}
