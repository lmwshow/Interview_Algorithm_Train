package Top_Interview_Questions_2.again;

import Top_Interview_Questions_2.util.TreeNode;

public class Question105_从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode ans = null;

        if (preorder == null || preorder.length == 0)
            return ans;

        ans = buildTreeCore(preorder,0,inorder,0,inorder.length-1);

        return ans;

    }

    private TreeNode buildTreeCore(int[] preorder, int pstart, int[] inorder, int istart,int iend) {

        if (pstart >= preorder.length || istart > iend)
            return null;

        TreeNode ans = new TreeNode(preorder[pstart]);
        int index = 0;

        for (int i = istart; i <= iend;i++)
            if (inorder[i] == ans.val) {
                index = i;
                break;
            }


        ans.left = buildTreeCore(preorder,pstart+1,inorder,istart,index-1);
        //递归 ***
        ans.right = buildTreeCore(preorder,pstart + index - istart +1,inorder,index+1,iend);

        return ans;
    }
}
