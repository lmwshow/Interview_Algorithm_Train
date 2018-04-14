package leetgroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gracecoder on 2017/6/26.
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {


    //preStart用来记录先序的状态，左孩子就是preStart + 1 先序的下个节点，右孩子preStart + inIndex - inStart + 1，表示当前下标加上偏移量，即中序小标的下一个位置
    //inStart表示中序遍历开始的下标
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder

        //这里可以通过hashmap预处理 ， 然后快速查找inIndex

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }




    /*
        这里是先将数组 转化为list ，remove 已用节点， 如果用数组的话  就全程使用下标 代表子数组 递归
    * */
    public static TreeNode mybuildTree(int[] preorder, int[] inorder) {

        TreeNode root = null;
        if (preorder.length == 0)
            return root;



//        List preorderlist = new ArrayList<>(Arrays.asList(preorder));
//        List inorderlist = new ArrayList<>(Arrays.asList(inorder));

        List preorderlist = new ArrayList(preorder.length);
        for (int i : preorder
             ) {
            preorderlist.add(i);
        }

        List inorderlist = new ArrayList(inorder.length);
        for (int i : inorder
             ) {
            inorderlist.add(i);

        }

        root = new TreeNode(preorder[0]);

        int index = inorderlist.indexOf(preorderlist.get(0));


        List left = inorderlist.subList(0, index);
        List right = inorderlist.subList(index + 1, inorderlist.size());

        preorderlist.remove(0);
        Lbuild(root, preorderlist, left);
        Rbuild(root, preorderlist, right);

        return root;



    }


    private static void Lbuild(TreeNode root, List preorder, List leftinorder) {

        if (leftinorder.isEmpty())
            return;

        root.left = new TreeNode((Integer) preorder.get(0));

        int index = leftinorder.indexOf(preorder.get(0));

        preorder.remove(0);

        List left = leftinorder.subList(0, index);
        List right = leftinorder.subList(index + 1, leftinorder.size());
        Lbuild(root.left, preorder, left);
        Rbuild(root.left, preorder, right);

    }

    private static void Rbuild(TreeNode root, List preorder, List rightinorder) {

        if (rightinorder.isEmpty())
            return;

        root.right = new TreeNode((Integer) preorder.get(0));

        int index = rightinorder.indexOf(preorder.get(0));

        preorder.remove(0);

        List left = rightinorder.subList(0, index);
        List right = rightinorder.subList(index + 1, rightinorder.size());
        Lbuild(root.right, preorder, left);
        Rbuild(root.right, preorder, right);

    }

    public static void main(String[] args){

        int[] pre = new int[]{8,4,2,6,5,7,16,12,20,18,22};
        int[] in = new int[]{2,4,5,6,7,8,12,16,18,20,22};

        TreeNode root = mybuildTree(pre,in);




    }


}
