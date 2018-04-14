package offer;

import offer.util.ListNode;

/**
 * Created by Gracecoder on 2017/12/18.
 */
public class 题18_删除链表中重复的结点 {

    public static ListNode deleteDuplication(ListNode pHead)
    {

        pHead = findNoDuplication(pHead);
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode tmp = pHead;

        while (tmp.next!=null) {
            tmp.next = findNoDuplication(tmp.next);
            if (tmp.next == null)
                return pHead;
            tmp = tmp.next;
        }

        return pHead;

    }

    public static ListNode findNoDuplication(ListNode pHead)
    {
        if (pHead == null)
            return pHead;
        boolean isDuplication = false;
        int cur = pHead.val;

        while (pHead.next!=null)
        {
            while (pHead.next!=null  && cur == pHead.next.val) {
                isDuplication = true;
                pHead = pHead.next;
            }
            if (!isDuplication)
                return pHead;
            pHead = pHead.next;
            if (pHead == null)
                return pHead;
            cur = pHead.val;
            isDuplication = false;
        }

        return pHead;
    }


    public static void main(String[] args){

        ListNode phead = new ListNode(1);
        phead.next = new ListNode(1);
//        phead.next.next = new ListNode(2);
//        phead.next.next.next = new ListNode(3);
//        phead.next.next.next.next = new ListNode(3);

        phead = deleteDuplication(phead);
        while (phead!=null)
        {
            System.out.println(phead.val);
            phead = phead.next;

        }

    }
}
