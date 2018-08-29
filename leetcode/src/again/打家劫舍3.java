package again;

import Top_Interview_Questions_2.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/8/24 10:01
 * @Description:
 *
 * 对于树的每个节点都有两个状态，偷与不偷。深度优先遍历，后序遍历维护一个数组表示每个节当前偷与不偷的最大值
 * 遍历每个节点，每个节点返回两个数，分别表示偷这个结点时的最大值与不偷的最大值
 */
public class 打家劫舍3 {

    public int rob(TreeNode root) {

        if (root == null)
            return 0;

        int[] ans = dfs(root);

        return Math.max(ans[0],ans[1]);

    }

    private int[] dfs(TreeNode root) {

        if (root == null)
            return new int[2];

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] ans = new int[2];

        //偷,左子树不偷的价值 + 右子树不偷的价值 + 当前val
        ans[0] = left[1] + right[1] + root.val;

        //不偷
        ans[1] = Math.max(left[0],left[1]) + Math.max(right[0] ,right[1]);

        return ans;

    }

}
