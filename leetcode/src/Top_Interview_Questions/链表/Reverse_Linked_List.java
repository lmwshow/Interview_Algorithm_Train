package Top_Interview_Questions.链表;

/**
 * Created by Gracecoder on 2017/10/16.
 */
public class Reverse_Linked_List {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode node = new ListNode(0);

        while (head!=null)
        {
            ListNode cur = head;
            head = head.next;
            cur.next = node.next;
            node.next = cur;
        }

        return node.next;

    }
}
