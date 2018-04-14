package offer;

import offer.util.TreeLinkNode;

import java.util.List;
import java.util.Stack;

/**
 * Created by Gracecoder on 2017/12/6.
 */
public class 题8_二叉树的下一个结点 {


    //先找到根节点，然后非递归中序遍历
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;

        TreeLinkNode root = pNode;
        while (root.next!=null)
            root = root.next;

        Stack<TreeLinkNode> stack = new Stack<>();
        TreeLinkNode pre = null;
        TreeLinkNode tmp = root;

        while (tmp!=null || !stack.isEmpty())
        {
            while (tmp!=null) {
                stack.push(tmp);
                tmp = tmp.left;
            }

            if (!stack.isEmpty()) {
                tmp = stack.pop();
                if (pre == pNode)
                    return tmp;
                else
                    pre = tmp;

                tmp = tmp.right;
            }

        }

        return null;
    }


    //可以不遍历整棵树，直接根据中旬遍历的性质求解

    public TreeLinkNode better_GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;

        if (pNode.right != null)        //右子树不为空的话，下一个节点就是右子树的最左下那个节点
        {
            pNode = pNode.right;
            while (pNode.left!=null)
                pNode = pNode.left;

            return pNode;
        }else {                         //右子树为空的话，如果当前节点是其父节点的左孩子，那么父节点就是下一节点，如果是其右孩子，就一直往父节点找，直到找到一个是其父节点左孩子的节点，返回父节点
            TreeLinkNode cur = pNode;
            TreeLinkNode parentNode = cur.next;
            while (parentNode!=null && parentNode.right==cur)
            {
                cur = parentNode;
                parentNode = cur.next;
            }
            return parentNode;
        }


    }

}
