package Top_Interview_Questions_2.链表;

import Top_Interview_Questions_2.util.ListNode;

public class Question142_环形链表II {

    public static ListNode detectCycle(ListNode head) {

        if (head == null)
            return null;


        ListNode slow = head;
        ListNode fast = head;
        ListNode curNode = head;

        while (fast.next!=null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (curNode!=slow)
                {
                    curNode = curNode.next;
                    slow = slow.next;
                }

                return curNode;
            }

        }

        return null;
    }

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = head;
        System.out.println(detectCycle(head
        ));


    }

}
