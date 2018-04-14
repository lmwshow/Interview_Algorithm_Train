package offer;

import hihocoder.util.TreeNode;

import java.util.Stack;

public class 题54_二叉搜索树的第k个结点 {

    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null)
            return null;

        int cur = 0;

        Stack stack = new Stack<TreeNode>();
        TreeNode tmp = pRoot;

        while (tmp != null || !stack.isEmpty())
        {
            while (tmp!=null)
            {
                stack.push(tmp);
                tmp = tmp.left;
            }

            if (!stack.isEmpty())
            {
                tmp = (TreeNode) stack.pop();
                System.out.println(tmp.val);

                cur ++;
                if (cur == k)
                    return tmp;
                tmp = tmp.right;
            }
        }

        return null;
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        System.out.println(KthNode(root1,3).val);

    }
}
