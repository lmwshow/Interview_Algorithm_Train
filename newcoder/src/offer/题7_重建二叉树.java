package offer;

import offer.util.TreeNode;

import java.util.Arrays;

/**
 * Created by Gracecoder on 2017/12/6.
 */
public class 题7_重建二叉树 {

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {


        if (pre == null || in==null || pre.length == 0)
            return null;

        int val = pre[0];

        int index = search(val,in);
        if (index == -1)
            return null;

        TreeNode root = new TreeNode(val);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,pre.length),Arrays.copyOfRange(in,0,index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,index+1,pre.length),Arrays.copyOfRange(in,index+1,in.length));

        return root;


    }

    private static int search(int val, int[] in) {

        for (int i = 0 ; i < in.length ; i++)
            if (in[i] == val)
                return i;

        return -1;
    }


    //中序遍历的序列 又不是有序序列，二分mmp
    private static int binarySearch(int val, int[] in) {

        int left = 0;
        int right = in.length -1;

        while (left <= right)
        {
            int mid = (right-left)/2 + left;
            if (in[mid] == val)
                return mid;
            else if (in[mid] < val)
                left = mid+1;
            else
                right = mid -1;
        }

        return -1;
    }


    public static void main(String[] args){

        TreeNode root = reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
        root = reConstructBinaryTree(new int[]{1,2,3,4},new int[]{4,3,2,1});

        System.out.println(root);


    }
}
