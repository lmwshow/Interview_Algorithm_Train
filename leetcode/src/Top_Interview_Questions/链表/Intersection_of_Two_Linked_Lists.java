package Top_Interview_Questions.链表;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gracecoder on 2017/10/13.
 *
 * 题意：在时间O(n) 内存O(1)内找出两个链表的交叉点
 *
 * O(1)：预处理长度
 *
 * bestway: Java solution without knowing the difference in len!
 * 两次迭代：
 * 遍历第一条链表到尾部时，使指针指向另一条链条的头部，继续遍历
 * 同样这样遍历第二条，那么他们同时遍历  在0（m+n+1）内必然能到达交叉点。
 */
public class Intersection_of_Two_Linked_Lists {

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Map<ListNode,Integer> map =new HashMap<>();             //用map 不是O(1)
        ListNode tmp = headA;
        while (tmp != null)
        {
            map.put(tmp,1);
            tmp = tmp.next;
        }

        tmp = headB;
        while (tmp != null)
        {
            if (map.containsKey(tmp))
                return tmp;
            else
                map.put(tmp,1);

            tmp = tmp.next;
        }

        return null;
    }
}
