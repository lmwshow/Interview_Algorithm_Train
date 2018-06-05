package hihocoder.树练习;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: minGW
 * @Date: 2018/6/5 08:17
 * @Description: http://hihocoder.com/problemset/problem/1049
 * <p>
 * 通过前序和中序，还原二叉树。并给出后序结果
 *
 * better_solve:  分而治之
 *
 * 定义post_order(str1, str2)为一棵前序遍历的结果为str1，中序遍历的结果为str2的二叉树的后序遍历的结果
 * 前序遍历的规律为：root + left + right
 * 中序遍历的规律为: left + root + right
 * post_order(str1, str2)=post_order(str1l, str2l)+post_order(str1r, str2r)+root
 */
public class 后序遍历 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pre = scan.next();
        String mid = scan.next();
        System.out.println(post(pre, mid));
    }

    private static String post(String pre, String mid) {
        if (pre.length() <= 1) {
            return pre;
        } else {
            char root = pre.charAt(0);
            int index = mid.indexOf(root);
            String midLeft = mid.substring(0, index);
            String midRight = mid.substring(index + 1);

            String preLeft = pre.substring(1, 1 + midLeft.length());
            String preRight = pre.substring(1 + midLeft.length());

            return post(preLeft, midLeft) + post(preRight, midRight) + root;
        }
    }


    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

    }


    public static void mw_main(String[] args) {

        Scanner in = new Scanner(System.in);

        String prestr = in.nextLine();
        String instr = in.nextLine();

        char[] preorder = prestr.toCharArray();
        char[] inorder = instr.toCharArray();

        //递归重建二叉树
        TreeNode root = buildTree(preorder, 0, inorder, 0, inorder.length - 1);

        //非递归后序遍历
        int[] tag = new int[50];

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;

        while (tmp!=null || !stack.isEmpty())
        {
            while (tmp!=null)
            {
                stack.push(tmp);
                tag[stack.size()] = 0;
                tmp = tmp.left;
            }

            while (!stack.isEmpty()&&tag[stack.size()]==1)
                System.out.print((char)stack.pop().val);

            if (!stack.isEmpty())
            {
                tag[stack.size()] = 1;
                tmp = stack.peek();
                tmp = tmp.right;
            }
        }
        
        System.out.println();
    }

    private static TreeNode buildTree(char[] preorder, int pstart, char[] inorder, int istart, int iend) {

        if (pstart >= preorder.length || istart > iend)
            return null;

        TreeNode cur = new TreeNode(preorder[pstart]);

        int index = 0;
        for (int i = istart; i <= iend; i++)
            if (preorder[pstart] == inorder[i]) {
                index = i;
                break;
            }

        cur.left = buildTree(preorder,pstart+1,inorder,istart,index-1);
        cur.right = buildTree(preorder,pstart + index - istart + 1,inorder,index+1,iend);

        return cur;

    }
}
