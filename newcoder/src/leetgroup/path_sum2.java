package leetgroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gracecoder on 2017/6/15.
 */
public class path_sum2 {

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if (root == null)
            return lists;

        ArrayList<Integer> res = new ArrayList<>();
        int cur = root.val;
        res.add(cur);

        DFS(root,lists,res,cur,sum);

        return lists;

    }

    private static void DFS(TreeNode root, ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> res, int cur, int sum) {

        if (root.left==null&&root.right==null)
        {
            if (cur == sum)
                lists.add(new ArrayList<>(res));
            return;
        }

        if (root.left!=null)
        {
            res.add(root.left.val);
            DFS(root.left,lists,res,cur+root.left.val,sum);
            res.remove(res.size()-1);
        }
        if (root.right!=null)
        {
            res.add(root.right.val);
            DFS(root.right,lists,res,cur+root.right.val,sum);
            res.remove(res.size()-1);
        }

    }


    public static void main(String[] args){

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.right.right = new TreeNode(1);

        ArrayList<ArrayList<Integer>> list = pathSum(node,22);
        
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0,1);

        for (int i:res
             ) {
            System.out.println(i);

        }
    }
}
