package offer;

import hihocoder.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 题55_二叉树的深度 {

    public static int TreeDepth(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode tmp = root;

        queue.offer(tmp);

        int level = 0;
        int size = 0;

        TreeNode cur = null;

        while (!queue.isEmpty())
        {
            size = queue.size();

            for (int i = 0 ; i < size ; i++)
            {
                cur = queue.poll();
                if (cur.left!=null)
                    queue.offer(cur.left);
                if (cur.right!=null)
                    queue.offer(cur.right);
            }

            level ++;
        }

        return level;
    }


    public static void main(String[] args){
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        System.out.println(TreeDepth(root1));

    }
}
