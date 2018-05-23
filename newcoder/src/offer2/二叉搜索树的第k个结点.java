package offer2;
import offer2.util.TreeNode;

import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/5/23 08:17
 * @Description: https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=4&rp=4&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 求二叉搜索树的第k个节点，中序遍历 第k个
 */
public class 二叉搜索树的第k个结点 {

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = pRoot;

        while (!stack.isEmpty() || cur!=null)
        {
            while (cur!=null)
            {
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty())
            {
                k--;
                cur = stack.pop();
                if (k == 0)
                    return cur;

                cur = cur.right;
            }
        }

        return null;
    }
}
