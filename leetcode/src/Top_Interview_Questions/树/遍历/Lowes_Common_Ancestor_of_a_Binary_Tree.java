package Top_Interview_Questions.树.遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gracecoder on 2017/10/21.
 *
 * 找两个节点的最近公共祖先，根据中序遍历之后得到的序列，同一祖先的两个节点必然在祖先节点的两侧，除非一个节点是另一个节点的祖先。
 * 只需递归搜索每个节点即可，最后面得到的结果即是最近的祖先
 *
 *
 * 更好的解法 4行，不用遍历树. It's recursive and expands the meaning of the function.
 */
public class Lowes_Common_Ancestor_of_a_Binary_Tree {

    private static TreeNode common_ancestor;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> list = new ArrayList<>();
        if (root == null)
            return null;

        if (p == q)
            return p;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;

        while (tmp!=null || !stack.isEmpty())
        {
            while (tmp!=null)
            {
                stack.push(tmp);
                tmp = tmp.left;
            }

            if (!stack.isEmpty())
            {
                tmp = stack.pop();
                list.add(tmp);
                tmp = tmp.right;
            }

        }

        int pindex = list.indexOf(p);
        int qindex = list.indexOf(q);
        if (pindex > qindex)                    //后面默认了pindex 小于qindex
        {
            int swap = pindex;
            pindex = qindex;
            qindex = swap;
        }

        search(list,root,pindex,qindex);

        return common_ancestor;
    }

    private static void search(List<TreeNode> list, TreeNode root, int pindex, int qindex) {

        if (root == null)
            return;
        int mid = list.indexOf(root);

        if (pindex <= mid && qindex >= mid)
            common_ancestor = root;
        else {
            search(list, root.left, pindex, qindex);
            search(list, root.right, pindex, qindex);
        }


    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
//        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(8);
//        root.left.right.left = new TreeNode(7);
//        root.left.right.right = new TreeNode(4);
        
        System.out.println(lowestCommonAncestor(root,root,root.left).val);

        

    }
}
