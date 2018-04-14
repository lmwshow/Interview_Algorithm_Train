package leetgroup;

/**
 * Created by Gracecoder on 2017/4/8.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Convert_Sorted_List_to_Binary_Search_Tree {

    public static TreeNode mysortedListToBST(ListNode head) {


        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);


        ListNode lelf, right, slow, fast, prevslow;
        lelf = right = slow = fast = prevslow = head;

        while (fast != null && fast.next != null) {
            prevslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        lelf = head;                                            //定义中间点为slow
        right = slow.next;
        prevslow.next = null;
        slow.next = null;                                       //拿出mid ， 前后分成两个链表
        TreeNode root = new TreeNode(slow.val);                 //mid这个节点的值,为当前迭代层的根值


//        if (slow == prevslow)
//            lelf = null;
        root.left = mysortedListToBST(lelf);                      //递归左子树为root的左孩子
        root.right = mysortedListToBST(right);

        return root;


    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    public static TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next, tail);
        return thead;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);

        System.out.println("hahah");

        while (head != null) {
            System.out.println(head.val);
            head = head.next;

        }
    }
}
