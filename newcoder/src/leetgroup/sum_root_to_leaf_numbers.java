package leetgroup;

/**
 * Created by Gracecoder on 2017/6/1.
 */



public class sum_root_to_leaf_numbers {

    static class Sum
    {
        int sum = 0;
    }

    public static int mysumNumbers(TreeNode root) {

        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;

        Sum res = new Sum();
        DFS(root,0,res);
        return res.sum;
    }

    private static void DFS(TreeNode root,int cur,Sum res) {

        cur = cur*10 + root.val;
        if (root.left == null && root.right==null) {
            res.sum += cur;
            return;
        }



        if (root.left!=null)
            DFS(root.left,cur,res);


        if (root.right!=null)
            DFS(root.right,cur,res);

    }
    
    public static void main(String[] args){


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

//        root =null;
//        root.left.left = new TreeNode(4);
        int res = mysumNumbers(root);
        System.out.println(res);


    }



    /*
    题解答案
     */



    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        return sumNumbers(root,0);
    }
    public int sumNumbers(TreeNode root,int sum){
        if(root==null)return 0;
        sum=sum*10+root.val;
        if(root.left==null&&root.right==null){

            return sum;
        }
        return sumNumbers(root.left,sum)+sumNumbers(root.right,sum);
    }

}
