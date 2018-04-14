package offer;

import offer.util.TreeNode;

public class 题37_序列化二叉树 {


    String Serialize(TreeNode root) {

        if (root == null)
            return "";
        StringBuilder sb =new StringBuilder("");
        Serialize2(root,sb);
        return sb.toString();

    }

    private void Serialize2(TreeNode root, StringBuilder sb) {

        if (root == null)
        {
            sb.append("#,");
            return;
        }

        sb.append(root.val);
        sb.append(",");

        Serialize2(root.left,sb);
        Serialize2(root.right,sb);

    }

    int index = -1;

    TreeNode Deserialize(String str) {

        if (str == null || str.length() == 0)
            return null;

        String[] strs = str.split(",");
        return Deserialize2(strs);


    }

    private TreeNode Deserialize2(String[] strs) {

        index++;
        if (!strs[index].equals("#"))
        {
            TreeNode root = new TreeNode(Integer.parseInt(strs[index]));
            root.left = Deserialize2(strs);
            root.right = Deserialize2(strs);
            return root;
        }

        return null;

    }
}
