package offer2;

import offer2.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: minGW
 * @Date: 2018/5/22 09:06
 * @Description: https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class 按之字形顺序打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tmp = pRoot;

        queue.add(pRoot);
        boolean forword = true;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            ArrayList<Integer> cur = new ArrayList<>();

            for (int i = 0 ; i < size;i++)
            {
                tmp = queue.poll();
                if (forword)
                    cur.add(tmp.val);
                else
                    cur.add(0,tmp.val);

                if (tmp.left != null)
                    queue.add(tmp.left);
                if (tmp.right != null)
                    queue.add(tmp.right);
            }

            forword = !forword;
            ans.add(cur);
        }

        return ans;
    }
}
