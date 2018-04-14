package Top_Interview_Questions_2.树;

import Top_Interview_Questions_2.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question98_验证有效二叉搜索树 {

    public static boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;
        List<Long> list = new ArrayList<>();
        inorderSearch(root, list);
        boolean ans = true;

        for (int i = 1; i < list.size(); i++)
            if (list.get(i) - list.get(i - 1) <= 0) {
                ans = false;
                break;
            }


        return ans;

    }

    private static void inorderSearch(TreeNode root, List<Long> list) {

        if (root == null)
            return;

        inorderSearch(root.left, list);
        list.add((long) root.val);
        inorderSearch(root.right, list);

    }


    public static void main(String[] args){

        TreeNode root = new TreeNode(-2147483648);
        root.right = new TreeNode(2147483647);

        System.out.println(isValidBST(root));


    }

}
