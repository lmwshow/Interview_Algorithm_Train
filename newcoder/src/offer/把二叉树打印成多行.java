package offer;

import offer.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 把二叉树打印成多行 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (pRoot == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(pRoot);

        ArrayList<Integer> curLevel = new ArrayList<>();

        TreeNode tmp = null;

        int size = 0;
        while (!queue.isEmpty())
        {
            size = queue.size();

            for (int i = 0; i < size ; i++)
            {
                tmp = queue.poll();

                if (tmp.left!=null)
                    queue.offer(tmp.left);
                if (tmp.right!=null)
                    queue.offer(tmp.right);
                curLevel.add(tmp.val);
            }

            res.add(new ArrayList<>(curLevel));
            curLevel.clear();

        }

        return res;

    }
}
