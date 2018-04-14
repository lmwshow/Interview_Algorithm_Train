package Top_Interview_Questions_2.链表;

import Top_Interview_Questions_2.util.ListNode;

public class Question234_回文链表 {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        //链表找中点，直接使用快慢指针
        ListNode fast = head,slow = head;
        while (fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast!=null)         //长度为奇数时，右半部分还需要往右移动一个
            slow = slow.next;

        slow = reverse(slow);
        fast = head;

        while (slow!=null)
        {
            if (fast.val!=slow.val)
                return false;

            fast = fast.next;
            slow = slow.next;
        }
        return true;

    }

    private ListNode reverse(ListNode head) {

        ListNode node = new ListNode(0);
        ListNode cur = null;
        while (head!=null)
        {
            cur = head;
            head = head.next;
            cur.next = node.next;
            node.next = cur;

        }
        return node.next;
    }
}
