package leetgroup;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gracecoder on 2017/3/28.
 */
public class merge_k_sorted_list {

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        ListNode left,right;
        left = mergeKLists(Arrays.copyOfRange(lists,0,lists.length/2));
        right =mergeKLists(Arrays.copyOfRange(lists,lists.length/2,lists.length));
        return mergeTwoLists(left,right);
    }

    public static ListNode mergeTwoLists(ListNode l1,ListNode l2)
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

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {

        ListNode[] tarlist = new ListNode[lists.size()];                //先将list转化为数组
        lists.toArray(tarlist);
        return mergeKLists(tarlist);

    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(6);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(5);

        ListNode node3 = new ListNode(4);
        node3.next = new ListNode(7);

        ListNode[] list = new ListNode[]{node1,node2,node3};
        ArrayList<ListNode> list1 = new ArrayList<>();
        list1.add(node1);
        list1.add(node2);
        list1.add(node3);

//        ArrayList<ListNode> list2 = (ArrayList<ListNode>) list1.subList(0,2);


        ListNode head = mergeKLists(list1);

        while (head!= null)
        {
            System.out.println(head.val);
            head = head.next;

        }



    }
}
