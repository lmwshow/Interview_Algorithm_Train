package Top_Interview_Questions_2.again;

import Top_Interview_Questions_2.util.TreeNode;

public class Question124_二叉树中的最大路径和 {

    static int max;

    //后序遍历，更新每个节点为转折点时的最大路径(max), 同时node.val维护经过以此为终点时的最大路径
    //    max = Math.max(max,(root.left==null||root.left.val<0?0:root.left.val)+(root.right==null||root.right.val<0?0:root.right.val)+root.val);

    //    root.val = Math.max((root.left==null||root.left.val<0?0:root.left.val),(root.right==null||root.right.val<0?0:root.right.val))+root.val;

    //注意点，节点值可能为负数，所以当以node为转折点，若子路径为负数，就直接剪掉
    public int maxPathSum(TreeNode root) {

        max = Integer.MIN_VALUE;
        if (root == null)
            return max;

        postTraversal(root);

        return max;
    }

    private void postTraversal(TreeNode root) {

        if (root == null)
            return;

        postTraversal(root.left);
        postTraversal(root.right);

        max = Math.max(max,(root.left==null||root.left.val<0?0:root.left.val)+(root.right==null||root.right.val<0?0:root.right.val)+root.val);

        root.val = Math.max((root.left==null||root.left.val<0?0:root.left.val),(root.right==null||root.right.val<0?0:root.right.val))+root.val;
    }
}
