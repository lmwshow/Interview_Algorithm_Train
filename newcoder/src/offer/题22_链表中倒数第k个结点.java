package offer;

import offer.util.ListNode;

/**
 * Created by Gracecoder on 2017/12/20.
 *
 * 使用快慢两个指针，快指针先到第k个(k-1步)，  然后快慢一起走，当快指针走到头，慢指针就是倒数第k个
 */
public class 题22_链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {


        if (head == null || k==0)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        //判断总长度是否大于k
        for (int i = 0 ; i < k-1 ; i++)
        {
            fast = fast.next;
            if (fast == null)
                return null;
        }

        while (fast.next!= null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
}
