package Top_Interview_Questions_2;

import Top_Interview_Questions_2.util.TreeNode;

import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/4/28 10:28
 * @Description: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
 */
public class Question538_把二叉搜索树转换为累加树 {

    //变形中序遍历
    public TreeNode convertBST(TreeNode root) {

        if (root == null)
            return root;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        int pre = 0;
        while (cur!=null || !stack.isEmpty())
        {
            while (cur!=null) {
                stack.push(cur);
                cur = cur.right;
            }

            if (!stack.isEmpty())
            {
                cur = stack.pop();
                cur.val += pre;
                pre = cur.val;
                cur = cur.left;
            }

        }


        return root;


    }
}
