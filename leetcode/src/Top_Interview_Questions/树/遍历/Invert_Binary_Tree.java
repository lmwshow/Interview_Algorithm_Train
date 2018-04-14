package Top_Interview_Questions.树.遍历;

/**
 * Created by Gracecoder on 2017/10/20.
 */
public class Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {

        if (root!= null)
        {
            TreeNode swap = root.left;
            root.left = root.right;
            root.right = swap;
            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
    }
}
