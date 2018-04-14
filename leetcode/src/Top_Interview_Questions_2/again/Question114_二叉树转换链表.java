package Top_Interview_Questions_2.again;

import Top_Interview_Questions_2.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question114_二叉树转换链表 {

    //引用传递的还是形参，果然只是对形参的引用进行修改，而不对引用指向的具体对象修改，那就没有意义
    //所以题意才是原地进行修改
    public static void flatten(TreeNode root) {

        //由于可能存在节点的值相同 ，所以不宜用map
        List<TreeNode> list = new ArrayList<>();
        TreeNode ans = new TreeNode(0);     //表示头结点
        TreeNode tmp = ans;

        preorder(list, root);

        for (TreeNode x : list) {

            tmp.right = x;
            tmp.left = null;
            tmp = tmp.right;
        }

        root = ans.right;
        return;

    }

    private static void preorder(List<TreeNode> list, TreeNode root) {

        if (root == null)
            return;

        list.add(root);
        preorder(list, root.left);
        preorder(list, root.right);

    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        flatten(root);
    }


}
