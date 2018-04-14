package Top_Interview_Questions_2.链表;

import Top_Interview_Questions_2.util.ListNode;

public class Question206_反转链表 {

    //迭代方法
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode ans = new ListNode(0); //头结点

        ListNode cur = head;

        while (cur != null)
        {
            head = head.next;
            cur.next = ans.next;
            ans.next = cur;

            cur = head;
        }

        return ans.next;

    }

    //递归方法
    public ListNode RereverseList(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
