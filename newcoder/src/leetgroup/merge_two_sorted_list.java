package leetgroup;

/**
 * Created by Gracecoder on 2017/3/16.
 *
 * 两个顺序表的合并
 *
 * 递归方法
 */
public class merge_two_sorted_list {

    public ListNode mymergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode res,tmp;
//        res = l1.val<l2.val? l1:l2;
        if (l1.val<l2.val)
        {
            res = l1;
            l1 = l1.next;
        }
        else
        {
            res = l2;
            l2 = l2.next;
        }
        tmp = res;
        while (l1!=null && l2!=null)
        {
            if (l1.val<l2.val)
            {
                tmp.next = l1;
                tmp = l1;
                l1 = l1.next;
            }
            else
            {
                tmp.next = l2;
                tmp = l2;
                l2 = l2.next;
            }

        }

        if (l1 == null)
            tmp.next = l2;
        else
            tmp.next = l1;

        return res;


    }


    public ListNode mergeTwoLists(ListNode l1,ListNode l2)
    {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if(l1.val < l2.val)
        {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }


}
