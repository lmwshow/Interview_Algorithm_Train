package offer2;

import offer2.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: minGW
 * @Date: 2018/5/22 09:14
 * @Description: https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class 把二叉树打印成多行 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (pRoot == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode tmp = pRoot;
        queue.add(pRoot);

        while (!queue.isEmpty())
        {
            int size =  queue.size();

            ArrayList<Integer> cur =  new ArrayList<>();

            for (int i = 0 ; i < size ; i ++)
            {
                tmp = queue.poll();

                cur.add(tmp.val);

                if (tmp.left!=null)
                    queue.add(tmp.left);
                if (tmp.right!= null)
                    queue.add(tmp.right);
            }

            ans.add(cur);
        }

        return ans;

    }
}
