package Top_Interview_Questions_2.树;
import Top_Interview_Questions_2.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question94_中序遍历二叉树 {


    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode tmp = root;

        while (tmp!=null || !stack.isEmpty())
        {
            while (tmp!=null)
            {
                stack.add(tmp);
                tmp = tmp.left;
            }

            if (!stack.isEmpty()) {
                tmp = stack.pop();
                ans.add(tmp.val);
                tmp = tmp.right;
            }
        }

        return ans;

    }


//    public static List<Integer> inorderTraversal(TreeNode root) {
//
//        List<Integer> ans = new ArrayList<>();
//        if (root == null)
//            return ans;
//
//        inorder(ans,root);
//
//        return ans;
//
//    }
//
//    private static void inorder(List<Integer> ans, TreeNode root) {
//
//        if (root == null)
//            return;
//
//        inorder(ans,root.left);
//        ans.add(root.val);
//        inorder(ans,root.right);
//
//    }


    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> ans = inorderTraversal(root);

        for (int x : ans)
            System.out.println(x);


    }

}
