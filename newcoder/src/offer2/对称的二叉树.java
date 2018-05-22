package offer2;

import offer2.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/22 08:53
 * @Description: https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class 对称的二叉树 {

    boolean isSymmetrical(TreeNode pRoot)
    {

        if (pRoot == null)
            return true;

        return isSymmetricalCore(pRoot.left,pRoot.right);

    }

    private boolean isSymmetricalCore(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val!=right.val)
            return false;

        return isSymmetricalCore(left.left,right.right)&&isSymmetricalCore(left.right,right.left);
    }
}
