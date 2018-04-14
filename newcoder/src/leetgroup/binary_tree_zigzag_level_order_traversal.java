package leetgroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gracecoder on 2017/6/28.
 */
public class binary_tree_zigzag_level_order_traversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if (root == null)
            return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean ltr = true;             //left-to-right

        while (!queue.isEmpty())
        {
            int levelNum = queue.size();

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < levelNum ; i++)
            {
                TreeNode cur = queue.poll();
                if (cur.left!= null)
                    queue.offer(cur.left);
                if (cur.right!=null)
                    queue.offer(cur.right);


                if (ltr)
                    list.add(cur.val);
                else
                    list.add(0,cur.val);            //反向，不断往头插入

            }

            lists.add(list);
            ltr = !ltr;

        }

        return lists;

    }
}
