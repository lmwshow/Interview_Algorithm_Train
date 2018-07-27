package offer2;

import offer2.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: minGW
 * @Date: 2018/5/17 09:30
 * @Description: https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class 二叉树的深度 {

    public int TreeDepth(TreeNode root) {


        int level = 0;
        if (root == null)
            return level;


        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.add(cur);


        while (!queue.isEmpty())
        {
            int curLevelSize = queue.size();
            level ++;

            for (int i = 0 ; i < curLevelSize ; i++)
            {
                TreeNode tmp = queue.poll();
                if (tmp.left!=null)
                    queue.add(tmp.left);
                if (tmp.right!=null)
                    queue.add(tmp.right);
            }
        }

        return level;
    }
}
