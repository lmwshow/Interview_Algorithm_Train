package leetgroup;

/**
 * Created by Gracecoder on 2017/3/19.
 *
 * 3行递归
 */
public class remove_duplicates_from_sorted_list {

    public ListNode mydeleteDuplicates(ListNode head) {

        if (head == null||head.next == null)
            return head;

        ListNode prev,current;
        prev = head;
        current = head.next;
        while (current!= null)
        {
            if (prev.val == current.val)
                prev.next = current.next;

            else
                prev = current;

            current = current.next;
        }

        return head;
    }


    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
