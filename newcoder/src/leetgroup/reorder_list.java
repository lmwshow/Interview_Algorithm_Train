package leetgroup;

/**
 * Created by Gracecoder on 2017/3/13.
 *
 * 指针问题，就算new出新指针tmp做临时变量，对tmp的改变会同时改掉原指针，因为它们本身指向同一内存地址
 */
public class reorder_list {

    public static ListNode reverseList(ListNode head)
    {
        if (head == null || head.next ==null)
            return head;

        ListNode prev=null,slow = head, fast = head;
        while (fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = reverseList(head);
        head = reverseList(slow);

        return reverseCat(left,head);
    }

    private static ListNode reverseCat(ListNode left, ListNode right) {

        if (left == null) return right;
        if (right == null)  return left;

        ListNode tmp = right;
        while (tmp.next != null)
            tmp = tmp.next;

        tmp.next = left;

        return right;
    }


    public static void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return ;


        //利用快慢指针，找到中间点
        ListNode slow,fast;
        slow = head;
        fast = head;
        while (fast!=null && fast.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //对后半段进行倒序，临时变量tmp指向的地址和原指针一样，对临时变量的操作会直接影响到原指针， tmp只是起到记录位置的作业
        //由于倒序，后面一个永远是插到第一个元素之前，故需要知道第一个元素的前缀指针
        ListNode prevNode = slow;
        ListNode prevCurrentNode = slow.next;
        while (prevCurrentNode.next != null)
        {
            ListNode currentNode = prevCurrentNode.next;
            prevCurrentNode.next = currentNode.next;
            currentNode.next = prevNode.next;
            prevNode.next = currentNode;

        }

        //Find the middle of the list
        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        //换位置时，一定要处理好前驱后继指针，避免错乱 或是 丢失后面的数据
        ListNode left = head;
        ListNode right = prevNode.next;
        while (left!=prevNode && right != null)
        {
            prevNode.next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = prevNode.next;
        }

    }

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reorderList(head);
        while (head!= null)
        {
            System.out.println(head.val);
            head = head.next;

        }
    }


}
