package offer;

import offer.util.ListNode;

import java.util.ArrayList;

/**
 * Created by Gracecoder on 2017/12/5.
 */


public class 题6_从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> res = new ArrayList<>();

        if (listNode == null)
            return res;

        ListNode tmp = listNode;

        while (tmp!=null)
        {
            res.add(0,tmp.val);
            tmp = tmp.next;
        }


        return res;

    }
}
