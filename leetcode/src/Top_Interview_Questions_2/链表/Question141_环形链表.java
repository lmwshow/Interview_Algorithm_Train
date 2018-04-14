package Top_Interview_Questions_2.链表;

import Top_Interview_Questions_2.util.ListNode;

public class Question141_环形链表 {

    //环形链表 快慢指针
    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }

        return false;

    }
}
