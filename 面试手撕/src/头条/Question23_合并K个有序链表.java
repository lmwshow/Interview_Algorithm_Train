package 头条;

import Top_Interview_Questions_2.util.ListNode;


//利用归并思想
public class Question23_合并K个有序链表 {

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        ListNode node = new ListNode(0);

        mergeSort(lists,0,lists.length-1,node);

        return lists[0];

    }

    private static void mergeSort(ListNode[] lists, int left, int right, ListNode node) {

        if (left < right)
        {
            int mid = ((right - left) >> 1) + left;
            mergeSort(lists,left,mid,node);
            mergeSort(lists,mid+1,right,node);
            mergeArray(lists,left,mid,right,node);
        }
    }

    private static void mergeArray(ListNode[] lists, int left, int mid, int right, ListNode node) {

        ListNode l = lists[left];
        ListNode r = lists[mid+1];
        ListNode tmp = node;

        while (l!=null && r!=null)
        {
            if (l.val < r.val)
            {
                tmp.next = l;
                l = l.next;
            }
            else
            {
                tmp.next = r;
                r = r.next;
            }

            tmp = tmp.next;
        }

        tmp.next = (l==null)?r:l;

        lists[left] = node.next;
        node.next = null;


    }


    public static void main(String[] args){

        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(8);

        ListNode list3 = new ListNode(4);
        list3.next = new ListNode(7);
        list3.next.next = new ListNode(10);

        ListNode list4 = null;


        ListNode[] lists = new ListNode[]{list1,list2,list3,list4};

        ListNode node = mergeKLists(lists);

        while (node!=null)
        {
            System.out.println(node.val);
            node = node.next;
        }

        return;

    }
}
