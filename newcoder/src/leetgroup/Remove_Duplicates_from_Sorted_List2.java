package leetgroup;

/**
 * Created by Gracecoder on 2017/3/21.
 */
public class Remove_Duplicates_from_Sorted_List2 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode prev,current,currentIndex;             //currentIndex 表示当前要插入的位置的前缀
        prev = currentIndex =node;
        current = head;

        while (current.next!=null)
        {
            prev = current;
            current = current.next;
            if (prev.val == current.val) {
                while (current.next != null && prev.val == current.val) {
                    prev = current;
                    current = current.next;
                }
                currentIndex.next = (current.next == null && prev.val == current.val)? null:current;
                //如果current的后继是空，且当前点重复，那么就插入null，否则就插入当前点

            }
            else
                currentIndex = prev;
                //不重复的插入后，当前插入位置的前缀，要变成该不重复点的前缀

        }

        return node.next;

    }
}
