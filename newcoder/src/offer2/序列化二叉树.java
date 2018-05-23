package offer2;
import offer2.util.TreeNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/23 08:03
 * @Description: https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class 序列化二叉树 {

    static int index;

    String Serialize(TreeNode root) {

        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder("");
        SerializeCore(root,sb);
        return sb.toString();

    }

    public void SerializeCore(TreeNode root,StringBuilder sb)
    {
        if (root == null)
        {
            sb.append("#,");
            return;
        }

        sb.append(root.val + ",");
        SerializeCore(root.left,sb);
        SerializeCore(root.right,sb);

    }

    TreeNode Deserialize(String str) {

        if (str == null || str.length() ==0)
            return null;

        index = -1;
        String[] strs = str.split(",");
        return DeserializeCore(strs);
    }

    public TreeNode DeserializeCore(String[] strs)
    {
        index++;
        if (!strs[index].equals("#"))
        {
            TreeNode cur = new TreeNode(Integer.parseInt(strs[index]));
            cur.left = DeserializeCore(strs);
            cur.right = DeserializeCore(strs);
            return cur;
        }

        return null;
    }
}
