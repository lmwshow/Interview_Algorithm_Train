package Top_Interview_Questions_2.树;

import Top_Interview_Questions_2.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question102_二叉树的层次遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> curlevel = new ArrayList<>();
        queue.add(root);
        int cursize = 0;
        TreeNode curNode = null;

        while (!queue.isEmpty())
        {
            cursize = queue.size();

            for (int i = 0 ; i < cursize ; i++)
            {
                curNode = queue.poll();
                curlevel.add(curNode.val);
                if (curNode.left!=null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
            }

            ans.add(new ArrayList<>(curlevel));
            curlevel.clear();
        }


        return ans;

    }

}
