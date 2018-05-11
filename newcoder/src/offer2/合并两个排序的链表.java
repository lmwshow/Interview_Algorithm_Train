package offer2;

import offer2.util.ListNode;

/**
 * @Auther: minGW
 * @Date: 2018/5/11 07:57
 * @Description:
 */
public class 合并两个排序的链表 {

    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null)
            return null;

        if (list1 == null || list2 == null)
            return list1 == null? list2: list1;

        ListNode ans = new ListNode(0); //头结点
        ListNode tmp = ans;
        while (list1 != null && list2 != null)
        {
            if (list1.val < list2.val)
            {
                tmp.next = list1;
                list1 = list1.next;
            }else
            {
                tmp.next = list2;
                list2 = list2.next;
            }

            tmp = tmp.next;
        }

        tmp.next = (list1 == null?list2:list1);

        return ans.next;
    }
}
