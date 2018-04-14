package Top_Interview_Questions_2;

import Top_Interview_Questions_2.util.ListNode;

public class Question19_Remove_Nth_Node_From_End_of_List {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next==null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        for (int i = 1 ; i < n ; i++)
        {
            fast = fast.next;
            if (fast == null)
                return head;
        }

        while (fast.next != null)
        {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null)
            head = head.next;
        else
            pre.next = slow.next;

        return head;




    }


    public static void main(String[] args){



        System.out.println(0);

    }



}
