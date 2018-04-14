package offer;

import offer.util.TreeNode;

/**
 * Created by Gracecoder on 2017/12/22.
 */
public class 题27_二叉树的镜像 {

    public static void Mirror(TreeNode root) {

        if (root == null)
            return;

        TreeNode swap = root.left;
        root.left = root.right;
        root.right = swap;

        Mirror(root.left);
        Mirror(root.right);

        return;

    }

    public static void main(String[] args){


        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);

        Mirror(root1);

        System.out.println(root1);

    }
}
