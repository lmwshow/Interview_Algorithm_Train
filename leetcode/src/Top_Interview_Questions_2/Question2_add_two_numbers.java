package Top_Interview_Questions_2;

import Top_Interview_Questions_2.util.ListNode;


public class Question2_add_two_numbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = null;

        if (l1 == null && l2 == null)
            return res;
        if (l1 == null || l2 == null)
            return l1 == null?l2: l1;

        int carry = 0;
        res = new ListNode(0);    //头指针
        ListNode tmp = res;
        while (l1 != null && l2!=null )
        {
            ListNode cur = new ListNode((l1.val + l2.val + carry)%10);
            carry = (l1.val + l2.val + carry)/10;
            tmp.next = cur;
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null)
        {
            if (carry == 0)
            {
                tmp.next = l1;
                break;
            }
            else
            {
                ListNode cur = new ListNode((l1.val +  carry)%10);
                carry = (l1.val + carry)/10;
                tmp.next = cur;
                tmp = tmp.next;
                l1 = l1.next;

            }
        }

        while (l2 != null)
        {
            if (carry == 0)
            {
                tmp.next = l2;
                break;
            }
            else
            {
                ListNode cur = new ListNode((l2.val +  carry)%10);
                carry = (l2.val + carry)/10;
                tmp.next = cur;
                tmp = tmp.next;
                l2 = l2.next;

            }
        }

        if (carry!=0)
            tmp.next = new ListNode(carry);

        return res.next;
    }


    //将空直接val当为0
    public ListNode addTwoNumbers_better(ListNode l1, ListNode l2)
    {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }



    public static void main(String[] args){

    }
}
