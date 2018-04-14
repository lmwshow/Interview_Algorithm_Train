package offer;

import hihocoder.util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class 题52_两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null)
            return null;

        Map<ListNode,Boolean> map = new HashMap<>();
        ListNode tmp = pHead1;

        while (tmp!=null) {
            map.put(tmp,true);
            tmp = tmp.next;
        }

        tmp = pHead2;

        while (tmp != null)
        {
            if (map.containsKey(tmp))
                return tmp;
            tmp = tmp.next;
        }

        return null;

    }
}
