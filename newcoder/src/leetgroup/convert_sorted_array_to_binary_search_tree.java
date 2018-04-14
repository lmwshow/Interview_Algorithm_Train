package leetgroup;

/**
 * Created by Gracecoder on 2017/8/14.
 */
public class convert_sorted_array_to_binary_search_tree {

    public static TreeNode sortedArrayToBST(int[] num) {

        if (num.length == 0)
            return null;

        TreeNode root =new TreeNode(0);
        helper(root,num,0,num.length -1);
        return root;

    }

    public static void helper(TreeNode node,int[] num,int i,int j)
    {
        if (i > j) {
            return;
        }

        int mid = (i+j)/2;
        if (node != null)
            node.val = num[mid];
        else
            node = new TreeNode(num[mid]);

        helper(node.left,num,i,mid-1);
        helper(node.right,num,mid+1,j);
    }

    public static void main(String[] args){

        TreeNode root = sortedArrayToBST(new int[]{1,3});

    }


}
