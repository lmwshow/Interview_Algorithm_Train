package leetgroup;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gracecoder on 2017/6/9.
 */

 class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
}
public class populating_next_right_pointers_in_each_node {

    public static void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.offer(root);
        TreeLinkNode tail = root;
        while (!queue.isEmpty()) {
            TreeLinkNode tmp = queue.poll();

            if (tmp.left!=null&&tmp.right!=null)
            {
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }

            if (tmp == tail)
            {
                tmp.next = null;
                tail = tmp.right;
            }else {
                tmp.next = queue.peek();
            }

        }
    }



    public static void main(String[] args){

        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        connect(root);
        System.out.println(root.next);

    }
}
