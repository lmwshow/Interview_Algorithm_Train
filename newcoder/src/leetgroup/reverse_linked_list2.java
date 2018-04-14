package leetgroup;

/**
 * Created by Gracecoder on 2017/3/17.
 */
public class reverse_linked_list2 {

    public static ListNode reverse(ListNode head)
    {
        ListNode node = new ListNode(0);        //表示头指针，方便翻转

        node.next = head;
        ListNode tmp,current;
        tmp = current =head;
        while (tmp.next != null)
        {
            current = tmp.next;
            tmp.next = current.next;
            current.next = node.next;
            node.next = current;
        }

        return node.next;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (n == m)
            return head;
        ListNode left,middle,right,tmp,prev,k;
        left = tmp = prev = head;
        int i = 0;
        for (; i < m - 1 ; i ++) {
            prev = tmp;
            tmp = tmp.next;
        }
//        prev.next = null;
        left = prev;
        middle = tmp;
        k = middle;

        for (;i < n; i ++)
        {
            prev = tmp;
            tmp = tmp.next;
        }

        prev.next = null;
        right = tmp;
//        tmp = prev;

        middle = reverse(middle);

        left.next = middle;
        k.next = right;


        return head;



    }

    public static ListNode solution(ListNode head, int m, int n) {

        if (n == m)
            return head;


        ListNode prev, current;
        prev = current =head;
        if (m == 1) {                                   // 为链表设置个头结点， 更容易操作
            prev = new ListNode(0);
            prev.next = head;
            head = prev;
        }

        int i =1;
        for (;i<m;i++)
        {
            prev = current;
            current = current.next;
        }
        ListNode tmp = current;

        while (i++!=n)
        {
            current = tmp.next;
            tmp.next = current.next;
            current.next = prev.next;
            prev.next = current;


        }

        if (m == 1)
            return head.next;
        return head;



    }


    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head =solution(head,1,2);
        while (head!= null)
        {
            System.out.println(head.val);
            head = head.next;

        }
    }
}
