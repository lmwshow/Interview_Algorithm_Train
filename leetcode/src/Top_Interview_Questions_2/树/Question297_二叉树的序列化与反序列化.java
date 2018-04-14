package Top_Interview_Questions_2.树;


import Top_Interview_Questions_2.util.TreeNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedList;
import java.util.Queue;

public class Question297_二叉树的序列化与反序列化 {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder("[");

//        serializeCore(root,sb);
        if (root == null) {
            sb.append("]");
            return sb.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        TreeNode cur;
        int count = 0; //记录下一行null的个数 是否 和size相等  相等说明下一行没节点了
        while (!queue.isEmpty())
        {
            size = queue.size();
            if (size == count)
                break;
            count = 0;
            for (int i = 0 ; i < size;i++)
            {
                cur = queue.poll();
                if (cur!=null) {
                    sb.append(cur.val+",");
                    count += cur.left==null?1:0;
                    count += cur.right==null?1:0;
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
                else
                {
                    sb.append("null,");
                }
            }
        }



        return sb.deleteCharAt(sb.lastIndexOf(",")).append("]").toString();


    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        //避免string 为 ""，"[]"的情况
        if (data.length() <= 2)
            return null;

        data = data.substring(1,data.length()-1);
        String[] str = data.split(",");
        int len = str.length;
        int index = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root =new TreeNode(Integer.parseInt(str[index++]));

        queue.add(root);

        TreeNode cur;
        String tmp;
        while (!queue.isEmpty())
        {
            cur = queue.poll();
            if (cur!=null && index < len)
            {
                tmp = str[index++];
                if (!tmp.equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(tmp));
                    queue.add(cur.left);
                }
                tmp = str[index++];
                if (!tmp.equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(tmp));
                    queue.add(cur.right);
                }
            }
        }

        return root;
    }


    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String str = "[]";

        root = deserialize(str);

    }
}
