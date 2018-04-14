package leetgroup;

/**
 * Created by Gracecoder on 2017/3/27.
 */
public class reverse_nodes_in_k_group {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null|| head.next == null || k == 0 || k ==1)
            return head;

        int length = 0;
        ListNode tmp = head,current = head,node = new ListNode(0);
        node.next = head;
        ListNode nodeTmp = node;
        while (tmp!=null)
        {
            length++;
            tmp = tmp.next;
        }
        int time = length/k;                        //time 表示要翻转的段数
        tmp = head;

        for (int i = 0 ; i < time ; i ++)
        {
            for (int j = 1 ; j < k ; j ++)
            {
                current = tmp.next;
                tmp.next = current.next;
                current.next = nodeTmp.next;
                nodeTmp.next = current;

            }

            nodeTmp = tmp;                          //头结点要不断更新为前一段的最末点
            tmp = tmp.next;
        }

        return node.next;
    }


    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head =reverseKGroup(head,2);
        while (head!= null)
        {
            System.out.println(head.val);
            head = head.next;

        }
    }
}
