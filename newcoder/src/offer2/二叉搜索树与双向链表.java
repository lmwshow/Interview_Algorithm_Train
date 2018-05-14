package offer2;

import offer.util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/5/14 16:49
 * @Description https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class 二叉搜索树与双向链表 {

    public static TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null)
            return null;

        ArrayList<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;

        while (!stack.isEmpty() || cur!=null)
        {
            while (cur!=null)
            {
                stack.add(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty())
            {
                cur = stack.pop();
                list.add(cur);
                cur = cur.right;
            }
        }

        TreeNode pre = list.get(0);
        TreeNode ans = pre;

        for (int i = 1; i < list.size(); i++)
        {
            cur = list.get(i);
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }


        return ans;

    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(6);

        root1 = Convert(root1);
        System.out.println("");

    }
}