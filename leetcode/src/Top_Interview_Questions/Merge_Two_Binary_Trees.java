package Top_Interview_Questions;

import Top_Interview_Questions.util.TreeNode;

/**
 * Created by Gracecoder on 2017/11/22.
 *
 * 完美写法 QAQ 简洁好看自己写的
 * 对于 t1(t.left) 为null， 直接t1 = t2 是不行的 这样虽然能将t2赋给t1 但是t.left 本来是null，即t1本身和t之间没有关联,这样赋值后，依旧没有关联
 * 需要 t.left = t1  这样赋值 建立联系
 */
public class Merge_Two_Binary_Trees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null || t2 == null)
            return t1 ==null?t2:t1;
        else
        {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left,t2.left);
            t2.right = mergeTrees(t1.right,t2.right);
        }

//        solver(t1,t2);
        return t1;
    }

    private static void solver(TreeNode t1, TreeNode t2) {


        if (t1 == null && t2 == null)
            return;


        if (t1 == null)
            t1 = t2;
        else if (t2 !=null)
        {
            t1.val += t2.val;
            if (t1.left == null)
                t1.left = t2.left;
            else
                solver(t1.left,t2.left);

            if (t1.right == null)
                t1.right = t2.right;
            else
            solver(t1.right,t2.right);
        }

    }


    public static void main(String[] args){

        TreeNode t1 = null;
        TreeNode t2 = new TreeNode(1);

        t1 = mergeTrees(t1,t2);

    }
}
