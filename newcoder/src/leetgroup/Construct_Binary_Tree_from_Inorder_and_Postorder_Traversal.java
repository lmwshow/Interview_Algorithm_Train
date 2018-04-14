package leetgroup;

import java.util.HashMap;

/**
 * Created by Gracecoder on 2017/6/27.
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);


        return helper(0, postorder.length - 1, 0, inorder.length - 1, inorder, postorder, map);
    }

    private static TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder, HashMap<Integer, Integer> map) {

        if (postStart > postEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        //这里可以通过hashmap预处理 ， 然后快速查找inIndex
        int inIndex = map.get(postorder[postEnd]); // Index of current root in inorder

        /* 这里偏移量 不是特别清楚！！！！ */
        root.left = helper(postStart, postStart + inIndex - inStart - 1, inStart, inIndex - 1, inorder, postorder, map);
        root.right = helper(postStart + inIndex - inStart, postEnd - 1, inIndex + 1, inEnd, inorder, postorder, map);

        return root;

    }


    public static void main(String[] args) {

//        int[] pre = new int[]{8,4,2,6,5,7,16,12,20,18,22};
        int[] in = new int[]{2, 4, 5, 6, 7, 8, 12, 16, 18, 20, 22};
        int[] post = new int[]{2, 5, 7, 6, 4, 12, 18, 22, 20, 16, 8};


        TreeNode root = buildTree(in, post);


    }
}
