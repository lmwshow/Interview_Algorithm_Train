package leetgroup;

/**
 * Created by Gracecoder on 2017/3/14.
 */
public class linked_list_cycle {

    public boolean myHasCycle(ListNode head) {

        if (head == null)
            return false;
        ListNode currentNode = head;
        
        while (currentNode.next!=null) {
            if (currentNode.next == currentNode)
                return true;
            else {
                ListNode tmp = currentNode;
                currentNode = currentNode.next;
                tmp.next = tmp;
            }
        }
        
        return false;
    }


    /*
     用快慢指针遍历，有环的话 快指针顶多一圈就能追上慢指针， 没环，快指针也能更快遍历完单链表
     */
    public static boolean hasCycle(ListNode head)
    {
        if (head == null)
            return false;
        ListNode slow,fast;
        slow = fast = head;
        while (fast!=null &&fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }

        return false;
    }

    
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        boolean res = hasCycle(head);
        System.out.println(res);

    }

}
