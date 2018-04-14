package offer;

import offer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class 题32_从上往下打印二叉树 {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curSize = 0;
        TreeNode curNode = null;

        while (!queue.isEmpty())
        {
            curSize = queue.size();
            for (int i = 0 ; i < curSize ; i++)
            {
                curNode = queue.poll();
                list.add(curNode.val);
                if (curNode.left!=null)
                    queue.offer(curNode.left);
                if (curNode.right!=null)
                    queue.offer(curNode.right);
            }
        }

        return list;

    }

    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>();

        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);

        list = PrintFromTopToBottom(root1);
        for (int x : list)
            System.out.println(x);


    }
}
