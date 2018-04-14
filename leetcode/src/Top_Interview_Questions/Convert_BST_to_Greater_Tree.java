package Top_Interview_Questions;

import Top_Interview_Questions.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gracecoder on 2017/11/17.
 *
 * 中序遍历节点，当前节点的值为该节点到最后一个节点的sum  我们先算出总的sum 然后一个个减去就可以了
 * 但是这样需要遍历两次
 *
 * 那我们可以反向中序遍历，以递减的顺序遍历二叉排序树。然后遍历的点就可以直接加上在它前面遍历过的点和 即可
 */
public class Convert_BST_to_Greater_Tree {

    public TreeNode convertBST(TreeNode root) {

        if (root == null)
            return root;

        List<TreeNode> list = new ArrayList<>();
        int[] sum = new int[1];

        inOrder(root,sum,list);

        int cur = 0;
        for (TreeNode node : list)
        {
            cur = node.val;
            node.val = sum[0];
            sum[0] -= cur;
        }

        return root;

    }

    public void inOrder(TreeNode root,int[] sum,List<TreeNode> list) {


        if (root.left!=null)
            inOrder(root.left,sum,list);
        sum[0]+=root.val;
        list.add(root);

        if (root.right!=null)
            inOrder(root.right,sum,list);

    }


    int sum = 0;

    public TreeNode better_convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}
