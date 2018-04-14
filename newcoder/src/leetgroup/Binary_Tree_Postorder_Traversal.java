package leetgroup;

import java.util.*;

/**
 * Created by Gracecoder on 2017/6/19.
 *
 * 后序遍历的非递归难度比起，先序中序  难度大点
 */
public class Binary_Tree_Postorder_Traversal {



    /* 递归 */
    public static List<Integer> mypostorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        DFS(root,list);

        return list;
    }

    private static void DFS(TreeNode root,List list) {

        if (root.left != null)
            DFS(root.left,list);

        if (root.right != null)
            DFS(root.right,list);

        list.add(root.val);
        return;
    }


    /*非递归，利用栈模拟
    * 需要辅助标签，来表示当前节点是从左右哪边返回，即已遍历左子树或右子树，0表示从左子树返回*/

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();


        int[] tag = new int[100];

        TreeNode tmp = root;

        while (tmp != null || !stack.isEmpty())
        {
            while (tmp!=null)
            {
                stack.push(tmp);
                tag[stack.size()] = 0;
                tmp = tmp.left;
            }
            while (!stack.isEmpty()&&tag[stack.size()]==1)
            {
                list.add(stack.pop().val);                  //最后从右字数回来 ， 已经是后序了
            }

            if (!stack.isEmpty())
            {
                tag[stack.size()] = 1;
                tmp = stack.peek();
                tmp = tmp.right;
            }

        }


        return list;
    }


    /* 先序遍历 非递归*/
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;


        while (tmp!=null || !stack.isEmpty())
        {
            while (tmp!=null)
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

        return list;
    }


    /* 中序遍历 非递归*/
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

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
                list.add(tmp.val);
                tmp = tmp.right;
            }
        }

        return list;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> list = inorderTraversal(root);

        for (int i :
                list) {
            System.out.println(i);

        }

    }
}
