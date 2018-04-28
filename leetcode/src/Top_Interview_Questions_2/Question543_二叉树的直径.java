package Top_Interview_Questions_2;

import Top_Interview_Questions_2.util.TreeNode;

import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/4/28 10:43
 * @Description: https://leetcode-cn.com/problems/diameter-of-binary-tree/description/
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 */
public class Question543_二叉树的直径 {

    int maxlenth = 0;

    public int diameterOfBinaryTree(TreeNode root) {


        postTraversal(root);

        return maxlenth - 1> 0 ? maxlenth - 1 : 0;

    }

    private int postTraversal(TreeNode root) {

        if (root == null)
            return 0;

        int left = postTraversal(root.left);
        int right = postTraversal(root.right);
        root.val = (left>right?left:right) +1 ;
        maxlenth = Math.max(left+right +1,maxlenth);

        return root.val;
    }


    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

//        System.out.println(diameterOfBinaryTree(root));

    }
}
