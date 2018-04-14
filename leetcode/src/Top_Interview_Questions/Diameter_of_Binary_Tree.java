package Top_Interview_Questions;

import Top_Interview_Questions.util.TreeNode;

/**
 * Created by Gracecoder on 2017/11/17.
 *
 * 找任意两点间路径最长的长度
 * 我的想法是：后序遍历 让每个节点的val 表示为以该节点为转折点时其子路径的长度，即max(left,right) + 1 同时更新maxlength 和 left + right比较
 *
 * 本来还觉得缺点是需要改原树节点的val
 *
 * 发现原来根本不需要
 */
public class Diameter_of_Binary_Tree {

    int maxlenth = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        postTraversal(root);

        return maxlenth> 0 ? maxlenth  : 0;

    }

    private int postTraversal(TreeNode root) {

        if (root == null)
            return 0;

        int left = postTraversal(root.left);
        int right = postTraversal(root.right);
//        root.val = (left>right?left:right) +1 ;
        maxlenth = Math.max(left+right,maxlenth);

//        return root.val;
        return (left>right?left:right) +1;
    }

}
