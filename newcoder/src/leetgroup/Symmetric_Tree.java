package leetgroup;

import java.util.ArrayList;

/**
 * Created by Gracecoder on 2017/6/23.
 */
public class Symmetric_Tree {


    //----------递归---------//
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }



    //分别DFS 左右子树，左子树先序， 右子树自定义相反， 然后比较list
    public boolean myisSymmetric(TreeNode root) {

        if (root ==null)
            return true;

        TreeNode tmp = root;
        ArrayList<Integer> ltree = new ArrayList<>();
        ArrayList<Integer> rtree = new ArrayList<>();

        LDFS(tmp.left, ltree);
        RDFS(tmp.right, rtree);

        if (ltree.size() != rtree.size())
            return false;

        for (int i = 0;i < ltree.size();i++)
            if (ltree.get(i) != rtree.get(i))
                return false;

        return true;
    }

    private void RDFS(TreeNode tmp, ArrayList tree) {


        tree.add(tmp == null ? null : tmp.val);

        if (tmp == null)
            return;

        else {
            RDFS(tmp.right, tree);
            RDFS(tmp.left, tree);

        }
    }

    private void LDFS(TreeNode tmp, ArrayList tree) {

        tree.add(tmp == null ? null : tmp.val);

        if (tmp == null)
            return;

        else {
            LDFS(tmp.left, tree);
            LDFS(tmp.right, tree);

        }
    }
}
