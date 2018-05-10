package offer2;

import offer2.util.ListNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/10 08:15
 * @Description:
 */
public class 反转链表 {


    public ListNode ReverseList(ListNode head) {

        if (head == null)
            return head;

        ListNode ans = head,tail = head,cur = head;

        while (tail.next != null)
        {
            cur = tail.next;
            tail.next = cur.next;
            cur.next = ans;
            ans = cur;
        }

        return ans;
    }

}
