package offer;

import offer.util.TreeNode;

import java.util.ArrayList;

public class 题34_二叉树中和为某一值的路径 {

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {


        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curPath = new ArrayList<>();

        if (root == null)
            return res;
        curPath.add(root.val);
        solver(root,target,res,root.val,curPath);
        
        return res;

    }

    private static void solver(TreeNode root, int target, ArrayList<ArrayList<Integer>> res,int curSum,ArrayList<Integer> curPath) {

        if (curSum == target)
        {
            if (root.left == null && root.right==null)
                res.add(new ArrayList<>(curPath));
            return;
        }

        if (root.left != null) {
            curPath.add(root.left.val);
            solver(root.left, target, res, curSum + root.left.val, curPath);
            curPath.remove(curPath.size() - 1);
        }

        if (root.right != null) {
            curPath.add(root.right.val);
            solver(root.right, target, res, curSum + root.right.val, curPath);
            curPath.remove(curPath.size() - 1);
        }


    }
    
    
    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        
        res = FindPath(root1,16);

        System.out.println("");
        

    }

}
