package Top_Interview_Questions.树.遍历;


import org.omg.CORBA.TRANSACTION_MODE;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Gracecoder on 2017/10/11.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Flatten_Binary_Tree_to_Linked_List {

    public static void flatten1(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        if (root == null)
            return;

        preorder(root,list);

        TreeNode res = new TreeNode(0);
        TreeNode tmp = res;
        for (TreeNode cur : list)
        {
            tmp.right = cur;
            tmp = tmp.right;
        }
        res = res.right;
        root.left = null;
        root.right = res.right;
    }


    /*先序递归*/
    private static void preorder(TreeNode root, List<TreeNode> list) {

        if (root == null)
            return;

        list.add(new TreeNode(root.val));
        preorder(root.left,list);
        preorder(root.right,list);

    }

    /*先序非递归*/
    public static void flatten(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;

        while (tmp != null || !stack.isEmpty())
        {
            while (tmp != null)
            {
                list.add(tmp.val);
                stack.push(tmp);
                tmp = tmp.left;
            }

            if (!stack.isEmpty())
            {
                tmp = stack.pop();
                tmp = tmp.right;
            }
        }

        TreeNode res = new TreeNode(0);
        tmp = res;
        for (Integer cur : list)
        {
            tmp.right = new TreeNode(cur);
            tmp = tmp.right;
        }

        res = res.right;
        root.left = null;
        root.right = res.right;

    }


    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);

        flatten(root);
    }
}
