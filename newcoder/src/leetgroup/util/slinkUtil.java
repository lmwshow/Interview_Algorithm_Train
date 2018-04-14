package leetgroup.util;

/**
 * Created by Gracecoder on 2017/4/8.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class slinkUtil {

    public ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }


        return slow;
    }
}
