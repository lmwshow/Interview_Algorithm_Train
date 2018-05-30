package hihocoder.编程练习赛43;

import hihocoder.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 自底向上遍历二叉树 {

    public static ArrayList<Integer> Solution(TreeNode root)
    {
        ArrayList<Integer> res =new ArrayList<>();
        if (root == null)
            return res;
        ArrayList<Integer> cur = new ArrayList<>();
        preOrder(res,cur,root);


        return res;
    }

    private static void preOrder(ArrayList<Integer> res, ArrayList<Integer> cur, TreeNode root) {

        if (root == null)
        {
            Collections.reverse(cur);
            for (int x : cur)
                res.add(x);
            cur.clear();
            return;
        }

        cur.add(root.val);
        preOrder(res,cur,root.left);
        preOrder(res,cur,root.right);
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0)
            return;
        int u = in.nextInt();
        int v = in.nextInt();
        TreeNode root = new TreeNode(u);
        root.left = new TreeNode(v);
        TreeNode tmp = root;
        TreeNode preleft = null;
        TreeNode preright = null;
        while (--n > 0)
        {
            u = in.nextInt();
            v = in.nextInt();

            if (u == tmp.val)
            {
                if (tmp.left == null)
                    tmp.left = new TreeNode(v);
                else
                    tmp.right = new TreeNode(v);
            }


            preleft = tmp.left;
            preright = tmp.right;
        }


//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//        root.right.left.left = new TreeNode(6);
//        root.right.left.right = new TreeNode(7);
//        root.right.right.left = new TreeNode(8);
//
//        ArrayList<Integer> res = Solution(root);
//
//        for (int x : res)
//            System.out.println(x);


    }
}
