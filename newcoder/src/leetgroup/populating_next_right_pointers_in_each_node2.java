package leetgroup;

import java.util.LinkedList;
import java.util.Queue;



public class populating_next_right_pointers_in_each_node2 {

    public static void connect(TreeLinkNode root) {

        if(root == null)
            return;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode tail = root;
        TreeLinkNode back = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeLinkNode pre = queue.poll();
            if(pre.left!=null)
            {
                queue.offer(pre.left);
                back = pre.left;
            }
            if(pre.right!=null)
            {
                queue.offer(pre.right);
                back = pre.right;
            }

            if(pre == tail)
            {
                pre.next = null;
                tail = back;		//当遍历到每一层的尾部，且将其子节点加入队列后，无论其有没有子节点，此时队列的尾部就是下一层的结尾
            }else{
                pre.next = queue.peek();
            }
        }

        return ;
    }

    public static void main(String[] args) {

        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(7);

        connect(root);

        System.out.println("hello");
    }
}
