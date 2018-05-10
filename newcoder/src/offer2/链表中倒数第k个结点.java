package offer2;

import offer2.util.ListNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/10 08:10
 * @Description: https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1
 *
 * 使用快慢节点，快节点先走k步，然后快慢节点一起遍历
 */
public class 链表中倒数第k个结点 {

    public ListNode FindKthToTail(ListNode head, int k) {

        ListNode slow = head,fast = head;

        for (int i = 0 ; i < k ; i++)
        {
            if (fast == null)
                return null;
            fast = fast.next;
        }

        while (fast != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
