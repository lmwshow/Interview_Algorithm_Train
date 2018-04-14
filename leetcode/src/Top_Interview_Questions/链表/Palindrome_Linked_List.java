package Top_Interview_Questions.链表;

/**
 * Created by Gracecoder on 2017/10/20.
 *
 * 取一半 可以使用fast 和 slow 指针，  更清晰
 */
public class Palindrome_Linked_List {

     static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {


        if (head == null || head.next == null)
            return true;
        int len = 0;
        ListNode tmp = head;
        while (tmp != null)
        {
            len++;
            tmp = tmp.next;
        }

        int half = len/2;
        tmp = head;
        for (int i = 0 ; i < half-1 ; i++)
            tmp = tmp.next;



        ListNode node = new ListNode(0);
        node.next = tmp.next;
        tmp.next = null;
        ListNode cur = null;
        tmp = node.next;
        while (tmp != null)
        {
            cur = tmp;
            tmp = tmp.next;
            cur.next = node.next;
            node.next = cur;
        }

        node = node.next;

        while (head!=null)
        {
            if (head.val != node.val)
                return false;
            head = head.next;
            node = node.next;
        }

        return true;
    }

    public static void main(String[] args){

        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);

        System.out.println(isPalindrome(node));


    }

}
