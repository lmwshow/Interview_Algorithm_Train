package alibaba;



public class Question148_链表排序 {

    //对于链表的O(nlogn)排序且是常数级空间复杂度，由于链表不能随机访问，所以不能使用快速排序，那就自然想到归并
    //那么对于链表，用归并排序的话，如何定位每一段的中间节点？  使用快慢指针。
    //归并思想第一步是把整个数组看成n个散列，在链表中真正体现了这种思想，首先就是需要拆分所有节点，然后合并

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode prev = null,slow = head,fast = head;        //定义前驱节点指针,快慢指针

        while (fast!=null&& fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;                                   //对前后点进行拆分，由于数组可以随机访问，所以隐藏了这个步骤

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return mergeList(left,right);
    }

    private ListNode mergeList(ListNode left, ListNode right) {

        if (left == null)
            return right;
        if (right == null)
            return left;

        ListNode res = new ListNode(0);                 //表示头结点
        ListNode tmp = res;

        while (left!=null && right!=null)
        {
            if (left.val < right.val)
            {
                tmp.next = left;
                left = left.next;
            }
            else
            {
                tmp.next = right;
                right = right.next;
            }

            tmp = tmp.next;

        }

        if (left == null) tmp.next = right;
        else tmp.next = left;

        return  res.next;

    }

}
