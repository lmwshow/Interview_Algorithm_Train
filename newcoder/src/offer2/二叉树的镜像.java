package offer2;

import offer2.util.TreeNode;

import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/5/11 08:12
 * @Description: https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
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
