package offer;

import offer.util.TreeNode;

public class 题36_二叉搜索树与双向链表 {

    public static TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null)
            return null;

        pRootOfTree.left = LeftConvert(pRootOfTree.left);
        pRootOfTree.right = RightConvert(pRootOfTree.right);
        if (pRootOfTree.left !=null)
            pRootOfTree.left.right = pRootOfTree;
        if (pRootOfTree.right != null)
            pRootOfTree.right.left = pRootOfTree;


        while (pRootOfTree.left != null)
            pRootOfTree = pRootOfTree.left;
        return pRootOfTree;

    }

    private static TreeNode LeftConvert(TreeNode leftTree) {
        if (leftTree == null)
            return null;

        leftTree.left = LeftConvert(leftTree.left);
        if (leftTree.left != null)
            leftTree.left.right = leftTree;
        leftTree.right = RightConvert(leftTree.right);
        if (leftTree.right != null)
            leftTree.right.left = leftTree;

        while (leftTree.right != null)
            leftTree = leftTree.right;

        return leftTree;
    }

    private static TreeNode RightConvert(TreeNode rightTreee) {
        if (rightTreee == null)
            return null;

        rightTreee.left = LeftConvert(rightTreee.left);
        if (rightTreee.left != null)
            rightTreee.left.right = rightTreee;
        rightTreee.right = RightConvert(rightTreee.right);
        if (rightTreee.right != null)
            rightTreee.right.left = rightTreee;

        while (rightTreee.left != null)
            rightTreee = rightTreee.left;

        return rightTreee;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(6);

        root1 = Convert(root1);
        System.out.println("");

    }
}
