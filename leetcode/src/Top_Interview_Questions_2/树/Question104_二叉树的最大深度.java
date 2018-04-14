package Top_Interview_Questions_2.树;

import Top_Interview_Questions_2.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question104_二叉树的最大深度 {

    public int maxDepth(TreeNode root) {

        int ans = 0;
        if (root == null)
            return ans;



        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cursize = 0;
        TreeNode curNode = null;

        while (!queue.isEmpty())
        {
            cursize = queue.size();

            for (int i = 0 ; i < cursize ; i++)
            {
                curNode = queue.poll();
                if (curNode.left!=null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
            }

            ans++;
        }


        return ans;


    }

}
