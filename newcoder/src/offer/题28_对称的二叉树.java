package offer;

import offer.util.TreeNode;

/**
 * Created by Gracecoder on 2017/12/22.
 */
public class 题28_对称的二叉树 {

    public static boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;

        TreeNode leftSubTree = pRoot.left;
        TreeNode rightSubTree = pRoot.right;

        Mirror(rightSubTree);
        return isSameTree(leftSubTree,rightSubTree);

    }

    public static void Mirror(TreeNode subtree)
    {
        if (subtree == null)
            return;

        TreeNode swap = subtree.left;
        subtree.left = subtree.right;
        subtree.right =swap;

        Mirror(subtree.left);
        Mirror(subtree.right);

        return;
    }

    public static boolean isSameTree(TreeNode p ,TreeNode q)
    {
        if (p==null && q == null)
            return true;

        if (p == null || q == null || p.val!=q.val)
            return false;

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }


    public static void main(String[] args){

        TreeNode root1 = new TreeNode(8);
//        root1.left = new TreeNode(8);
//        root1.right = new TreeNode(8);
//        root1.left.left = new TreeNode(9);
//        root1.left.right = new TreeNode(2);
//        root1.right.left = new TreeNode(2);
//        root1.right.right = new TreeNode(9);

        System.out.println(isSymmetrical(root1));


    }


}
