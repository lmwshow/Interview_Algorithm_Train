package offer2;

import offer2.util.ListNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/22 07:45
 * @Description: https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class 删除链表中重复的结点 {


    public static ListNode deleteDuplication(ListNode pHead)
    {

        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode ans =  new ListNode(pHead.val - 1 ); //表示头结点
        ListNode pre = ans;

        ListNode cur = pHead;
        while (cur != null)
        {
            if ((cur.next == null||cur.val!=cur.next.val))
            {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
            else
            {
                while (cur.next!=null && cur.val == cur.next.val)
                    cur = cur.next;

                cur = cur.next;

            }
        }

        pre.next = null;

        return ans.next;

    }

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        ListNode ans = deleteDuplication(head);

        System.out.println("");
    }
}
