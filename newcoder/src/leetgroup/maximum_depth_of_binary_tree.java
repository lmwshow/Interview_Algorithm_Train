package leetgroup;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gracecoder on 2017/6/28.
 */
public class maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0 ;

        Queue<TreeNode> queue = new LinkedList<>();

        int maxdepth = 0;
        int levelNum;
        queue.offer(root);

        while (!queue.isEmpty())
        {
            levelNum = queue.size();

            for (int i = 0 ; i < levelNum ; i ++)
            {
                TreeNode cur = queue.poll();
                if (cur.left!=null)
                    queue.offer(cur.left);
                if (cur.right!= null)
                    queue.offer(cur.right);

            }

            maxdepth ++;
        }

        return maxdepth;

    }
}
