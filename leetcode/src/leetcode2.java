import java.util.Objects;

/**
 * Created by limingwei on 16/12/6.
 */


class ListNode
{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class leetcode2 {

    //这样先将L1 L2 转化为整形num1,num2  但是相加超过了int型的范围
    //需要用long , java中没有int64 , long对于C中的int64
    //但是即使long 也无法满足大数相加
    public static ListNode errorFunc(ListNode l1, ListNode l2) {
        long num1 = l1.val;
        int count = 0;
        while(l1.next != null)
        {
            count++;
            num1 = num1 + l1.next.val*(long)Math.pow(10,count);
            l1 = l1.next;
        }

        long num2 = l2.val;
        count = 0;
        while(l2.next != null)
        {
            count++;
            num2 = num2 + l2.next.val*(long)Math.pow(10,count);
            l2 = l2.next;
        }

        long sum = num1 + num2;
        long mod = sum % 10;


        ListNode listNode = new ListNode((int)mod);
        ListNode node = listNode;
        while (sum / 10 != 0)
        {
            sum = sum / 10;
            mod = sum % 10;
            node.next = new ListNode((int)mod);
            node = node.next;
        }
        node.next = null;
        return listNode;
    }

    /**
     * 链表相加的思路
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2)
    {
        int res = 0;
        int add ;
        res = (l1.val + l2.val)%10;
        add = (l1.val + l2.val)/10;
        ListNode listNode = new ListNode(res);
        ListNode node = listNode;
        while (l1.next != null && l2.next !=null)
        {
            l1 = l1.next;
            l2 = l2.next;
            res = (l1.val + l2.val + add)%10;
            add = (l1.val + l2.val + add)/10;
            node.next = new ListNode(res);
            node = node.next;
        }
        ListNode l3 = l1.next == null ? l2:l1;
        while (l3.next != null)
        {
            if (add == 0)
            {
                node.next = l3.next;
                return listNode;
            }else {
                l3 = l3.next;
                res = (l3.val + add)%10;
                add = (l3.val + add)/10;
                node.next = new ListNode(res);
                node = node.next;
            }
        }

        if (add != 0)
        {
            node.next = new ListNode(add);
            node = node.next;
        }
        node.next = null;
        return listNode;
    }

    //简洁的写法
    public static ListNode solution(ListNode l1, ListNode l2)
    {
        ListNode ln1 =l1,ln2 =l2,head =null , node = null;
        int carry = 0, remainder = 0 , sum = 0;
        head = node = new ListNode(0);

        while (ln1 != null || ln2 != null || carry !=0)
        {
            sum = (ln1 != null? ln1.val:0) + (ln2 != null? ln2.val:0) +carry ;
            remainder = sum %10;
            carry = sum/10;
            node.next = new ListNode(remainder);
            node = node.next;

            ln1 = (ln1== null? null:ln1.next);
            ln2 = (ln2== null? null:ln2.next);
        }
        return head.next;
    }




    public static void main(String[] args){
        ListNode node1 = new ListNode(9);
//        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(3);
//        node1.next.next.next = null;
        node1.next = null;

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(9);
        node2.next.next.next = new ListNode(9);
        node2.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next.next.next.next = null;

        ListNode res = solution(node1, node2);
        System.out.println(res.val);
        while (res.next != null) {

            System.out.println(res.next.val);
            res = res.next;
        }



        ListNode node = new ListNode(0);
        System.out.println();

    }
    
}


