package leetgroup.排序;

/**
 * Created by Gracecoder on 2017/8/22.
 *
 * 插入排序
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class insertion_sort_list {

    public static ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;

        ListNode node = new ListNode(0);            //作为头指针
        node.next = head;
        ListNode cur = head;
        ListNode insertPositon = node;

        while (cur.next!=null)
        {
            ListNode tmp = cur.next;

            while (insertPositon.next!=tmp && tmp.val > insertPositon.next.val)
                    insertPositon = insertPositon.next;

            if (insertPositon.next != tmp) {
                cur.next = tmp.next;
                tmp.next = insertPositon.next;
                insertPositon.next = tmp;
            }
            else
                cur = tmp;

            insertPositon = node;

        }

        return node.next;
    }



    public static void main(String[] args){

        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(0);

        head = insertionSortList(head);

        while (head!=null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
