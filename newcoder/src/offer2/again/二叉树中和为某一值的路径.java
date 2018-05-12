package offer2.again;

import offer2.util.TreeNode;

import java.util.ArrayList;

/**
 * @Auther: minGW
 * @Date: 2018/5/12 10:02
 * @Description: https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * <p>
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class 二叉树中和为某一值的路径 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> cur = new ArrayList<>();

        if (root == null)
            return ans;

        cur.add(root.val);
        dfs(root, target - root.val, ans, cur);

        return ans;
    }

    private void dfs(TreeNode root, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur) {

        //需要判断是叶子节点
        if (target == 0) {
            if (root.left == null && root.right == null)
                ans.add(new ArrayList<>(cur));

            return;
        }


        if (root.left != null) {
            cur.add(root.left.val);
            dfs(root.left, target - root.left.val, ans, cur);
            cur.remove(cur.size() - 1);

        }
        if (root.right != null) {
            cur.add(root.right.val);
            dfs(root.right, target - root.right.val, ans, cur);
            cur.remove(cur.size() - 1);
        }

    }
}
