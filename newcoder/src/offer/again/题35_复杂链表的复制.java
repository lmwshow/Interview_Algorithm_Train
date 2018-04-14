package offer.again;

import offer.util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

//利用map 空间换时间， O(1)时间内找到 Random的副本
//还能优化，在不使用辅助空间的情况下，达到O(1)的效果，第一步复制的时候，将copyNode 连接到Node后面，这样copyNode的random 就在node的random的下一个节点，最后拆分为两个链表
public class 题35_复杂链表的复制 {

    public static RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;

        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode tmp  = pHead;

        while (tmp != null)
        {
            map.put(tmp,new RandomListNode(tmp.label));
            tmp = tmp.next;
        }
        
        tmp = pHead;
        RandomListNode cur = null;
        while (tmp != null)
        {
            cur = map.get(tmp);
            cur.next = map.get(tmp.next);
            cur.random = map.get(tmp.random);
            tmp = tmp.next;
        }
        
        return map.get(pHead);
        
    }
    
    public static void main(String[] args){
     
        RandomListNode head = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(2);
        RandomListNode node2 = new RandomListNode(3);
        RandomListNode node3 = new RandomListNode(4);
        head.next = node1;
        head.random = node2;
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node3;
        node3.random = node1;
        
        RandomListNode copy = Clone(head);
        
        System.out.println("");
        
    
    }
}
