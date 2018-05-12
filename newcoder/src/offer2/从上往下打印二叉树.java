package offer2;

import offer2.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: minGW
 * @Date: 2018/5/12 08:42
 * @Description: 队列层次遍历
 */
public class 从上往下打印二叉树 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tmp = root;
        queue.add(tmp);
        int curLevelSize = 0;

        while (!queue.isEmpty())
        {
            curLevelSize = queue.size();

            for (int i = 0 ; i < curLevelSize ; i++)
            {
                tmp = queue.poll();
                ans.add(tmp.val);

                if (tmp.left!=null)
                    queue.add(tmp.left);
                if (tmp.right!=null)
                    queue.add(tmp.right);
            }
        }


        return ans;

    }

}
