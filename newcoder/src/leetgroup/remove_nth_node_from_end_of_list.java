package leetgroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/4/8.
 */
public class remove_nth_node_from_end_of_list {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        Map<Integer,ListNode> map = new HashMap<>();
        int i = 0;
        ListNode node = new ListNode(0);                //作为头结点
        node.next = head;
        ListNode tmp = node;
        while (tmp!=null)
        {
            map.put(i++,tmp);
            tmp = tmp.next;
        }

        ListNode rmNode = map.get(i-n);
        map.get(i-n-1).next = map.get(i-n+1);

        return node.next;

    }

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head =removeNthFromEnd(head,2);
        while (head!= null)
        {
            System.out.println(head.val);
            head = head.next;

        }
    }
}
