package leetgroup;

import java.util.Stack;

/**
 * Created by Gracecoder on 2017/6/24.
 *
 *
 */
public class recover_binary_search_tree {

    //二叉排序树中序下来一个递增的数列n1,n2,n3......nn，交换两个后，n1,n2,..ns...nt..nn; ns会比前部分大，至少比后一个大，nt至少比前一个小，至少比后一个小
    //整个序列会出现两个谷底，第一个是第一个谷底前的峰值，第二个则是第二个谷底；如果只出现一个，说明两个交换节点是相连的，一个是峰值，一个是谷值
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;

        TreeNode node1=null,node2=null,k= null;         //记录node1的下一个节点，以免两个交换点相连
        TreeNode pre=new TreeNode(Integer.MIN_VALUE),tmp=root,cur=root;

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || tmp != null)
        {
            while (tmp!=null)
            {
                stack.push(tmp);
                tmp = tmp.left;
            }

            if (!stack.isEmpty())
            {
                cur = stack.pop();
                if (cur.val < pre.val)
                {
                    if (node1 == null)
                    {
                        node1 = pre;                    //第一个出错点是在pre,峰值出错,cur小于pre 说明 pre出错
                        k = cur;
                    }
                    else
                        node2 = cur;                    //第二个出错点在cur，谷值出错
                }

                pre = cur;
                tmp = cur.right;
            }
        }
        if (node1 == null)
            return;

        if (node2 == null)
            node2 = k;                                //如果到最后node2为null，说明交换点相连

        int swap = node2.val;
        node2.val = node1.val;
        node1.val = swap;

        return;

    }

}
