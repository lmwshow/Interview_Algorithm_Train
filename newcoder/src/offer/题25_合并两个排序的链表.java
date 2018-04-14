package offer;

import offer.util.ListNode;

/**
 * Created by Gracecoder on 2017/12/21.
 */
public class 题25_合并两个排序的链表 {

    public static ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        ListNode res = new ListNode(0);
        ListNode tmp = res;

        while (list1 != null && list2 != null)
        {
            if (list1.val <= list2.val)
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

        if (list1 != null)
            tmp.next = list1;
        else
            tmp.next = list2;

        return res.next;


    }

    public static void main(String[] args){

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(9);
        list1 = null;
        ListNode list2 = new ListNode(0);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(8);
        list2 = null;

        ListNode res = Merge(list1,list2);

        while (res!=null)
        {
            System.out.println(res.val);
            res = res.next;

        }

    }
}
