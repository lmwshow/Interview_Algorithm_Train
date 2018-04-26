package Top_Interview_Questions_2;

import Top_Interview_Questions_2.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/4/26 10:01
 * @Description
 */
public class Question437_路径总和III {

    public int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;

        return soler(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }

    private int soler(TreeNode root,int sum) {

        if (root == null)
            return 0;

        return (root.val == sum? 1 : 0) + soler(root.left,sum - root.val) + soler(root.right,sum - root.val);
    }
}
