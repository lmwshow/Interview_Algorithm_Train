package offer;

import offer.util.ListNode;

/**
 * Created by Gracecoder on 2017/12/21.
 */
public class 题24_反转链表 {
    public static ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode reverseList = new ListNode(0); //建立头结点，方便操作
        ListNode cur = null;
        while (head != null)
        {
            cur = head;
            head = head.next;
            cur.next = reverseList.next;
            reverseList.next = cur;
        }

        return reverseList.next;

    }

    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(9);
        list1 = null;

        ListNode res = ReverseList(list1);

        while (res!=null)
        {
            System.out.println(res.val);
            res = res.next;

        }

    }

}
