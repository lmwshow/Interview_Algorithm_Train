package Top_Interview_Questions_2;

import Top_Interview_Questions_2.util.ListNode;

public class Question21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null)
            return l1 == null?l2:l1;

        ListNode head = new ListNode(0);
        ListNode tmp = head;

        while (l1!=null && l2!=null)
        {
            if (l1.val < l2.val)
            {
                tmp.next = l1;
                l1 = l1.next;
            }else
            {
                tmp.next = l2;
                l2 = l2.next;
            }

            tmp = tmp.next;
        }

        if (l1 == null)
            tmp.next = l2;
        else
            tmp.next = l1;

        return head.next;

    }
}
