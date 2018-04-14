package leetgroup;

/**
 * Created by Gracecoder on 2017/6/15.
 */
public class path_sum {

//题解方法， 直接递归

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }



//    static class Res {
//        Boolean res = false;
//    }
//
//    public static boolean hasPathSum(TreeNode root, int sum) {
//
//        if (root == null)
//            return false;
//
//
//        Res res = new Res();
//        int cur = root.val;
//        DFS(root, cur, sum, res);
//
//        return res.res;
//    }
//
//    private static void DFS(TreeNode root, int cur, int sum, Res res) {
//
//        if (res.res)
//            return;
//
//        if (root.left == null && root.right == null) {
//            if (cur == sum)
//                res.res = true;
//
//            return;
//        }
//
//        if (root.left != null)
//            DFS(root.left, cur + root.left.val, sum, res);
//        if (root.right != null)
//            DFS(root.right, cur + root.right.val, sum, res);
//
//    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.right.right = new TreeNode(1);

//        Boolean res = hasPathSum(node, 28);

//        System.out.println(res);

    }
}
