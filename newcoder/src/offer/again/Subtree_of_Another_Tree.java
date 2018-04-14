package offer.again;


import offer.util.TreeNode;

/**
 * Created by Gracecoder on 2017/11/18.
 *
 * 遍历s的每个节点作为根节点， 判断是否和t一样  类似对每个节点再一次dfs
 */
public class Subtree_of_Another_Tree {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null)              //虽然说原s 题意说明为非空， 但是我们讲这个函数作为递归遍历， 那就有必要在这里判空
            return false;

        return dfs(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);

    }

    //dfs 用来对这个节点，判断其是否是相同的子树  左子树和右子树都要相等
    private boolean dfs(TreeNode s, TreeNode t) {

        if (s == null && t == null)
            return true;

        if (s==null || t == null ||s.val != t.val)
            return false;

        return dfs(s.left,t.left)&&dfs(s.right,t.right);

    }
}
