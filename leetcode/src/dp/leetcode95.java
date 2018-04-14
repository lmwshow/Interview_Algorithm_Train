package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gracecoder on 2017/3/9.
 */
public class leetcode95 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    递归方法
    I start by noting that 1..n is the in-order traversal for any BST with nodes 1 to n.
    So if I pick i-th node as my root, the left subtree will contain elements 1 to (i-1), and the right subtree will contain elements (i+1) to n.
    I use recursive calls to get back all possible trees for left and right subtrees and combine them in all possible ways with the root.
     */
    public List<TreeNode> generateTrees(int n) {

        return genTrees(1, n);

    }

    public List<TreeNode> genTrees(int start, int end) {

        List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }


        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = genTrees(start, i - 1);

            right = genTrees(i + 1, end);

            for (TreeNode lnode : left)
                for (TreeNode rnode : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = lnode;
                    node.right = rnode;
                    list.add(node);
                }
        }

        return list;

    }
}
