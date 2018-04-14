package Top_Interview_Questions.again;

/**
 * Created by Gracecoder on 2017/11/16.
 *
 * 自己的想法就是，对每一个点进行dfs遍历,但是没有很好的写出来
 */
public class Path_Sum_III {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;

        return soler(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    private int soler(TreeNode root,int sum) {

        if (root == null)
            return 0;

        return (root.val == sum? 1 : 0) + soler(root.left,sum - root.val) + soler(root.right,sum - root.val);
    }
}
