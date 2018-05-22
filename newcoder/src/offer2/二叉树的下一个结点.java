package offer2;

import offer2.util.TreeLinkNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/22 08:11
 * @Description: https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class 二叉树的下一个结点 {

    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {

        if (pNode == null)
            return pNode;

        TreeLinkNode ans = pNode;

        if (pNode.right != null)            //判断是否存在右子树，如果存在，下一个节点就是，右子树最左边的节点
        {
            ans = pNode.right;
            while (ans.left!=null)
                ans = ans.left;
        }else {                             //如果不存在右子树，找父节点
                                            //如果当前节点是父节点的左子树，下一节点就是该父节点. 如果是父节点的右子树，继续向上搜索，直到子树为父节点的左子树
            while (ans.next != null && ans == ans.next.right)
                ans = ans.next;

            ans = ans == null ? null : ans.next;

        }

        return ans;
    }

    public static void main(String[] args){

        TreeLinkNode head = new TreeLinkNode(1);
        head.left = new TreeLinkNode(2);
        head.left.next = head;
        head.right = new TreeLinkNode(3);
        head.right.next = head;
        head.left.left = new TreeLinkNode(4);
        head.left.right = new TreeLinkNode(5);
        head.left.left.next = head.left;
        head.left.right.next = head.left;
        head.right.left = new TreeLinkNode(6);
        head.right.right = new TreeLinkNode(7);
        head.right.left.next = head.right;
        head.right.right.next = head.right;

        System.out.println(GetNext(head.right.right));
    }
}
