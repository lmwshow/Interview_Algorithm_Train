package 头条;


import 头条.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/7/27 10:20
 * @Description
 *
 * 1. 根据层次遍历，计算深度
 * 2. 递归更简洁，这里使用递归的方法。
 */
public class 二叉树的深度 {

    public int TreeDepth(TreeNode root) {

        if (root == null)
            return 0;

        int left =  TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return left > right? left+1: right+1;

    }

}
