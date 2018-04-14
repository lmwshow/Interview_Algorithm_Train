package leetgroup;

/**
 * Created by Gracecoder on 2017/6/8.
 */
public class binary_tree_maximum_path_sum {

    public static int maxPathSum(TreeNode root) {

        if (root == null)
            return 0;

        int[] res = new int[]{Integer.MIN_VALUE};

        DFS(root,res);
        return res[0];
    }

    private static int DFS(TreeNode root, int[] res) {

        int left = 0;
        int right = 0;

        if (root.left != null)
        {
            left = DFS(root.left,res);
            left = left < 0?0:left;

        }
        if (root.right != null)
        {
            right = DFS(root.right,res);
            right = right < 0?0:right;

        }

        res[0] = Math.max(res[0],left+right+root.val);
        return Math.max(left,right)+root.val;

    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
//        root.right = new TreeNode(3);

//        root =null;
//        root.left.left = new TreeNode(4);
        int res = maxPathSum(root);
        System.out.println(res);
    }
}
