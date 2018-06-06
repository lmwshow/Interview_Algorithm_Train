package Top_Interview_Questions_2.树;

import Top_Interview_Questions_2.util.TreeNode;
import tree.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
    找二叉树两个节点的最近公共祖先

    1.二叉树为二叉搜索树，递归；从树的根节点开始和两个节点作比较，如果当前节点的值比两个节点的值都大，则这两个节点的最近公共祖先节点一定在该节点的左子树中，则下一步遍历当前节点的左子树；
    2.二叉树含有父节点，可以转化为两个链表，求最近公共点
    3.二叉树没有父节点，同样可以先找到两个节点的路径，然后转化为链表 求最后面的相交点
 */
public class  Question236_二叉树的最近公共祖先 {

    static TreeNode ans;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ans = root;
        if (root == null)
            return ans;

        List<TreeNode> pRoute = new ArrayList<>();
        getNodePath(root,p,pRoute);
        List<TreeNode> qRoute = new ArrayList<>();
        getNodePath(root,q,qRoute);


        int len = (pRoute.size() > qRoute.size())? qRoute.size():pRoute.size();

        int i = 0;
        for (i = 0 ; i < len ; i++)
        {
            if (pRoute.get(i) != qRoute.get(i))
                break;
        }

        return pRoute.get(i-1);
    }

    private static boolean getNodePath(TreeNode root, TreeNode node, List<TreeNode> route) {

        if (root == null)
            return false;

        route.add(root);
        if (root == node)
            return true;

        //找到路径后，需要尽快返回不再遍历下去，所以需要一个变量
        boolean found = false;

        if (!found && root.left != null)
            found = getNodePath(root.left,node,route);
        if (!found && root.right != null)
            found = getNodePath(root.right,node,route);

        if (!found)
            route.remove(root);

        return found;

    }


    public static void main(String[] args){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(lowestCommonAncestor(root,root.left,root.left.right.right).val);

    }
}
