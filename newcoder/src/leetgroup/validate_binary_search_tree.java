package leetgroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Gracecoder on 2017/6/21.
 */
public class validate_binary_search_tree {


    //判断是否为二叉搜索树， 看中序遍历是否递增
    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode tmp = root;

        while (tmp!=null || !stack.isEmpty())
        {
            while (tmp!=null)
            {
                stack.push(tmp);
                tmp = tmp.left;
            }

            if (!stack.isEmpty())
            {
                tmp = stack.pop();
                if (!list.isEmpty()&&tmp.val <= list.get(list.size()-1))
                    return false;
                list.add(tmp.val);

                tmp = tmp.right;
            }

        }

        return true;

    }


}
