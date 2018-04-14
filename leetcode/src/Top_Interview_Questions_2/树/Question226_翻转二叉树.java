package Top_Interview_Questions_2.树;

import Top_Interview_Questions_2.util.TreeNode;

public class Question226_翻转二叉树 {

    public static TreeNode invertTree(TreeNode root) {

        if (root == null)
            return root;

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;
    }

    public static void main(String[] args){
        
        TreeNode node1 = new TreeNode(0);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(2);
        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(4);

        TreeNode root = invertTree(node1);

        System.out.println();
        
    }
}
