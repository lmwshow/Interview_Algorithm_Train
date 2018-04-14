package leetgroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Gracecoder on 2017/6/15.
 */
public class binary_tree_level_order_traversal_2 {


    //两种记录当前层结束的标志

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();                                                //记录当前层的数量
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {                                             //用一个for循环，把下一层的节点都加入，且当前层都poll出去 加入一个list中
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if (root == null)
            return lists;

        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tail = root;                               //记录每层的最后一个节点
        TreeNode curback = root;                            //记录当前队列的最尾部
        queue.offer(root);

        while (!queue.isEmpty())
        {
            TreeNode cur = queue.poll();
            list.add(cur.val);

            if (cur.left!=null)
            {
                queue.offer(cur.left);
                curback = cur.left;
            }
            if (cur.right!=null)
            {
                queue.offer(cur.right);
                curback = cur.right;
            }

            if (cur == tail)
            {
                lists.add(0,new ArrayList<Integer>(list));
                list.clear();
                tail = curback;

            }

        }

        return lists;
    }
}
