package leetgroup;

/**
 * Created by Gracecoder on 2017/3/15.
 * 将链表倒数第n个开始翻转到前面，如果n>length 要取余，周而复始
 */
public class rotate_list {
    public static ListNode rotateRight(ListNode head, int n) {


        if (head == null || n == 0 )
            return head;

        int length = 0 ;
        ListNode tmp = head;
        while (tmp!=null)
        {
            length++;
            tmp = tmp.next;
        }

        n = n%length;
        if (n == 0)
            return head;

        ListNode prev = head;
        tmp = head;
        for (int i = 0 ; i < length-n; i ++)
        {
            prev = tmp;
            tmp = tmp.next;
        }

        prev.next = null;
        prev = head;
        head = tmp;
        while (tmp.next!=null)
            tmp = tmp.next;
        tmp.next = prev;

        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = rotateRight(head,2);

        while (head!=null)
        {
            System.out.println(head.val);
            head = head.next;

        }
    }
}
