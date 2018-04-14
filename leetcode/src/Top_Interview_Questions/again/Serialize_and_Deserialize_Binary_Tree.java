package Top_Interview_Questions.again;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gracecoder on 2017/10/31.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Serialize_and_Deserialize_Binary_Tree {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder("");
        if (root == null)
            return "null,";         //用于解码分割

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean next = true;

        while (next)                            //这里空节点 也offer进去，队列已经不会为空了，需要改变结束条件，当当前层所有的子节点都为null
        {
            next = false;
            int levelNum = queue.size();       //可以用来记录下一层节点的个数，然后通过循环把这一层的节点都poll出来，需要分层次的时候可以用

            for (int i = 0 ; i < levelNum ; i++) {
                TreeNode cur = queue.poll();
                if (cur == null)
                    sb.append("null,");
                else
                    sb.append(cur.val + ",");

                queue.offer(cur==null?null:cur.left);   //如果当前节点是null，继续将其左右节点null压入，直到这一层所有的节点的子节点都为null
                queue.offer(cur==null?null:cur.right);

                if (cur!=null && (cur.left!=null || cur.right!=null))
                    next = true;
            }


        }

        String res = sb.toString();
        while (res.endsWith("null,"))
            res = res.substring(0,res.length() - 5);

        return res;

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        String[] node = data.split(",");
        int len = node.length;                  //这里下标0位第一个节点，1位第二个节点，推出下标i元素的节点其左孩子下标(i+1)*2-1,右孩子为（i+1）*2
        TreeNode root = null;
        if (node[0].equals("null"))
            return root;
        else
            root = new TreeNode(Integer.parseInt(node[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (count < len / 2)
        {
            TreeNode cur = queue.poll();

            if (cur != null) {

                if (!node[(count + 1) * 2 - 1].equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(node[(count + 1) * 2 - 1]));
                    queue.offer(cur.left);
                } else
                    queue.offer(null);

                if ((count + 1) * 2 < len && !node[(count + 1) * 2].equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(node[(count + 1) * 2]));
                    queue.offer(cur.right);
                } else
                    queue.offer(null);
            }

            count ++;

        }


        return root;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
//        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
//        root.right.left.right = new TreeNode(8);
        root.left.left.left.left = new TreeNode(8);
        System.out.println(serialize(root));

        TreeNode de = deserialize(serialize(root));


        Object[] res = new Object[]{1,2,null,3,4};
        System.out.println(Arrays.toString(res));

        String str = "1,2,null,";
        System.out.println(str.substring(0,str.length()-5));



    }
}
