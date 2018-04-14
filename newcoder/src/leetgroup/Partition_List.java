package leetgroup;

/**
 * Created by Gracecoder on 2017/3/20.
 */
public class Partition_List {

    public static ListNode mypartition(ListNode head, int x) {

        if (head == null || head.next == null)
            return head;

        ListNode node  = new ListNode(0);           //头结点
        node.next = head;
        ListNode prev,current,partition;
        prev = current =  node;
        partition = node;
        while (current.next!=null)
        {
            prev = current;
            current = current.next;
            if (current.val < x)
            {
                prev.next = current.next;
                current.next = partition.next;
                partition.next = current;

                partition = current;
            }
        }

        return head;
    }

    public static ListNode partition(ListNode head, int x)
    {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);           //构建两个链表，遍历一次原链表 ，一个存小，一个存大，故弄两个头结点

        ListNode tmp1,tmp2;
        tmp1 = node1;
        tmp2 = node2;
        while (head!=null)
        {
            if (head.val < x)
            {
                tmp1.next = head;
                tmp1 = tmp1.next;
            }
            else
            {
                tmp2.next = head;
                tmp2 = tmp2.next;
            }
            head = head.next;
        }

        tmp2.next = null;
        tmp1.next = node2.next;

        return node1.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);

        partition(head,3);
        while (head!= null)
        {
            System.out.println(head.val);
            head = head.next;

        }

    }
}
