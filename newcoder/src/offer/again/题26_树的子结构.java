package offer.again;

import offer.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gracecoder on 2017/12/21.
 *
 * 这道题是判断子结构 和 判断子树 不一样
 */
public class 题26_树的子结构 {

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {


        if (root1 == null || root2 == null)
            return false;

        List<TreeNode> list = new ArrayList<>();
        dfs(root1,list);

        boolean res = false;
        for (TreeNode node : list)
        {
            res = isSubTree(node,root2);
            if (res)
                break;
        }

        return res;

    }

    private static void dfs(TreeNode root1, List<TreeNode> list) {

        if (root1!=null)
        {
            list.add(root1);
            dfs(root1.left,list);
            dfs(root1.right,list);
        }

        return;

    }

    //判断是否是子结构  而不是子树
    public static boolean isSubTree(TreeNode p, TreeNode q) {

        if (q == null)
            return true;

        if (p == null || (p.val != q.val))
            return false;

        return isSubTree(p.left, q.left) && isSubTree(p.right, q.right);
    }
    
    
    public static void main(String[] args){


        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(HasSubtree(root1,root2));


    }
}
