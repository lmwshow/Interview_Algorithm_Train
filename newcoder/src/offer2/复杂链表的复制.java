package offer2;

import offer2.util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: minGW
 * @Date: 2018/5/12 10:29
 * @Description: https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=2&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class 复杂链表的复制 {


    //不使用辅助空间的巧思秒想，先在同一链表上复制再拆分
    //比如 ： ABCD -> A1A2B1B2C1C2D1D2   再拆分出来，这样的好处是 A2.random = A1.random.next 可以不需要额外空间就找到random指向

    public static RandomListNode Best_Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return pHead;

        RandomListNode cur = pHead;
        RandomListNode copy = null;

        //copy,直接在每个节点后复制一个，设置next，保持链表连接
        while (cur != null)
        {
            copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next =copy;

            cur = copy.next;
        }

        //设置random指针
        cur = pHead;
        while (cur!=null)
        {
            cur.next.random = (cur.random == null)?null:cur.random.next;
            cur = cur.next.next;
        }

        //拆分
        RandomListNode ans = pHead.next;
        copy = ans;
        cur = pHead;
        while (cur!=null)
        {
            cur.next = cur.next.next;
            copy.next =copy.next == null? null:copy.next.next;

            cur = cur.next;
            copy = copy.next;
        }

        return ans;

    }

    /*
    使用辅助空间Map
     */
    public static RandomListNode Clone(RandomListNode pHead)
    {

        if (pHead == null)
            return pHead;

        Map<RandomListNode,RandomListNode> randomListNodeRandomListNodeMap = new HashMap<>();

        RandomListNode cur = pHead;
        while (cur!=null) {
            randomListNodeRandomListNodeMap.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = pHead;
        while (cur!=null)
        {
            randomListNodeRandomListNodeMap.get(cur).next = randomListNodeRandomListNodeMap.get(cur.next);
            randomListNodeRandomListNodeMap.get(cur).random = randomListNodeRandomListNodeMap.get(cur.random);
            cur = cur.next;
        }

        RandomListNode ans = randomListNodeRandomListNodeMap.get(pHead);

        return ans;


    }

    public static void main(String[] args){

        RandomListNode phead = new RandomListNode(1);
        phead.next = new RandomListNode(2);
        phead.next.next = new RandomListNode(3);

        RandomListNode ans = Best_Clone(phead);

        while (ans!=null)
        {
            System.out.println(ans.label);
            ans = ans.next;
        }

    }
}
