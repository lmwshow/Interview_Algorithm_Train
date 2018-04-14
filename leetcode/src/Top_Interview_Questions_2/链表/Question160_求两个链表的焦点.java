package Top_Interview_Questions_2.链表;

import Top_Interview_Questions_2.util.ListNode;

public class Question160_求两个链表的焦点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        if (headA == null || headB == null)
            return null;

        int lenA = 0;
        ListNode tmp = headA;
        while (tmp!=null)
        {
            lenA++;
            tmp = tmp.next;
        }

        int lenB = 0 ;
        tmp = headB;

        while (tmp!=null)
        {
            lenB++;
            tmp = tmp.next;
        }

        int step = Math.abs(lenA-lenB);

        if (lenA > lenB)
        {
            for (int i = 0 ; i < step; i++)
                headA = headA.next;
        }else
        {
            for (int i = 0 ; i < step; i++)
                headB = headB.next;
        }

        while (headA!=null && headB!=null)
        {
            if (headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;

    }


}
