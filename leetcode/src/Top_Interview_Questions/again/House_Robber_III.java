package Top_Interview_Questions.again;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/11/6.
 *
 * 这里用递归去遍历树，会重复计算很多点
 * 所以使用了Map来做缓存进行优化
 */
public class House_Robber_III {

    public static int rob(TreeNode root) {

        Map<TreeNode,Integer> map = new HashMap<>();

        int res = subrob(root,map);

        return res;

    }

    private static int subrob(TreeNode root, Map<TreeNode, Integer> map) {

        if (root == null)
            return 0;

        int val = 0;

        if (map.containsKey(root))
            return map.get(root);

        if (root.left != null)
            val += (subrob(root.left.left,map) + subrob(root.left.right,map));
        if (root.right != null)
            val += (subrob(root.right.left,map) + subrob(root.right.right,map));

        val = Math.max(val + root.val,subrob(root.left,map)+subrob(root.right,map));

        map.put(root,val);

        return val;

    }

    public static void main(String[] args){


    }
}
