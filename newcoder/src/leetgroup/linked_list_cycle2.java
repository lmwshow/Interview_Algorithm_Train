package leetgroup;

/**
 * Created by Gracecoder on 2017/3/15.
 * 这题的难点是：不能改变原有链表
 *
 * myDetectCycle：先使用快慢指针判断是否有环，如果有环，说明fast追上slow。 此时slow和fast必在环上
 *                然后外层循环从head开始遍历，内层不断遍历slow一圈，直到有一个点接触到环，那么它就是环起点
 *
 * DetectCycle：
 *              my solution is like this: using two pointers, one of them one step at a time. another pointer each take two steps. Suppose the first meet at step k,the length of the Cycle is r. so..2k-k=nr,k=nr
                Now, the distance between the start node of list and the start node of cycle is s. the distance between the start of list and the first meeting node is k(the pointer which wake one step at a time waked k steps).the distance between the start node of cycle and the first meeting node is m, so...s=k-m,
                s=nr-m=(n-1)r+(r-m),here we takes n = 1..so, using one pointer start from the start node of list, another pointer start from the first meeting node, all of them wake one step at a time, the first time they meeting each other is the start of the cycle.

                首先先用快慢指针得到环上meet点，假设走了k步，那么快指针就走了2k步， r表示环的长度, m表示环起点到meet点的距离，s表示链表起点离环起点的距离。
                可得：             2k - k = n*r ,n=0,1...  ==> k = n * r
                                  s = k - m = n*r - m = (n-1)*r + (r-m)         这里r-m 就是meet点到环起点的距离， 也就是说s 刚好是环长度的倍数 + meet点到环结束剩余的距离
                可以推出，链表起点 和 meet点 同时向前一步一步走， 第一个交点就是 环起点
 *
 */
public class linked_list_cycle2 {

    public static ListNode myDetectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow,fast,currentNode;
        slow = fast = currentNode =head;
        while (fast!=null &&fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
            {
                for (;;currentNode=currentNode.next) {
                    if (slow == currentNode)
                        return currentNode;
                    for (slow = slow.next; slow!= fast; slow = slow.next)
                        if (currentNode == slow)
                            return currentNode;
                }

            }
        }

        return null;
    }

    public static ListNode detectCycle(ListNode head)
    {
        if (head == null)
            return null;
        ListNode slow,fast,currentNode;
        slow = fast = currentNode =head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
            {
                while (currentNode!=slow)
                {
                    currentNode = currentNode.next;
                    slow = slow.next;
                }
                return currentNode;
            }
        }
        return null;
    }



    
    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;
        
        ListNode res = detectCycle(head);
        System.out.println(res.val);
        
    
    }
}
