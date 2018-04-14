package offer;

import offer.util.ListNode;

/**
 * Created by Gracecoder on 2017/12/20.
 *
 * 使用快慢指针
 * 画图，设从起点到环入口长度为m，相交点必然在环上，设距离起点x，环的长度为n
 * 假设走了k步， 那么k = m + a*n + x; 2k = m + b*n +x ;    ==>  m+x 是n的倍数 即 m+x = c*n ==> m = c*n -x = (c-1)*n +n-x
 * 而相交点再往前走n-x步 就能到达入口，  可以看出 此时同时从头开始遍历，第一次相交的点就是入口点
 */
public class 题23_链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {

        if (pHead == null || pHead.next ==null)
            return null;

        ListNode slow = pHead;
        ListNode fast = pHead;
        boolean begin = true;

        while (slow!=fast || begin)
        {
            begin = false;
            if (fast.next == null || fast.next.next ==null)
                return null;

            slow = slow.next;
            fast = fast.next.next;
        }

        fast = pHead;
        while (slow!=fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
