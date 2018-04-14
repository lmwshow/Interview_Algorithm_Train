package leetgroup;

/**
 * Created by Gracecoder on 2017/3/28.
 */
public class swap_nodes_in_pairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null|| head.next == null)
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
        int time = length/2;                        //time 表示要翻转的段数
        tmp = head;

        for (int i = 0 ; i < time ; i ++)
        {
            for (int j = 1 ; j < 2 ; j ++)
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


    public ListNode recursionswapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
