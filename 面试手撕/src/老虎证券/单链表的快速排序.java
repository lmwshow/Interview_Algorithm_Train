package 老虎证券;

/**
 * @Auther: minGW
 * @Date: 2018/8/29 13:10
 * @Description:
 */
public class 单链表的快速排序 {


    class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    /*
    只需要两个指针p1和p2，这两个指针均往next方向移动，
    移动的过程中保持p1之前的key都小于选定的key，p1和p2之间的key都大于选定的key，那么当p2走到末尾时交换p1与key值便完成了一次切分。
     */
    public ListNode sortList(ListNode head)
    {
        //采用快速排序
        quickSort(head,null);
        return head;
    }

    private void quickSort(ListNode head, ListNode end) {

        if (head!=end)
        {
            //找出划分点
            ListNode node = partition(head,end);
            quickSort(head, node);
            quickSort(node.next, end);

        }
    }

    private ListNode partition(ListNode head, ListNode end) {

        ListNode p1 = head,p2 = head.next;

        while (p2 != end)
        {
            //小于key值时，p1向前走一步，交换p1与p2的值
            if (p2.val < head.val)
            {
                p1 = p1.next;

                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }

        //当有序时，不交换p1和key值
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }
}
