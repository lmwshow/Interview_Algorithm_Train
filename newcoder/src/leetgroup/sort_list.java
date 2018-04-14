package leetgroup;

/**
 * Created by Gracecoder on 2017/3/10.
 */

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

  class Node{
      ListNode node;

      public Node(ListNode node) {
          this.node = node;
      }
  }

public class sort_list {

    public static void quickSort(Node[] list,int left,int right)
    {
        int i,j;
        Node temp,t;
        if (left > right)
            return;

        temp = list[left];
        i = left;
        j = right;

        while (i!=j)
        {
            while (list[j].node.val>=temp.node.val && i<j)
                j--;
            while (list[i].node.val<=temp.node.val && i<j)
                i++;


            if (i < j)
            {
                t = list[i];
                list[i] = list[j];
                list[j] = t;
            }
        }

        list[left] = list[i];
        list[i] = temp;

        quickSort(list,left,i-1);
        quickSort(list,i+1,right);
        return;

    }

    public static ListNode sortListByquickSort(ListNode head) {
        if (head == null || head.next ==null)
            return head;
        int length = 1;
        ListNode tmp = head;
        while (tmp.next!=null)
        {
            tmp = tmp.next;
            length++;
        }



        Node[] list = new Node[length];
        tmp = head;
        for (int i = 0 ; i < list.length; i ++)
        {
            list[i] = new Node(tmp);
            tmp = tmp.next;
        }

        quickSort(list,0,list.length-1);
        tmp =list[0].node;
        head = tmp;
        for (int i =1 ; i < list.length ; i++) {
            tmp.next = list[i].node;
            tmp = tmp.next;
        }
        tmp.next = null;
        return head;

    }


    //合并排序
    public static ListNode merge(ListNode left,ListNode right)
    {
        if (left == null) return right;
        if (right == null) return left;

        ListNode res = new ListNode(0);             //表示下头指针，让下面while方便写
        ListNode tmp = res;
        while (left!=null && right!=null)
        {
            if (left.val < right.val)
            {
                tmp.next = left;
                tmp = tmp.next;
                left = left.next;
            }
            else {
                tmp.next = right;
                tmp = tmp.next;
                right = right.next;
            }
        }

        if (left == null) tmp.next = right;
        else tmp.next = left;

        res = res.next;
        return res;
    }

    public static ListNode sortList(ListNode head)
    {
        if (head==null || head.next == null)
            return head;

        ListNode prev=null,slow=head,fast=head;             //快慢指针找到中间节点，慢的走一步，快的走两步，当快的到达最后，慢的会在中间
        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;                                   //进行分割

        ListNode left = sortList(head);                     //递归前半段排序
        ListNode right = sortList(slow);                    //递归后半段排序

        return merge(left,right);



    }

    public static void main(String[] args){

        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head = sortList(head);
        while (head!= null)
        {
            System.out.println(head.val);
            head = head.next;

        }
    }
}
