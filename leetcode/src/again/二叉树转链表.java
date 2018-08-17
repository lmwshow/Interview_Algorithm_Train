package again;

import Top_Interview_Questions_2.util.TreeNode;

import java.util.PriorityQueue;

/**
 * @Auther: minGW
 * @Date: 2018/8/10 09:55
 * @Description:
 */
public class 二叉树转链表 {

    //将二叉树原地转成链表，以右指针为链表指针

    /*
        Solution1:  先序遍历后保存节点后，对节点进行重组。 有点牵强，不太符合原地转换的条件

        Solution2:  后序遍历,从下往上将子树转换为链表，直接更新右节点，但是常规的后续遍历需要保存左子树的最右下子节点。
                    这里采用 先右后左的 后续遍历，这样只需要保存上一次返回的子树头结点即可
     */


    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
