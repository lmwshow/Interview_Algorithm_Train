package offer2;

import offer2.util.ListNode;

import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/5/17 08:54
 * @Description: https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class 两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null)
            return null;

        int len1 = 0,len2 = 0;
        ListNode cur1 = pHead1,cur2 = pHead2;
        while (cur1!=null)
        {
            len1++;
            cur1 = cur1.next;
        }

        while (cur2!=null)
        {
            len2 ++;
            cur2 = cur2.next;
        }

        int diff = Math.abs(len1 - len2);
        cur1 = pHead1;
        cur2 = pHead2;
        if (len1 > len2)
            for (int i = 0 ; i <diff ; i++)
                cur1 = cur1.next;
        else
            for (int i = 0 ; i <diff ; i++)
                cur2 = cur2.next;


        while (cur1 != cur2)
        {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;


    }
}
